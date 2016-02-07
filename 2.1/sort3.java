/*
ID: rishide2
LANG: JAVA
TASK: sort3
*/
// created by rishi on 8/24/15

package chapter2.sec1;

import java.io.*;

public class sort3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        final int N = Integer.parseInt(br.readLine());

        int[] row = new int[N];
        int ones = 0, twos = 0;
        for (int i = 0; i < N; i++) {
            row[i] = Integer.parseInt(br.readLine());
            if (row[i] == 1) ones++;
            if (row[i] == 2) twos++;
        }

        int ret = 0;
        for (int i = ones; i < N; i++) {
            if (row[i] == 1) {

                int idx = 0;
                for (int j = 0; j < ones; j++) {
                    if (row[j] == 2) {
                        idx = j;
                        break;
                    }
                    if (row[j] == 3) {
                        idx = j;
                    }
                }

                swap(i, idx, row);
                ret++;
            }
        }

        for (int i = ones + twos; i < N; i++)
            if (row[i] == 2) ret++;


        pw.println(ret);
        pw.close();
    }

    private static void swap(int a, int b, int[] row) {
        int temp = row[a];
        row[a] = row[b];
        row[b] = temp;
    }

}
