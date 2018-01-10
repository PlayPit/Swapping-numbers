package com.lpnu;

import com.lpnu.exceptions.ExitException;
import com.lpnu.input.Mode;
import com.lpnu.input.Mode.InputType;
import com.lpnu.input.impl.TerminalMode;
import com.lpnu.input.impl.FileMode;

import java.util.Scanner;

import static com.lpnu.input.Mode.InputType.*;

public class Main {
    public static void main(String[] args) {
        try {

            while (true) {
                Mode mode = null;
                while (mode == null) {
                    System.out.println("Please select an option:");
                    System.out.println(TERMINAL.ordinal() + " - to enter expression from console");
                    System.out.println(FILE.ordinal() + " - to read expression from file");
                    System.out.print("*(enter any other character to exit)\n:");
                    mode = detectChosenInput();
                }

                Expression expression = new Expression(mode);
                expression.findSolution();
            }
        } catch (ExitException e) {
            System.exit(0);
        }
    }

    private static Mode detectChosenInput() throws ExitException {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        InputType mode = null;
        if (values().length > option) {
            mode = values()[option];
        }
        Mode source;
        switch (mode) {
            case FILE:
                source = new FileMode("input.txt", "result.txt");
                break;
            case TERMINAL:
                source = new TerminalMode();
                break;
            default:
                throw new ExitException();
        }
        return source;
    }
}