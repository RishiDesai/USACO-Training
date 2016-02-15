/*
ID: rishide2
LANG: JAVA
TASK: maze1
*/
// created by rishi on 1/17/16
package chapter2.sec4;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class maze1 {

    private static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maze1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        char[][] grid = new char[H * 2 + 1][W * 2 + 1];

        for (int i = 0; i < H * 2 + 1; i++) {
            String line = br.readLine();
            while (line.length() < W * 2 + 1) line += ' ';   // exit on east wall
            for (int j = 0; j < W * 2 + 1; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int p = 0;
        int[][] exit = {{MAX_VALUE, MAX_VALUE}, {MAX_VALUE, MAX_VALUE}};
        boolean[][][] connect = new boolean[H][W][4];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                int x = i * 2 + 1;
                int y = j * 2 + 1;

                boolean
                        n = grid[x - 1][y] == ' ',
                        s = grid[x + 1][y] == ' ',
                        e = grid[x][y + 1] == ' ',
                        w = grid[x][y - 1] == ' ';

                connect[i][j][UP] = n;
                connect[i][j][DOWN] = s;
                connect[i][j][RIGHT] = e;
                connect[i][j][LEFT] = w;

                if (((n && i == 0) || (s && i == H - 1) ||
                        (e && j == W - 1) || (w && j == 0))) {
                    exit[p++] = new int[]{i, j};
                }

            }
        }

        int[][][] dist = new int[2][H][W];         // 2 for two exits
        for (int n = 0; n < 2; n++) {              // dijkstra

            boolean[][] visit = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    dist[n][i][j] = MAX_VALUE;
                }
            }

            if (exit[n][0] == MAX_VALUE) {          // 2 exits on one cell
                continue;
            }

            dist[n][exit[n][0]][exit[n][1]] = 1;

            for (int k = 0; k < W * H; k++) {

                int min = MAX_VALUE;
                int[] idx = {0, 0};

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (! visit[i][j] && dist[n][i][j] < min) {
                            min = dist[n][i][j];
                            idx = new int[]{i, j};
                        }
                    }
                }

                visit[idx[0]][idx[1]] = true;

                for (int d = 0; d < 4; d++) {

                    int nx = idx[0] + dx[d];
                    int ny = idx[1] + dy[d];

                    if (! isValid(nx, ny)) continue;

                    if (connect[idx[0]][idx[1]][d] && min + 1 < dist[n][nx][ny]) {
                        dist[n][nx][ny] = min + 1;
                    }

                }

            }
        }

        int max = - 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int min = Math.min(dist[0][i][j], dist[1][i][j]);
                if (min > max) max = min;
            }
        }

        pw.println(max);
        pw.close();
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < H && j >= 0 && j < W;
    }

    private static final int[] dx = {- 1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, - 1};
    private static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

}
