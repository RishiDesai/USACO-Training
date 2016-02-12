/*
ID: rishide2
LANG: JAVA
TASK: money
*/
// created by rishi on 11/23/15
package chapter2.sec3;

import java.io.*;
import java.util.StringTokenizer;

public class money {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("money.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int[] coins = new int[V];

        int idx = 0;
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                coins[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        long[] dp = new long[N + 1];

        dp[0] = 1;
        for (int coin : coins) {

            for (int i = 0; i <= N; i++) {

                if (coin + i <= N)
                    dp[coin + i] += dp[i];

            }

        }

        pw.println(dp[N]);
        pw.close();
    }

}
