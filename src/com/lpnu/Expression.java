package com.lpnu;

import com.lpnu.input.Mode;

import java.util.ArrayList;
import java.util.Scanner;

public class Expression {
    private Mode mode;

    public Expression(Mode mode) {
        this.mode = mode;
    }

    private ArrayList<Character> readExpression() {                               //Scanning the incorrect expression
        Scanner input = new Scanner(mode.getExpressionAsInputStream());
        String expressionLine = input.nextLine();
        ArrayList<Character> expression = new ArrayList<>();
        for (char i : expressionLine.toCharArray()) {
            if (i >= '0' && i <= '9')
                expression.add(i);
        }
        return expression;
    }

    void findSolution() {
        char[] res = new char[2];
        int temp;
        ArrayList<Character> expression = readExpression();
        Character[] strings = expression.toArray(new Character[expression.size()]);
        for (int i = 0; i < expression.size(); i++) {
            int k = 0;
            for (int j = i + 1; j < expression.size(); j++) {
                ArrayList<Character> tempExpression = new ArrayList<>(expression);
                temp = (strings[i] - '0') * (strings[j] - '0');
                tempExpression.remove(strings[i]);
                tempExpression.remove(strings[j]);
                while (temp > 1) {
                    res[k++] = Character.forDigit(temp % 10, 10);
                    temp /= 10;
                }
                k = 0;
                if (tempExpression.contains(res[k]) && tempExpression.contains(res[k + 1]) && tempExpression.size() == 2) {
                    mode.populateResult(expression.get(i) + "*" + expression.get(j) + "=" + (res[k + 1]) + (res[k]));
                }
                res[0] = '\0';
                res[1] = '\0';
            }
        }
    }
}