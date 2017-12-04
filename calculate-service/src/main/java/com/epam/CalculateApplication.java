package com.epam;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CalculateApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateApplication.class);
    private static final int DEFAULT_PADDING = 50;

    public static void main(String[] args) {
        LOGGER.info(StringUtils.center("Starting", DEFAULT_PADDING, "="));
        SpringApplication.run(CalculateApplication.class, args);
        LOGGER.info(StringUtils.center("Started", DEFAULT_PADDING, "="));
    }
}