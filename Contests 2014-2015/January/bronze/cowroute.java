/*
ID: rishide2
LANG: JAVA
TASK: cowroute
*/
// created by rishi on 2/20/16
package January.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class cowroute {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int[] places = new int[num];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < num; j++) {
                places[j] = Integer.parseInt(st.nextToken());
            }

            boolean fa = false;
            for (int j = 0; j < num; j++) {
                if (places[j] == A) fa = true;
                if (places[j] == B && fa) {
                    if (cost < ans) ans = cost;
                    break;
                }
            }

        }

        if (ans != Integer.MAX_VALUE)
            pw.println(ans);
        else
            pw.println(- 1);

        pw.close();
    }

}
