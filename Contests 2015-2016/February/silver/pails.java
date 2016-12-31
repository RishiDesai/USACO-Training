/*
ID: rishide2
LANG: JAVA
TASK: pails
*/
// created by rishi on 4/1/16
package February.silver;

import java.io.*;
import java.util.StringTokenizer;

public class pails {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                X = Integer.parseInt(st.nextToken()),
                Y = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        boolean[][][] dp = new boolean[K + 1][X + 1][Y + 1];   // knapsack

        dp[0][0][0] = true;
        for (int k = 1; k <= K; k++) {

            for (int x = 0; x <= X; x++) {
                for (int y = 0; y <= Y; y++) {
                    if (! dp[k - 1][x][y]) continue;

                    dp[k][x][y] = true;   // same state

                    dp[k][x][0] = true;   // empty buckets
                    dp[k][0][y] = true;

                    dp[k][X][y] = true;   // fill buckets
                    dp[k][x][Y] = true;

                    int min = Math.min(x, Y - y);  // pour x -> y
                    dp[k][x - min][y + min] = true;

                    min = Math.min(y, X - x);      // pour y -> x
                    dp[k][x + min][y - min] = true;

                }
            }

        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                if (! dp[K][i][j]) continue;

                int val = Math.abs(i + j - M);
                if (val < ans) ans = val;
            }
        }

        pw.println(ans);
        pw.close();
    }
    
}
