/*
ID: rishide2
LANG: JAVA
TASK: milk2
*/
// created by rishi on 7/27/15
package chapter1.sec2;

import java.io.*;
import java.util.StringTokenizer;

public class milk2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        final int N = Integer.parseInt(br.readLine());

        boolean[] time = new boolean[1000000 + 1];
        int start = 1 << 30, end = - 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            for (int t = low; t < high; t++) {
                time[t] = true;
            }

            if (low < start) start = low;
            if (high > end) end = high;
        }

        int maxIs = 0, maxNot = 0;
        int is = 0, not = 0;
        for (int i = start; i < end; i++) {

            if (time[i]) {
                is++;
                not = 0;
            } else {
                not++;
                is = 0;
            }
            if (is > maxIs) maxIs = is;
            if (not > maxNot) maxNot = not;

        }

        pw.println(maxIs + " " + maxNot);
        pw.close();
    }

}
