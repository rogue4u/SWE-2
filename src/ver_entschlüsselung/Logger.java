package ver_entschlüsselung;

import java.io.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

//Class for Easy Logging
public class Logger {
    //TODO: file writing
    static protected boolean errorAccrued;
    static List<Exception> errors = new ArrayList<>();

    //Initialize Logger
    public static void INIT() {
        try {
            errorAccrued = false;
        } catch (Exception e) {
            errorAccrued = true;
            errors.add(e);
        }
    }
    //Log simple Logs
    public static void Log(String from, String msg) {
        //TODO: Fix "No log Problem"
        String out = "[" + from + "] " + msg;
        System.out.println(out);
    }
    //TODO: More Functions
}
