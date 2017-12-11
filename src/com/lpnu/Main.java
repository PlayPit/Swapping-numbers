package com.lpnu;

import com.lpnu.exceptions.ExitException;
import com.lpnu.input.Mode;
import com.lpnu.input.Mode.ModeType;
import com.lpnu.input.impl.TerminalMode;
import com.lpnu.input.impl.FileMode;

import java.util.Scanner;

import static com.lpnu.input.Mode.ModeType.*;

public class Main {
    public static void main(String[] args) {
        try {

            while (true) {
                Mode mode = null;
                while (mode == null) {
                    System.out.println("Please select an option:");
                    System.out.println(TERMINAL_MODE.ordinal() + " - to enter expression from console");
                    System.out.println(FILE_MODE.ordinal() + " - to read expression from file");
                    System.out.print("*(enter any other character to exit)\n:");
                    mode = detectChosenMode();
                }

                Expression expression = new Expression(mode);
                expression.findSolution();
            }
        } catch (ExitException e) {
            System.exit(0);
        }
    }

    private static Mode detectChosenMode() throws ExitException {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        ModeType mode = EXIT;
        if (values().length > option) {
            mode = values()[option];
        }
        Mode source = null;
        switch (mode) {
            case FILE_MODE:
                source = new FileMode("input.txt", "result.txt");
                break;
            case TERMINAL_MODE:
                source = new TerminalMode();
                break;
            case EXIT:
                throw new ExitException();
        }
        return source;
    }
}