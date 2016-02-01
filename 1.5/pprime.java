/*
ID: rishide2
LANG: JAVA
TASK: pprime
*/
// created by rishi on 8/21/15
package chapter1.sec5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {

    private static ArrayList<Integer> palindromes = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")), true);

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        int low = String.valueOf(A).length();
        int high = String.valueOf(B).length();

        for (int i = low; i <= high; i++) { // very tedious :(
            if (i == 1) oneDigit();
            if (i == 2) twoDigit();
            if (i == 3) threeDigit();
            if (i == 4) fourDigit();
            if (i == 5) fiveDigit();
            if (i == 6) sixDigit();
            if (i == 7) sevenDigit();
            if (i == 8) eightDigit();
        }

        for (Integer pal : palindromes)
            if (pal >= A && pal <= B)
                if (isPrime(pal)) pw.println(pal);


        pw.close();
    }

    private static boolean isPrime(final int num) {
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;

        return true;
    }

    private static void oneDigit() {
        for (int i = 1; i <= 9; i += 2)
            palindromes.add(i);
    }

    private static void twoDigit() {
        for (int i = 1; i <= 9; i += 2)
            palindromes.add(i * 10 + i);
    }

    private static void threeDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                palindromes.add(100 * i + 10 * j + i);

    }

    private static void fourDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                palindromes.add(1000 * i + 100 * j + 10 * j + i);

    }

    private static void fiveDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    palindromes.add(10000 * i + 1000 * j + 100 * k + 10 * j + i);


    }

    private static void sixDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    palindromes.add(100000 * i + 10000 * j + 1000 * k +
                            100 * k + 10 * j + i);


    }

    private static void sevenDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    for (int l = 0; l <= 9; l++)
                        palindromes.add(1000000 * i + 100000 * j + 10000 * k +
                                1000 * l + 100 * k + 10 * j + i);


    }

    private static void eightDigit() {
        for (int i = 1; i <= 9; i += 2)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 9; k++)
                    for (int l = 0; l <= 9; l++)
                        palindromes.add(10000000 * i + 1000000 * j + 100000 * k
                                + 10000 * l + 1000 * l + 100 * k + 10 * j + i);


    }

}