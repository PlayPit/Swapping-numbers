package com.lpnu.input;

import java.io.InputStream;

public interface Mode {
    enum InputType {
        TERMINAL, FILE
    }

    InputStream getExpressionAsInputStream();

    void populateResult(String result);
}
