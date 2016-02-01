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

/*
* I want to give credit to TomConerly on github.
* At https://github.com/TomConerly/Competition-Programming/blob/master/USACO/Chapter1/milk3.java
* Thank you.
*/

public class milk3 {

    private static int amax, bmax, cmax;
    private static boolean[][][] seen;
    private static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                C = Integer.parseInt(st.nextToken());

        seen = new boolean[A + 1][B + 1][C + 1];
        ans = new ArrayList<Integer>();

        amax = A;
        bmax = B;
        cmax = C;

        recur(0, 0, cmax);

        Collections.sort(ans);

        boolean first = true;
        for (Integer i : ans) {
            if (first) pw.print(i);
            else pw.print(" " + i);

            first = false;
        }

        pw.println();
        pw.close();
    }

    public static void recur(int a, int b, int c) {

        if (seen[a][b][c]) return;
        seen[a][b][c] = true;

        if (a == 0) ans.add(c);

        //c to a
        recur(a + min(c, amax - a), b, c - min(c, amax - a));
        //a to c
        recur(a - min(cmax - c, a), b, c + min(cmax - c, a));

        //b to a
        recur(a + min(b, amax - a), b - min(b, amax - a), c);
        //a to b
        recur(a - min(bmax - b, a), b + min(bmax - b, a), c);

        //c to b
        recur(a, b + min(c, bmax - b), c - min(c, bmax - b));
        //b to c
        recur(a, b - min(cmax - c, b), c + min(cmax - c, b));

    }

}
