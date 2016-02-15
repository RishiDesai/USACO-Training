/*
ID: rishide2
LANG: JAVA
TASK: cowtour
*/
// created by rishi on 1/17/16
package chapter2.sec4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.MAX_VALUE;

/* I want to give some credit to JasonILTG for some help
at https://github.com/JasonILTG/USACO-Training/blob/master/2.4/cowtour.java
Thank you.
*/

public class cowtour {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtour.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));

        final int N = Integer.parseInt(br.readLine());

        int[] x = new int[N], y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        double[][] dist = new double[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            dist[i][i] = 0;
            for (int j = i + 1; j < N; j++) {
                if (line.charAt(j) == '1')
                    dist[i][j] = getDist(x[i], y[i], x[j], y[j]);
                else dist[i][j] = MAX_VALUE;

                dist[j][i] = dist[i][j];
            }
        }

        for (int k = 0; k < N; k++) {               // floyd-warshall
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] != MAX_VALUE && dist[k][j] != MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        double[] maxReach = new double[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] != MAX_VALUE && dist[i][j] > maxReach[i]) {
                    maxReach[i] = dist[i][j];
                }
            }
        }

        int[] fields = new int[N];
        for (int i = 0; i < N; i++) fields[i] = i;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] != MAX_VALUE) {
                    fields[i] = fields[j];
                }
            }
        }

        double[] diameters = new double[N];
        Arrays.fill(diameters, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (fields[i] == fields[j] && dist[i][j] > diameters[fields[i]]) {
                    diameters[fields[i]] = dist[i][j];
                }
            }
        }

        double ans = MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dist[i][j] == MAX_VALUE) {

                    double diam = getDist(x[i], y[i], x[j], y[j]);
                    diam += maxReach[i] + maxReach[j];

                    diam = Math.max(diam, Math.max(diameters[fields[i]], diameters[fields[j]]));

                    if (diam < ans) ans = diam;
                }
            }
        }

        pw.println(String.format("%.6f", ans));
        pw.close();
    }

    private static double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

}
