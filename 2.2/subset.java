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

        long[] dp = new long[sum + 1];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = sum - i; j >= 0; j--) {
                dp[i + j] += dp[j];
            }
        }

        long ans = dp[sum / 2] / 2;

        pw.println(ans);
        pw.close();
    }

}
