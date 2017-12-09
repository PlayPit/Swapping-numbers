package com.lpnu;

import java.io.InputStream;
import java.util.*;

public class Expression {
    private InputStream inputStream;

    public Expression(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    ArrayList<Character> expr = new ArrayList<>();

    void scan() {                               //Scanning the incorrect expression
        String a;
        Scanner input = new Scanner(inputStream);
        a = input.nextLine();
        for (char i : a.toCharArray()) {
            if (i >= '0' && i <= '9')
                expr.add(i);
        }
    }

    void pick() {
        char[] res = new char[2];
        int temp;
        Character[] strings = expr.toArray(new Character[expr.size()]);
        for (int i = 0; i < expr.size(); i++) {
            int k = 0;
            for (int j = i + 1; j < expr.size(); j++) {
                ArrayList<Character> temporary = new ArrayList<>(expr);
                temp = (strings[i] - '0') * (strings[j] - '0');
                temporary.remove(strings[i]);
                temporary.remove(strings[j]);
                while (temp > 1) {
                    res[k++] = Character.forDigit(temp % 10, 10);
                    temp /= 10;
                }
                k = 0;
                if (temporary.contains(res[k]) && temporary.contains(res[k + 1]) && temporary.size() == 2) {
                    System.out.println(expr.get(i) + "*" + expr.get(j) + "=" + (res[k + 1]) + (res[k]));
                }
                res[0] = '\0';
                res[1] = '\0';
            }
        }
    }
}