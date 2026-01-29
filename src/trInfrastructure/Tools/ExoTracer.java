package trInfrastructure.Tools;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class ExoTracer {
    private static final String DF_TRACER = "src/storage/DataFiles/ExoTracer.txt";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private ExoTracer() {}

    public static void trGood(String msg) {
        String line = "GOOD : " + msg;
        System.out.println(line);
        trAppendToFile(line);
    }

   
    public static void trError(String msg) {
        String line = "ERROR: " + msg;
        System.err.println(line);
        trAppendToFile(line);
    }

    private static void trAppendToFile(String line) {
        try {
            File f = new File(DF_TRACER);
            if (f.getParentFile() != null) f.getParentFile().mkdirs();
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
                pw.println(DTF.format(LocalDateTime.now()) + " | " + line);
            }
        } catch (Exception e) {
            System.err.println("ExoTracer: No se pudo escribir en " + DF_TRACER + " - " + e.getMessage());
        }
    }
}
