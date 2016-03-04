/*
ID: rishide2
LANG: JAVA
TASK: inflate
*/
// created by rishi on 2/29/16
package chapter3.sec1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class inflate {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inflate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        Problem[] probs = new Problem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int pts = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if (time <= M)
                probs[i] = new Problem(pts, time);
        }

        Arrays.sort(probs);

        int[] dp = new int[M + 1];     // knapsack and point storage
        int ret = - 1;

        dp[0] = 0;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == 0 && i != 0) continue;

            for (Problem p : probs) {

                int idx = p.time + i;
                if (idx <= M) {

                    if (dp[i] + p.pts > dp[idx]) {
                        dp[idx] = dp[i] + p.pts;
                    }

                    if (dp[idx] > ret) ret = dp[idx];    // update most pts so far
                } else break;

            }

        }

        pw.println(ret);
        pw.close();
    }

    private static class Problem implements Comparable<Problem> {  // immutable

        private final int pts, time;

        protected Problem(int pts, int time) {
            this.pts = pts;
            this.time = time;
        }

        public int compareTo(Problem p) {
            return time - p.time;
        }

    }
    
}
