/*
ID: rishide2
LANG: JAVA
TASK: concom
*/
// created by rishi on 11/25/15
package chapter2.sec3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class concom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("concom.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));

        final int N = Integer.parseInt(br.readLine());

        final int MAX = 100;

        boolean[][] ownage = new boolean[MAX][MAX];
        long[][] perc = new long[MAX][MAX];

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int p = Integer.parseInt(st.nextToken());

            perc[i][j] = p;
        }


        for (int i = 0; i < MAX; i++) {

            long[] self = new long[MAX];
            Queue<Integer> q = new LinkedList<Integer>();

            for (int j = 0; j < MAX; j++) {
                self[j] += perc[i][j];
                if (self[j] > 50) {
                    ownage[i][j] = true;
                    q.add(j);
                }
            }

            while (! q.isEmpty()) {

                while (! q.isEmpty()) {
                    int c = q.poll();
                    for (int j = 0; j < MAX; j++)
                        self[j] += perc[c][j];
                }

                for (int j = 0; j < MAX; j++)
                    if (self[j] > 50 && ! ownage[i][j]) {
                        ownage[i][j] = true;
                        q.add(j);
                    }

            }

        }


        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i != j && ownage[i][j]) {
                    pw.println((i + 1) + " " + (j + 1));
                }
            }
        }


        pw.close();
    }

}
