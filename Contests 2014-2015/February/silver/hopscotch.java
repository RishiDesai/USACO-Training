/*
ID: rishide2
LANG: JAVA
TASK: hopscotch
*/
// created by rishi on 2/21/16
package February.silver;

import java.io.*;
import java.util.StringTokenizer;

public class hopscotch {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                R = Integer.parseInt(st.nextToken()),
                C = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());

        int[][] grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final long MOD = 1000000007;
        long[][] dp = new long[R][C];

        dp[0][0] = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int a = i + 1; a < R; a++) {
                    for (int b = j + 1; b < C; b++) {
                        if (grid[i][j] != grid[a][b]) {
                            dp[a][b] += dp[i][j];
                            dp[a][b] %= MOD;
                        }
                    }
                }
            }
        }

        pw.println(dp[R - 1][C - 1]);
        pw.close();
    }
    
}
