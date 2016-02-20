/*
ID: rishide2
LANG: JAVA
TASK: crossword
*/
// created by rishi on 2/18/16
package December.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class crosswords {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crosswords.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        boolean[][] grid = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) == '.';
            }
        }

        int clues = 0;
        boolean[][] works = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                works[i][j] = isOk(i, j, grid);
                if (works[i][j]) clues++;
            }
        }

        pw.println(clues);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (works[i][j]) {
                    pw.println((i + 1) + " " + (j + 1));
                }
            }
        }

        pw.close();
    }

    private static boolean isOk(final int i, final int j, boolean[][] grid) {

        if (! grid[i][j]) return false;

        int x = - 1, y = - 1;

        if (i == 0 || ! grid[i - 1][j]) {      // vertical
            for (x = i; x < grid.length && x <= i + 3 && grid[x][j]; x++) ;
        }

        if (j == 0 || ! grid[i][j - 1]) {      // horizontal
            for (y = j; y < grid[i].length && y <= j + 3 && grid[i][y]; y++) ;
        }

        return x - i >= 3 || y - j >= 3;
    }
    
}
