package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    public static Logger logger;

    @BeforeAll
    public static void runLogger() {
        logger = Logger.INSTANCE;
    }

    @Test
    void testGetLastLog() {
        logger.log("Hello friend");
        System.out.println(logger.getLastLog());
        logger.log("Hello dear");
        System.out.println(logger.getLastLog());
        logger.log("Hello world");
        System.out.println(logger.getLastLog());
        logger.log("Run new program");
        System.out.println(logger.getLastLog());
        logger.log("Close new program");
        System.out.println(logger.getLastLog());
        logger.log("Shutdown PC");
        System.out.println(logger.getLastLog());
    }
}
