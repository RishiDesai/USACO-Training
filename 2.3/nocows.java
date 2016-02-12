/*
ID: rishide2
LANG: JAVA
TASK: nocows
*/
// created by rishi on 1/14/16
package chapter2.sec3;

import java.io.*;
import java.util.StringTokenizer;

/*
I want to give credit to dcp on this thread
http://apps.topcoder.com/forums/?module=Thread&threadID=514997
*/

public class nocows {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("nocows.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        if (N % 2 == 0) {
            pw.println(0);
            pw.close();
            return;
        }

        final int MOD = 9901;

        long[][] dp = new long[N + 1][K + 1];

        for (int h = 1; h <= K; h++) {

            dp[1][h] = 1;

            for (int n = 2; n <= N; n++) {

                dp[n][h] = 0;

                for (int p = 1; p <= n - 2; p++) {
                    dp[n][h] += dp[p][h - 1] * dp[n - 1 - p][h - 1];
                    dp[n][h] %= MOD;
                }

            }

        }

        long ans = (dp[N][K] - dp[N][K - 1] + MOD) % MOD;

        pw.println(ans);
        pw.close();
    }
    
}
