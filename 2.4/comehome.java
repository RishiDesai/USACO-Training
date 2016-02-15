/*
ID: rishide2
LANG: JAVA
TASK: comehome
*/
// created by rishi on 1/17/16
package chapter2.sec4;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class comehome {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("comehome.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));

        final int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[52][52];

        for (int i = 0; i < 52; i++)
            for (int j = 0; j < 52; j++)
                dist[i][j] = MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char from = st.nextToken().charAt(0);
            int f = (Character.isUpperCase(from)) ? from - 'A' : from - 'A' - 6;

            char to = st.nextToken().charAt(0);
            int t = (Character.isUpperCase(to)) ? to - 'A' : to - 'A' - 6;

            int weight = Integer.parseInt(st.nextToken());
            if (weight < dist[f][t]) {
                dist[f][t] = weight;
                dist[t][f] = weight;
            }
        }

        for (int k = 0; k < 52; k++)
            for (int i = 0; i < 52; i++)
                for (int j = 0; j < 52; j++)
                    if (dist[i][k] != MAX_VALUE && dist[k][j] != MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        int min = 0;
        for (int i = 1; i < 25; i++)
            if (dist[i][25] < dist[min][25])
                min = i;


        pw.println((char) (min + 'A') + " " + dist[min][25]);
        pw.close();
    }

}
