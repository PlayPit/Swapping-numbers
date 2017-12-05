package com.lpnu;

import java.util.*;

public class Expression {
    public Expression() {
    }

    Collection<Character> expr;
    private char[] exp;

    void scan() {                               //Scanning the incorrect expression
        expr=new Vector<Character>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Character> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Character character) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Character> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        String a;
        Scanner input = new Scanner(System.in);
        a = input.nextLine();
        int j = 0;
        for (char i : a.toCharArray()) {
            if (i >= '0' && i <= '9')
                expr.add(i);
        }
    }

    void pick() {
        char[] res = new char[3];
        int temp;
        int k = 0;
        Collection<Character> any=new Vector<Character>(expr);
        Character[] strings = expr.toArray(new Character[expr.size()]);
        for (int i = 0; i < expr.size(); i++) {
            for (int j = i; j <= expr.size(); j++) {
                temp = (strings[i]) * (strings[j]);
                while (temp > 1) {
                    res[k++] = Character.forDigit(temp % 10, 10);
                    temp /= 10;
                }
                int m=0;
                    if (expr.contains(res[m])&&expr.contains(res[m+1])){
                        System.out.println(i+"*"+j+"="+temp);
                    }

            }
        }

    }
}
