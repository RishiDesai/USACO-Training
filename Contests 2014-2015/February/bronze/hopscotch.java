/*
ID: rishide2
LANG: JAVA
TASK: hopscotch
*/
// created by rishi on 2/21/16
package February.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class hopscotch {

    private static char[][] grid;
    private static int R, C, ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);

        pw.println(ans);
        pw.close();
    }

    private static void dfs(int i, int j) {

        if (i == R - 1 && j == C - 1) {
            ans++;
            return;
        }

        for (int x = i + 1; x < R; x++) {
            for (int y = j + 1; y < C; y++) {

                if (grid[x][y] != grid[i][j])
                    dfs(x, y);

            }
        }

    }
    
}
