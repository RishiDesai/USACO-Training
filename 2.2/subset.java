/*
ID: rishide2
LANG: JAVA
TASK: subset
*/
// created by rishi on 10/24/15
package chapter2.sec2;

import java.io.*;

public class subset {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        final int N = Integer.parseInt(br.readLine());

        int sum = N * (N + 1) / 2;    // sum of #s 1..N

        if (sum % 2 == 1) {
            pw.println(0);
            pw.close();
            return;
        }

        int goal = sum / 2;

        long[][] dp = new long[N + 1][goal + 1];

        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {     // going through all #s

            dp[i][i] = 1;
            for (int j = 1; j < i; j++) {  // adding subsets from previous #s

                int max = j * (j + 1) / 2;
                for (int k = 1; k <= max && k + i <= goal; k++) {
                    dp[i][k + i] += dp[j][k];
                } // dp[i][k + i] eg. you won't add 4 to dp[i][1]. only add 4 to [i][4..N]

            }

        }

        long ans = dp[N][goal];

        pw.println(ans);
        pw.close();
    }

}
