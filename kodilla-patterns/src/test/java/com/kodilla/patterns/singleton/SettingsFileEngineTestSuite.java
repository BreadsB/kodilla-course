package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        SettingsFileEngine.INSTANCE.close();
    }

    @Test
    void testGetFileName() {
        //GIVEN
        //WHEN
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);
        //THEN
        Assertions.assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        boolean result = settingsFileEngine.loadSettings();
        Assertions.assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        boolean result = settingsFileEngine.saveSettings();
        Assertions.assertTrue(result);
    }
}
