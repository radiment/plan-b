package com.epam.discovery;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryApplication.class);
    private static final int DEFAULT_PADDING = 50;

    public static void main(String[] args) {
        LOGGER.info(StringUtils.center("Starting", DEFAULT_PADDING, "="));
        SpringApplication.run(DiscoveryApplication.class, args);
        LOGGER.info(StringUtils.center("Started", DEFAULT_PADDING, "="));
    }
}