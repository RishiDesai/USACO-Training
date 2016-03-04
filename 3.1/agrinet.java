/*
ID: rishide2
LANG: JAVA
TASK: agrinet
*/
// created by rishi on 2/29/16
package chapter3.sec1;

import java.io.*;
import java.util.StringTokenizer;

public class agrinet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("agrinet.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));

        final int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        int x = 0, y = 0;
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                matrix[x][y] = Integer.parseInt(st.nextToken());
                y++;
                if (y == N) {
                    x++;
                    y = 0;
                }
            }
        }

        int[] dist = new int[N];
        for (int i = 0; i < N; i++) dist[i] = matrix[i][0];

        boolean[] visit = new boolean[N];

        int ret = 0;
        for (int i = 0; i < N; i++) {

            int idx = - 1, min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (! visit[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }

            ret += min;
            visit[idx] = true;
            dist[idx] = 0;

            for (int j = 0; j < N; j++) {
                if (matrix[idx][j] < dist[j]) dist[j] = matrix[idx][j];
            }
        }

        pw.println(ret);
        pw.close();
    }
    
}
