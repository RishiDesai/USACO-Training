/*
ID: rishide2
LANG: JAVA
TASK: moocrypt
*/
// created by rishi on 2/28/16
package USOpen.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class moocrypt {

    private static char[][] grid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int ans = - 1;
        for (int i = 0; i < 26; i++) {    // O(26^2 * NM * 8) => O(NM)
            char m = (char) ('A' + i);

            if (m == 'M') continue;

            for (int j = 0; j < 26; j++) {
                char o = (char) ('A' + j);

                if (o == 'O') continue;

                if (m != o) {
                    int poss = find(m, o);
                    if (poss > ans) ans = poss;
                }
            }

        }

        pw.println(ans);
        pw.close();
    }

    private static int find(char m, char o) {

        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == m) {

                    for (int k = 0; k < 8; k++) {

                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        int fx = i + (2 * dx[k]);
                        int fy = j + (2 * dy[k]);

                        if (isValid(nx, ny) && isValid(fx, fy)) {

                            if (grid[nx][ny] == o && grid[fx][fy] == o) {
                                ret++;
                            }

                        }

                    }

                }

            }
        }

        return ret;
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

    private static int[]
            dx = {- 1, - 1, - 1, 0, 1, 1, 1, 0},
            dy = {- 1, 0, 1, 1, 1, 0, - 1, - 1};

}
