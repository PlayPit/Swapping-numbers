package com.lpnu.input.impl;

import com.lpnu.input.Mode;

import java.io.InputStream;

public class TerminalMode implements Mode {
    @Override
    public InputStream getExpressionAsInputStream() {
        System.out.print(">");
        return System.in;
    }

    @Override
    public void populateResult(String result) {
        System.out.println(result);
    }
}
