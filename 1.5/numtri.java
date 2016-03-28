/*
ID: rishide2
LANG: JAVA
TASK: numtri
*/
// created by rishi on 8/20/15
package chapter1.sec5;

import java.io.*;
import java.util.StringTokenizer;

public class numtri {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        final int N = Integer.parseInt(br.readLine());

        long[][] tri = new long[N][N];    // dp
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++)
                tri[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] += Math.max(tri[i + 1][j], tri[i + 1][j + 1]);
            }
        }

        pw.println(tri[0][0]);
        pw.close();
    }

}
