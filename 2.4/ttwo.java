/*
ID: rishide2
LANG: JAVA
TASK: ttwo
*/
// created by rishi on 1/16/16
package chapter2.sec4;

import java.io.*;

public class ttwo {

    private static final int N = 10;
    private static boolean[][] obstacle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ttwo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));

        Point F = new Point(- 1, - 1);  // default
        Point C = new Point(- 1, - 1);

        obstacle = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                char k = line.charAt(j);
                obstacle[i][j] = k == '*';

                if (k == 'F') F = new Point(i, j);
                if (k == 'C') C = new Point(i, j);
            }

        }

        // clockwise => [ up -> right -> down -> left ]
        final int[] dx = {- 1, 0, 1, 0};
        final int[] dy = {0, 1, 0, - 1};

        boolean[][][][][][] visit = new boolean[N][N][4][N][N][4];

        int fDir = 0, cDir = 0, min = 0;

        while (! visit[F.x][F.y][fDir][C.x][C.y][cDir]) { // unvisited pos

            visit[F.x][F.y][fDir][C.x][C.y][cDir] = true;

            int fx = F.x + dx[fDir];
            int fy = F.y + dy[fDir];

            Point fp = new Point(fx, fy);

            if (isValid(fp))
                F = fp;
            else
                fDir = (fDir + 1) % 4;

            int cx = C.x + dx[cDir];
            int cy = C.y + dy[cDir];

            Point cp = new Point(cx, cy);

            if (isValid(cp))
                C = cp;
            else
                cDir = (cDir + 1) % 4;

            min++;

            if (F.x == C.x && F.y == C.y) {
                pw.println(min);
                pw.close();
                return;
            }

        }

        pw.println(0);   // impossible
        pw.close();
    }

    private static boolean isValid(Point p) {
        return p.x >= 0 && p.x < N && p.y >= 0 && p.y < N && ! obstacle[p.x][p.y];
    }

    private static class Point {  // immutable

        protected final int x, y;

        protected Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
