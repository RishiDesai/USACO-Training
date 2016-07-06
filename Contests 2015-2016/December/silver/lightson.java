/*
ID: rishide2
LANG: JAVA
TASK: lightson
*/
// created by rishi on 7/6/16
package December.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lightson {

    private static int N;
    private static ArrayList<Point>[][] switches;
    private static boolean[][] isOn, visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        isOn = new boolean[N][N];
        visited = new boolean[N][N];

        switches = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switches[i][j] = new ArrayList<Point>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            final int
                    x = Integer.parseInt(st.nextToken()) - 1,
                    y = Integer.parseInt(st.nextToken()) - 1,
                    a = Integer.parseInt(st.nextToken()) - 1,
                    b = Integer.parseInt(st.nextToken()) - 1;

            switches[x][y].add(new Point(a, b));
        }

        isOn[0][0] = true;
        search(0, 0);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isOn[i][j]) ans++;
            }
        }

        pw.println(ans);
        pw.close();
    }

    private static void search(int x, int y) {

        if (visited[x][y]) return;
        visited[x][y] = true;

        for (Point p : switches[x][y]) {

            if (! isOn[p.x][p.y]) {
                isOn[p.x][p.y] = true;

                for (int k = 0; k < 4; k++) { // "jump" to the square by looking if any
                    int nx = p.x + dx[k];     // adjacent squares have been reached
                    int ny = p.y + dy[k];

                    if (isValid(nx, ny) && visited[nx][ny]) {
                        search(p.x, p.y);
                    }
                }
            }
        }

        for (int k = 0; k < 4; k++) { // check the four cardinal directions
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isValid(nx, ny) && isOn[nx][ny]) {
                search(nx, ny);
            }
        }

    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    private static class Point {  // immutable

        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }

    }
    
    private static final int[] dx = {- 1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, - 1};

}
