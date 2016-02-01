/*
ID: rishide2
LANG: JAVA
TASK: ariprog
*/
// created by rishi on 8/19/15
package chapter1.sec4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ariprog {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        boolean[] set = new boolean[M * M * 2 + 1];
        for (int i = 0; i <= M; i++)
            for (int j = 0; j <= M; j++)
                set[i * i + j * j] = true;

        final int max = M * M * 2;
        ArrayList<int[]> ans = new ArrayList<int[]>();

        for (int a = 0; a < max; a++) {
            if (! set[a]) continue;

            second:
            for (int b = 1; b <= (max - a) / (N - 1); b++) {
                for (int i = 1; i <= N - 1; i++)
                    if (! set[a + b * i])
                        continue second;

                ans.add(new int[]{a, b});
            }
        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                if (o1[1] < o2[1]) return - 1;
                if (o1[0] > o2[0]) return 1;
                if (o1[0] > o2[0]) return - 1;
                return 0;
            }

        });

        if (ans.size() > 0)
            for (int[] i : ans)
                pw.println(i[0] + " " + i[1]);
        else
            pw.println("NONE");

        pw.close();
    }
}
