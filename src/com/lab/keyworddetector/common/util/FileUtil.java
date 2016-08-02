package com.lab.keyworddetector.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suleimanalrosan - Jul 30, 2016
 */
public class FileUtil {

    private static final Logger LOG = Logger.getLogger(FileUtil.class.getSimpleName());

    public static BufferedWriter getWriter(String outputFilePath) throws IOException {
        BufferedWriter writer;
        File outputFile = new File(outputFilePath);
        LOG.info(String.format("=> Writing to: %s", outputFile.getAbsolutePath()));
        writer = new BufferedWriter(new FileWriter(outputFile, true));
        return writer;
    }

    public static BufferedReader getReader(String inputFilePath) throws FileNotFoundException {
        BufferedReader reader;
        File inputFile = new File(inputFilePath);
        LOG.info(String.format("=> Reading from: %s", inputFile.getAbsolutePath()));
        reader = new BufferedReader(new FileReader(inputFile));
        return reader;
    }

    public static String newLine() {
        return System.getProperty("line.separator");
    }

}
