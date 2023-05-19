package com.sparta.rbf.employees_project2.jdbc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

public class CSVFileWriter {
    public static final Logger logger = Logger.getLogger(CSVFileWriter.class.getName());

    public static void writeToCSV(UncheckedEmployee corruptRecord, String fileName) {
        String filePath = "src/main/resources/" +createCorruptFileName(fileName);
        File file = new File(filePath);
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            printWriter.println(corruptRecord.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Corrupt records not written to .csv file");
        }
    }

    public static String createCorruptFileName(String fileName) {
        String[] fileNameSplit = fileName.split("\\.");
        String dateAndTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        dateAndTime = dateAndTime.replaceAll("/", "-");
        dateAndTime = dateAndTime.replaceAll(" ", "_");
        dateAndTime = dateAndTime.replaceAll(":", "-");
        return fileNameSplit[0] + "_corruptedData_" + dateAndTime + ".csv";
    }
}
