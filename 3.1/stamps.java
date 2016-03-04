/*
ID: rishide2
LANG: JAVA
TASK: stamps
*/
// created by rishi on 2/15/16
package chapter3.sec1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class stamps {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("stamps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int[] stamps = new int[N];

        int x = 0;
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                stamps[x] = Integer.parseInt(st.nextToken());
                x++;
            }
        }

        Arrays.sort(stamps);

        int[] dp = new int[K * stamps[N - 1] + 1];   // knapsack and possible ways

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        int max;
        for (max = 0; max < dp.length && dp[max] <= K; max++) {
            for (int s : stamps) {

                int idx = max + s;
                if (idx < dp.length) {

                    int val = dp[max] + 1;
                    if (val < dp[idx]) dp[idx] = val;

                }

            }
        }

        pw.println(max - 1);
        pw.close();
    }

}
