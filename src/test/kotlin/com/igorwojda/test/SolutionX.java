package com.igorwojda.test;

import java.util.Scanner;

public class SolutionX {
    public static String strings_xor(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s1.length(); i++) {
            // XOR the characters of the strings and append to the result
            res.append((char)((s1.charAt(i) - '0') ^ (s2.charAt(i) - '0') + '0'));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(strings_xor(s1, s2));
        scanner.close();
    }
}
