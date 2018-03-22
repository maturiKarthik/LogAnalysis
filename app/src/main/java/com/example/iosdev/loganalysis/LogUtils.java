package com.example.iosdev.loganalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by iosdev on 22/03/2018.
 */

public class LogUtils {

    public static StringBuilder readLogs() {
        StringBuilder logBuilder = new StringBuilder();
        try {




           // Process TO READ THE LOGCAT LOGS..
           Process process = Runtime.getRuntime().exec(new String[]{"logcat", "-d"});
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                logBuilder.append(line + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logBuilder;
    }


}
