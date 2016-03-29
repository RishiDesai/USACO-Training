/*
ID: rishide2
LANG: JAVA
TASK: combo
*/
// created by rishi on 8/12/15
package chapter1.sec3;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class combo {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fj = new int[3];
        for (int i = 0; i < 3; i++) fj[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] ms = new int[3];
        for (int i = 0; i < 3; i++) ms[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (close(i, j, k, fj) || close(i, j, k, ms))
                        ans++;


        pw.println(ans);
        pw.close();
    }

    private static boolean close(int a, int b, int c, int[] key) {
        return ok(a, key[0]) && ok(b, key[1]) && ok(c, key[2]);
    }

    private static boolean ok(int a, int key) {
        return abs(a - key) <= 2 || abs(a - key) >= N - 2;
    }

}
