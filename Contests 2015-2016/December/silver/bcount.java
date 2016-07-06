/*
ID: rishide2
LANG: JAVA
TASK: bcount
*/
// created by rishi on 4/1/16
package December.silver;

import java.io.*;
import java.util.StringTokenizer;

public class bcount {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());

        int[][] dp = new int[4][N + 1];
        // dp[bread ID][# of cows of this breed ID so far, at the given index]

        for (int i = 1; i <= N; i++) {
            final int ID = Integer.parseInt(br.readLine());

            for (int j = 1; j <= 3; j++) {
                dp[j][i] = dp[j][i - 1];
            }

            dp[ID][i]++;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());

            String ans = "";
            for (int j = 1; j <= 3; j++) {
                ans += dp[j][B] - dp[j][A - 1] + " ";
            }

            pw.println(ans.trim());  // .trim() gets rid of trailing whitespace
        }

        pw.close();
    }
    
}
