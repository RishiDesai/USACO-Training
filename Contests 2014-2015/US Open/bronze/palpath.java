/*
ID: rishide2
LANG: JAVA
TASK: palpath
*/
// created by rishi on 2/28/16
package USOpen.bronze;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class palpath {

    private static int N;
    private static char[][] grid;
    private static HashSet<String>[] set1, set2;
    private static boolean translated;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("palpath.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palpath.out")));

        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        set1 = new HashSet[N];
        set2 = new HashSet[N];

        for (int i = 0; i < N; i++) {
            set1[i] = new HashSet<String>();
            set2[i] = new HashSet<String>();
        }

        translated = false;

        dfs(0, 0, "");

        transpose(grid);
        translated = true;

        dfs(0, 0, "");

        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            for (String s : set1[i]) {
                if (set2[i].contains(s))
                    ans.add(s);
            }
        }

        pw.println(ans.size());
        pw.close();
    }

    private static void dfs(int i, int j, String s) {  // StringBuilder is more efficient
        if (i + j == N - 1) {                          // but here String is fast enough
            s += grid[i][j];

            if (! translated)
                set1[i].add(s);
            else
                set2[i].add(s);

            return;
        }

        s += grid[i][j];

        dfs(i + 1, j, s);
        dfs(i, j + 1, s);
    }

    public static void transpose(char[][] grid) {  // from USACO solutions.
        for (int i = 0; i < N; i++) {              // needed help on the translation
            for (int j = 0; j < N; j++) {
                if (i + j >= N - 1) continue;
                char t = grid[i][j];

                grid[i][j] = grid[N - 1 - j][N - 1 - i];
                grid[N - 1 - j][N - 1 - i] = t;
            }
        }
    }

}
