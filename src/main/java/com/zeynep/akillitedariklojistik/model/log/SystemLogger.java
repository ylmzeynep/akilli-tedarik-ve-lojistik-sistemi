package com.zeynep.akillitedariklojistik.model.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SystemLogger {

    private static SystemLogger instance;

    private SystemLogger() {

    }

    public static SystemLogger getInstance() {

        if (instance == null) {
            instance = new SystemLogger();
        }

        return instance;
    }

    public void log(String message) {

        String logMessage =
                "[LOG] "
                        + LocalDateTime.now()
                        + " - "
                        + message;

        System.out.println(logMessage);

        try (FileWriter writer = new FileWriter("system-log.txt", true)) {

            writer.write(logMessage + System.lineSeparator());

        } catch (IOException e) {

            System.out.println("Log dosyasına yazılamadı: " + e.getMessage());
        }
    }
}