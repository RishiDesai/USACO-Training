/*
ID: rishide2
LANG: JAVA
TASK: meeting
*/
// created by rishi on 2/20/16
package January.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class meeting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("meeting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meeting.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] bessie = new int[N][N], elsie = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            bessie[a][b] = Integer.parseInt(st.nextToken());
            elsie[a][b] = Integer.parseInt(st.nextToken());
        }

        boolean[] bworks = new boolean[1 << 15];  // eg. 1 * (2^15)
        dfs(bessie, bworks, 0, 0);

        boolean[] eworks = new boolean[1 << 15];
        dfs(elsie, eworks, 0, 0);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < bworks.length; i++) {
            if (bworks[i] && eworks[i]) {
                ans = i;
                break;
            }
        }

        if (ans == Integer.MAX_VALUE)
            pw.println("IMPOSSIBLE");
        else
            pw.println(ans);

        pw.close();
    }

    private static void dfs(int[][] path, boolean[] can, int x, int dist) {
        if (x == path.length - 1) {
            can[dist] = true;
            return;
        }

        for (int i = x + 1; i < path.length; i++) {
            if (path[x][i] > 0) {
                dfs(path, can, i, dist + path[x][i]);
            }
        }

    }
    
}
