package com.lab.keyworddetector;

import com.lab.keyworddetector.common.util.FileUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author suleimanalrosan
 */
public class KeywordDetector {

    private static final String KW_DELIM = ",";
    private static final String PREFIX_TAG = "<b>";
    private static final String POSTFIX_TAG = "</b>";
    private static final String DEFAULT_INPUT_FILE = "input.txt";
    private static final String DEFAULT_OUTPUT_FILE = "output.txt";

    /**
     *
     * K = number of keyword N = text length O(N*K) Keyword must meet the
     * following conditions:
     * <br>- Can only contains English alphabet (a-zA-Z).
     * <br>- Should be a whole complete word (ex human and humans are different
     * keywords).
     * <br>- Is case sensitive.
     *
     * @param inputFilePath
     * @param outputFilePath
     * @throws java.io.IOException
     *
     */
    public void detectKeywords(String inputFilePath, String outputFilePath) throws IOException {
        BufferedWriter writer = FileUtil.getWriter(outputFilePath);
        BufferedReader reader = FileUtil.getReader(inputFilePath);

        String line;
        int lineCounter = 1;

        StringBuilder outputSb = new StringBuilder();
        String[] keywords = null;

        while ((line = reader.readLine()) != null) {

            if (lineCounter == 1) {
                line = removeNewLine(line);
                keywords = line.split(KW_DELIM);
                outputSb.append(line).append(FileUtil.newLine());
                lineCounter++;
                continue;
            }

            String lineSb = line;

            for (String keyword : keywords) {
                lineSb = detectKeyword(lineSb, keyword);
            }
            outputSb.append(lineSb).append(FileUtil.newLine());

            lineCounter++;
        }
        writer.append(outputSb);
        writer.close();
        reader.close();

    }

    /**
     * O(n)
     *
     * @param line
     * @param keyword
     * @return
     */
    private static String detectKeyword(String line, String keyword) {

        StringBuilder newLineSb = new StringBuilder();
        int kp = 0;
        int lp = 0;
        int lsp = 0;

        while (lp < line.length()) {
            //increas pointer count as long as kewword and the current word are matching 
            while (kp < keyword.length() && lp < line.length() && keyword.charAt(kp) == line.charAt(lp)) {
                kp++;
                lp++;
            }

            if (kp == keyword.length() && keyword.charAt(kp - 1) == line.charAt(lp - 1) && (lp >= line.length() || !isAlphabet(line.charAt(lp)))) {
                newLineSb.append(PREFIX_TAG).append(line.substring(lsp, lp)).append(POSTFIX_TAG);
            } else {

                // increas pointer count until you reach the start of new word                        
                boolean isword = lp == 0 || (lp < line.length() && isAlphabet(line.charAt(lp)));
                if (isword) {
                    while (lp < line.length() && isAlphabet(line.charAt(lp))) {
                        lp++;
                    }
                }

                while (lp < line.length() && !isAlphabet(line.charAt(lp))) {
                    lp++;
                }
                newLineSb.append(line.substring(lsp, lp));
            }

            kp = 0;
            lsp = lp;
        }
        return newLineSb.toString();
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static String removeNewLine(String str) {
        if (str.endsWith("\r") || str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }

        if (str.endsWith("\r\n")) {
            str = str.substring(0, str.length() - 2);
        }

        return str;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        KeywordDetector detector = new KeywordDetector();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("Input file [%s]:", DEFAULT_INPUT_FILE));
        String inputFilePath = br.readLine();
        if (inputFilePath == null || "".equals(inputFilePath.trim())) {
            inputFilePath = DEFAULT_INPUT_FILE;
        }

        System.out.println(String.format("Output file [%s]:", DEFAULT_OUTPUT_FILE));
        String outputFilePath = br.readLine();
        if (outputFilePath == null || "".equals(outputFilePath.trim())) {
            outputFilePath = DEFAULT_OUTPUT_FILE;
        }

        detector.detectKeywords(inputFilePath, outputFilePath);
    }

}
