import java.nio.file.Files
import java.util.stream.Collectors

def props = [:]
props.group = ask("Define value for 'group' [com.epam]: ", "com.epam", "group")
props.version = ask("Define value for 'version' [0.0.1]: ", "0.0.1", "version")
props.pkg = ask("Define value for 'group' [com.epam]: ", props.group)
props.projectName = projectDir.name

//заменяем точки на слэши
String packageDir = props.pkg.replaceAll(/\./, '/')
//переносим исходник в нужную директорию
def project = projectDir.toPath()

def files = Files.find(project, 5, {path, attr -> (path.getFileName().toString() == '$pkg') })
        .collect(Collectors.toList())

files.forEach({path ->
    def dest = path.parent.resolve(packageDir)
    println dest
    Files.createDirectories(dest.parent)
    Files.move(path, dest)
})

//обрабатываем шаблон
processTemplates 'src/main/java/**/*.java', props

processTemplates "build.gradle", props
processTemplates "README.md", props
processTemplates "Dockerfile", props

def settingsFile = new File(projectDir.parentFile, 'settings.gradle')
if (settingsFile.exists()) {
    def lines = settingsFile.readLines()
    def endLine = lines.findIndexOf {line -> line.startsWith('//## end includes ######')}
    if (endLine > 0) {
        lines = lines.plus(endLine, "include '${props.projectName}'")
        settingsFile.text = lines.join("\n")
    }
}

processTemplates 'rebuild', props
def rebuildScriptPath = projectDir.parentFile.toPath().resolve("rebuild-${props.projectName}")
Files.move(project.resolve('rebuild'), rebuildScriptPath)
