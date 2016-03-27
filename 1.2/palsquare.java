/*
ID: rishide2
LANG: JAVA
TASK: palsquare
*/
// created by rishi on 7/28/15
package chapter1.sec2;

import java.io.*;

public class palsquare {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        final int B = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 300; i++) {

            String square = Integer.toString(i * i, B).toUpperCase();  // toString(i, b) converts 'i' (base 10) to base 'b'
            String curr = Integer.toString(i, B).toUpperCase();        // toString() makes the letters lower case

            if (isPalindrome(square)) {
                pw.println(curr + " " + square);
            }

        }

        pw.close();
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;

        return true;
    }

}
