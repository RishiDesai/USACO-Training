/*
ID: rishide2
LANG: JAVA
TASK: sprime
*/
// created by rishi on 8/22/15
package chapter1.sec5;

import java.io.*;

public class sprime {

    private static int N;
    private static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        N = Integer.parseInt(br.readLine());

        int[] list = {2, 3, 5, 7, 9};

        for (int i : list) search(i);

        pw.close();
    }

    private static void search(int n) {

        if (! isPrime(n)) return;

        if (String.valueOf(n).length() == N)
            pw.println(n);

        for (int i = 1; i <= 9; i += 2)
            search(10 * n + i);

    }

    private static boolean isPrime(final int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i++)
            if (n % i == 0) return false;

        return true;
    }

}
