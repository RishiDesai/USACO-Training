/*
ID: rishide2
LANG: JAVA
TASK: wormhole
*/
// created by rishi on 8/15/15
package chapter1.sec3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* I want to give credit to ddexter on github
* At https://github.com/ddexter/usaco/blob/master/wormhole/wormhole.cpp
* Thanks you.
*/

public class wormhole {

    private static int[] adjacent, pairings;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        N = Integer.parseInt(br.readLine());

        int[] x = new int[N], y = new int[N];
        adjacent = new int[N];
        pairings = new int[N];

        Arrays.fill(adjacent, - 1);
        Arrays.fill(pairings, - 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (y[i] == y[j] && x[j] > x[i])
                    if (adjacent[i] == - 1 || x[j] < x[adjacent[i]])
                        adjacent[i] = j;


        int ans = search();

        pw.println(ans);
        pw.close();
    }

    private static int search() {

        int i;
        for (i = 0; i < N; i++)
            if (pairings[i] < 0)
                break;

        if (i == N) return isCycle() ? 1 : 0;

        int ret = 0;
        for (int j = i + 1; j < N; j++)
            if (pairings[j] < 0) {
                pairings[i] = j;
                pairings[j] = i;

                ret += search();

                pairings[i] = - 1;
                pairings[j] = - 1;
            }

        return ret;
    }

    private static boolean isCycle() {
        for (int i = 0; i < N; i++) {
            int idx = i;

            for (int j = 0; j < N; j++) {
                idx = adjacent[pairings[idx]];

                if (idx < 0) break;
            }

            if (idx >= 0) return true;
        }

        return false;
    }

}
