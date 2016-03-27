/*
ID: rishide2
LANG: JAVA
TASK: dualpal
*/
// created by rishi on 7/28/15
package chapter1.sec2;

import java.io.*;
import java.util.StringTokenizer;

public class dualpal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter pw = new PrintWriter(new File("dualpal.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken()); // times
        int S = Integer.parseInt(st.nextToken()); // max

        int found = 0;
        while (found < N) {
            S++;

            if (isOk(S)) {
                found++;
                pw.println(S);
            }

        }


        pw.close();
    }

    private static boolean isOk(final int n) {

        int count = 0;
        for (int i = 2; i <= 10; i++) {

            String inBase = Integer.toString(n, i);  // toString(n, i) converts 'n' (base 10) to base 'i'

            if (isPalindrome(inBase))
                count++;

            if (count == 2) return true;
        }

        return false;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;

        return true;
    }

}
