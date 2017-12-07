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
        char[] res = new char[3];
        int temp;
        Character[] strings = expr.toArray(new Character[expr.size()]);
        for (int i = 0; i < expr.size(); i++) {
            int k = 0;
            for (int j = i; j <= expr.size(); j++) {
                temp = (strings[i]) * (strings[j]);
                while (temp > 1) {
                    res[k++] = Character.forDigit(temp % 10, 10);
                    temp /= 10;
                }
                int m = 0;
                if (expr.contains(res[m]) && expr.contains(res[m + 1])) {
                    System.out.println(i + "*" + j + "=" + temp);
                }

            }
        }

    }
}
