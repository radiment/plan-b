package com.epam;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionApplication.class);
    private static final int DEFAULT_PADDING = 50;

    public static void main(String[] args) {
        LOGGER.info(StringUtils.center("Starting", DEFAULT_PADDING, "="));
        SpringApplication.run(TransactionApplication.class, args);
        LOGGER.info(StringUtils.center("Started", DEFAULT_PADDING, "="));
    }
}