/*
ID: rishide2
LANG: JAVA
TASK: marathon
*/
// created by rishi on 2/19/16
package December.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class marathon {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));

        final int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += getDist(points[i], points[i + 1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int curr = getDist(points[i - 1], points[i]) + getDist(points[i], points[i + 1]);

            int skip = getDist(points[i - 1], points[i + 1]);

            if (sum - curr + skip < min) min = sum - curr + skip;
        }

        pw.println(min);
        pw.close();
    }

    private static int getDist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    
    private static class Point {
        
        protected final int x, y;
        
        protected Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
