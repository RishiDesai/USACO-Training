/*
ID: rishide2
LANG: JAVA
TASK: holstein
*/
// created by rishi on 8/24/15

package chapter2.sec1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class holstein {

    private static int V, G, bestCount;
    private static boolean[] bestUsed;
    private static int[] min, bestTotal;
    private static int[][] scoops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        V = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        min = new int[V];
        for (int i = 0; i < V; i++) min[i] = Integer.parseInt(st.nextToken());

        G = Integer.parseInt(br.readLine());

        scoops = new int[G][V];
        for (int i = 0; i < G; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) scoops[i][j] = Integer.parseInt(st.nextToken());
        }

        bestCount = Integer.MAX_VALUE;
        bestTotal = new int[V];
        for (int i = 0; i < V; i++) bestTotal[i] = Integer.MAX_VALUE;

        create(0, new int[V], 0, new boolean[G]);

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < bestUsed.length; i++)
            if (bestUsed[i]) ans.add(i);

        Collections.sort(ans);

        pw.print(ans.size());
        for (int i : ans) pw.print(" " + (i + 1));

        pw.println();
        pw.close();
    }

    private static void create(int idx, int[] total, int count, boolean[] used) {

        if (idx == G) {

            for (int i = 0; i < V; i++)         // if not enough vitamins
                if (total[i] < min[i]) return;

            if (isBetter(total, count)) {
                bestCount = count;
                bestTotal = total.clone();      // don't want reference, but value
                bestUsed = used.clone();
            }

            return;
        }

        create(idx + 1, total, count, used);   // to add different scoops

        for (int i = 0; i < V; i++)
            total[i] += scoops[idx][i];
        used[idx] = true;

        create(idx + 1, total, count + 1, used);

        for (int i = 0; i < V; i++)
            total[i] -= scoops[idx][i];
        used[idx] = false;

    }

    private static boolean isBetter(int[] scoop, int count) {
        if (count > bestCount) return false;
        if (count < bestCount) return true;

        for (int i = 0; i < V; i++)
            if (scoop[i] < bestTotal[i]) return true;

        return false;
    }

}
