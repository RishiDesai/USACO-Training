/*
ID: rishide2
LANG: JAVA
TASK: humble
*/
// created by rishi on 2/15/16
package chapter3.sec1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class humble {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("humble.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] ps = new int[K];
        for (int i = 0; i < K; i++) {
            ps[i] = Integer.parseInt(st.nextToken());
        }

        int[] index = new int[N];
        List<Long> hum = new ArrayList<Long>();

        hum.add(1L);
        for (int i = 0; i < N; i++) {

            long low = Long.MAX_VALUE;
            for (int j = 0; j < K; j++) {

                int idx = index[j], l = hum.size();
                while (idx < l && hum.get(idx) * ps[j] <= hum.get(l - 1)) {
                    idx++;
                }

                low = Math.min(low, hum.get(idx) * ps[j]);
                index[j] = idx;
            }

            hum.add(low);
        }

        pw.println(hum.get(N));
        pw.close();
    }

}
