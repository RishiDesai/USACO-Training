/*
ID: rishide2
LANG: JAVA
TASK: milk2
*/
// created by rishi on 7/27/15
package chapter1.sec2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        final int N = Integer.parseInt(br.readLine());

        int[][] farmers = new int[N][2];
        int[] lows = new int[N];
        int[] highs = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            lows[i] = start;
            highs[i] = finish;
            farmers[i] = new int[]{start, finish};
        }

        Arrays.sort(farmers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(lows);
        Arrays.sort(highs);

        final int low = lows[0];
        final int high = highs[highs.length - 1];

        boolean[] time = new boolean[high];

        for (int[] farmer : farmers)
            for (int t = farmer[0]; t < farmer[1]; t++)
                time[t] = true;


        int maxMilking = 0, maxNotMilking = 0;
        int milking = 0, notMilking = 0;
        for (int i = low; i < high; i++) {

            if (time[i]) {
                milking++;
                notMilking = 0;
            } else {
                notMilking++;
                milking = 0;
            }
            maxNotMilking = Math.max(maxNotMilking, notMilking);
            maxMilking = Math.max(maxMilking, milking);
        }

        pw.println(maxMilking + " " + maxNotMilking);
        System.out.println(maxMilking + " " + maxNotMilking);
        pw.close();
    }

}
