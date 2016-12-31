/*
ID: rishide2
LANG: JAVA
TASK: radio
*/
// created by rishi on 3/27/16
package January.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class radio {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("radio.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int fx = Integer.parseInt(st.nextToken());
        int fy = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        
        final String fs = br.readLine();
        final String bs = br.readLine();
        
        List<Point> F = new ArrayList<Point>();
        List<Point> B = new ArrayList<Point>();
        
        F.add(new Point(fx, fy));
        B.add(new Point(bx, by));
        
        for (int i = 0; i < fs.length(); i++) {
            char c = fs.charAt(i);
            
            if (c == 'N') fy++;
            if (c == 'S') fy--;
            if (c == 'E') fx++;
            if (c == 'W') fx--;
            
            F.add(new Point(fx, fy));
        }
        
        for (int i = 0; i < bs.length(); i++) {
            char c = bs.charAt(i);
            
            if (c == 'N') by++;
            if (c == 'S') by--;
            if (c == 'E') bx++;
            if (c == 'W') bx--;
            
            B.add(new Point(bx, by));
        }
        
        long[][] dp = new long[N + 1][M + 1]; // much faster than memoization
        
        for (int i = 1; i <= N; i++)
            dp[i][0] = dp[i - 1][0] + dist(F.get(i), B.get(0));
        
        for (int i = 1; i <= M; i++)
            dp[0][i] = dp[0][i - 1] + dist(F.get(0), B.get(i));
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                dp[i][j] += dist(F.get(i), B.get(j));
            }
        }
        
        pw.println(dp[N][M]);
        pw.close();
    }
    
    private static long dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
    
    private static class Point {
        
        final int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
}
