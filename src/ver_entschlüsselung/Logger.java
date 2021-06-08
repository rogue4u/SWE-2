package ver_entschlüsselung;

import java.io.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

//Class for Easy Logging
public class Logger {
    //TODO: file writing
    static File logFile;
    static FileWriter logFileWriter;
    static protected boolean errorAccrued;
    static List<IOException> errors = new ArrayList<>();

    //Initialize Logger
    public static void INIT() {
        try {
            logFile = new File("Cipher.log");
            logFileWriter = new FileWriter(logFile);
            errorAccrued = false;
        } catch (IOException e) {
            errorAccrued = true;
            errors.add(e);
        }
    }
    //Log simple Logs
    public static void Log(String from, String msg) {
        //TODO: Fix "No log Problem"
        String out = "[" + from + "] " + msg;
        if (logFile.canWrite() & logFile.exists() & !errorAccrued) {
            try {
                logFileWriter.write("["+ LocalTime.now() + "]" + out);
            } catch (IOException e) {
                errors.add(e);
            }
        }
        System.out.println(out);
    }
    //TODO: More Functions
}
