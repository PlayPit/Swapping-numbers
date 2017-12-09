package com.lpnu;

import java.io.*;
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

    void scanFile() {
        File file = new File("input.txt");

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String a;
                a = sc.nextLine();
                for (char i : a.toCharArray()) {
                    if (i >= '0' && i <= '9')
                        expr.add(i);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
                    print(i, j, res, k);
                }
                res[0] = '\0';
                res[1] = '\0';
            }
        }
    }

    void print(int i, int j, char[] res, int k) {
        M:System.out.println("Enter 1 to file print, enter 2 to console print");
        int choose;
        Scanner input = new Scanner(inputStream);
        choose = input.nextInt();
        switch (choose) {
            case 2:
                System.out.println(expr.get(i) + "*" + expr.get(j) + "=" + (res[k + 1]) + (res[k]));
                break;
            case 1:
                String str = new String(expr.get(i) + "*" + expr.get(j) + "=" + (res[k + 1]) + (res[k]));
                BufferedWriter output = null;
                try {
                    File file = new File("result.txt");
                    output = new BufferedWriter(new FileWriter(file));
                    output.write(str);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (output != null) {
                        try {
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                default: print(i,j,res,k);
        }
    }
}