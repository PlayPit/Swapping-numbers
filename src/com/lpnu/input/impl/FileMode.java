package com.lpnu.input.impl;

import com.lpnu.input.Mode;

import java.io.*;

public class FileMode implements Mode {
    private String inputFileName;
    private String resultFileName;

    public FileMode(String inputFileName, String resultFileName) {
        this.inputFileName = inputFileName;
        this.resultFileName = resultFileName;
    }

    public InputStream getExpressionAsInputStream() {
        try {
            return new FileInputStream(inputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Oops some shit happened wile was trying to read the file -_-");
            e.printStackTrace();
        }
        return null;
    }

    public void populateResult(String result) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(resultFileName, false))) {
            output.write(result);
        } catch (IOException e) {
            System.out.println("Oops some shit happened wile was trying populate result to file -_-");
            e.printStackTrace();
        }
    }
}
