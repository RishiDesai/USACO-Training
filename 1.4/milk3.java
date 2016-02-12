/*
ID: rishide2
LANG: JAVA
TASK: milk3
*/
// created by rishi on 8/19/15
package chapter1.sec4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class milk3 {

    private static int A, B, C;
    private static boolean[][][] visit;
    private static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[A + 1][B + 1][C + 1];
        ans = new ArrayList<Integer>();

        pour(0, 0, C);

        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1)
                pw.print(ans.get(i));
            else
                pw.print(ans.get(i) + " ");
        }

        pw.println();
        pw.close();
    }

    private static void pour(int a, int b, int c) {

        if (visit[a][b][c]) return;
        visit[a][b][c] = true;

        if (a == 0) ans.add(c);

        // a -> b
        pour(a - min(a, B - b), b + min(a, B - b), c);

        // b -> a
        pour(a + min(b, A - a), b - min(b, A - a), c);

        // a -> c
        pour(a - min(a, C - c), b, c + min(a, C - c));

        // c -> a
        pour(a + min(c, A - a), b, c - min(c, A - a));

        // b -> c
        pour(a, b - min(b, C - c), c + min(b, C - c));

        // c -> b
        pour(a, b + min(c, B - b), c - min(c, B - b));

    }

}
