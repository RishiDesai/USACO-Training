/*
ID: rishide2
LANG: JAVA
TASK: pprime
*/
// created by rishi on 8/21/15
package chapter1.sec5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class pprime {

    private static List<Integer> pals = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        int low = (A + "").length();
        int high = (B + "").length();

        for (int i = low; i <= high; i++) { // only generate what is needed
            if (i == 1) oneDigit();
            if (i == 2) twoDigit();
            if (i == 3) threeDigit();
            if (i == 4) fourDigit();
            if (i == 5) fiveDigit();
            if (i == 6) sixDigit();
            if (i == 7) sevenDigit();
            if (i == 8) eightDigit();
        }

        for (Integer pal : pals)
            if (pal >= A && pal <= B && isPrime(pal))
                pw.println(pal);


        pw.close();
    }

    private static boolean isPrime(int n) {
        if (n <= 2 || n % 2 == 0) return n == 2;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;

        return true;
    }

    private static void oneDigit() {
        for (int i = 1; i <= 9; i += 2)
            pals.add(i);
    }

    private static void twoDigit() {
        for (int i = 1; i <= 9; i += 2)
            pals.add(i * 10 + i);
    }

    private static void threeDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                pals.add(100 * i + 10 * j + i);

    }

    private static void fourDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                pals.add(1000 * i + 100 * j + 10 * j + i);

    }

    private static void fiveDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    pals.add(10000 * i + 1000 * j + 100 * k + 10 * j + i);


    }

    private static void sixDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    pals.add(100000 * i + 10000 * j + 1000 * k + 100 * k + 10 * j + i);


    }

    private static void sevenDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    for (int l = 0; l <= 9; l++)
                        pals.add(1000000 * i + 100000 * j + 10000 * k + 1000 * l +
                                100 * k + 10 * j + i);


    }

    private static void eightDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    for (int l = 0; l <= 9; l++)
                        pals.add(10000000 * i + 1000000 * j + 100000 * k + 10000 * l +
                                1000 * l + 100 * k + 10 * j + i);


    }

}