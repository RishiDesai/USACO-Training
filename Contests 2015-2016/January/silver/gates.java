/*
ID: rishide2
LANG: JAVA
TASK: gates
*/
// created by rishi on 9/2/16
package January.silver;

import java.io.*;
import java.util.LinkedList;

public class gates {
    
    private static final int L = 2016;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
        
        final int N = Integer.parseInt(br.readLine());
        final String row = br.readLine();
        
        boolean[][] grid = new boolean[L][L];
        
        int x = L / 2, y = L / 2;
        grid[x][y] = true;
        
        for (int i = 0; i < N; i++) {
            
            int vx = 0, vy = 0;
            
            if (row.charAt(i) == 'N') vx = -1;
            if (row.charAt(i) == 'S') vx = 1;
            if (row.charAt(i) == 'W') vy = -1;
            if (row.charAt(i) == 'E') vy = 1;
            
            for (int j = 0; j < 2; j++) {
                x += vx;
                y += vy;
                
                grid[x][y] = true;
            }
        }
        
        int ans = -1; // example: with two fields only one needs to be fenced
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                
                if (grid[i][j]) continue;
                grid[i][j] = true;
                
                ans++;
                
                bfs(grid, new Point(i, j));
            }
        }

        pw.println(ans);
        pw.close();
    }
    
    private static void bfs(boolean[][] grid, Point src) {
        
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(src.x, src.y));
        
        grid[src.x][src.y] = true;
        while (! queue.isEmpty()) {
            
            Point curr = queue.removeFirst();
            
            for (int k = 0; k < dx.length; k++) {
                
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                
                if (isValid(nx, ny) && ! grid[nx][ny]) {
                    grid[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        
    }
    
    private static boolean isValid(int i, int j) {
        return i >= 0 && i < L && j >= 0 && j < L;
    }
    
    private static final class Point {
        
        final int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Point)) return false;
            
            Point point = (Point) o;
            
            return x == point.x && y == point.y;
        }
        
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
        
    }
    
    private static final int[] dx = {- 1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, - 1};
    
}
