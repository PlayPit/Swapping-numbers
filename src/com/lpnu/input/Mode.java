package com.lpnu.input;

import java.io.InputStream;

public interface Mode {
    enum ModeType {
        TERMINAL_MODE, FILE_MODE, EXIT
    }

    InputStream getExpressionAsInputStream();

    void populateResult(String result);
}
