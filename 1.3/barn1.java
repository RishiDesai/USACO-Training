/*
ID: rishide2
LANG: JAVA
TASK: barn1
*/
// created by rishi on 8/4/15
package chapter1.sec3;

import java.io.*;
import java.util.*;

public class barn1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int M = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        int[] stalls = new int[C];
        for (int i = 0; i < C; i++) stalls[i] = Integer.parseInt(br.readLine());

        Arrays.sort(stalls);

        List<Integer> diff = new ArrayList<Integer>(); // finding the differences
        for (int i = 0; i < C - 1; i++) diff.add(stalls[i + 1] - stalls[i]);
        Collections.sort(diff);

        int from = (M > C) ? C : M;                    // we don't need more planks than stalls
        diff = diff.subList(diff.size() - from + 1, diff.size());

        boolean[] occ = new boolean[S + 1];
        for (int i = 1; i < stalls.length; i++) {

            if (diff.size() == 0) break;

            int t = stalls[i] - stalls[i - 1];
            if (diff.contains(t)) {

                diff.remove(new Integer(t));                     // new Integer(t) so 't' won't act as an index

                for (int j = stalls[0]; j <= stalls[i - 1]; j++) // true = stalls blocked
                    occ[j] = true;

                stalls = Arrays.copyOfRange(stalls, i, stalls.length);

                i = 0;
            }
        }

        for (int i = stalls[0]; i <= stalls[stalls.length - 1]; i++) { // last number of stalls blocked
            occ[i] = true;                                             // this is separate because the previous loops
        }                                                              // never use the last board.

        int ans = 0;
        for (boolean b : occ) if (b) ans++;

        pw.println(ans);
        pw.close();
    }

}
