/*
ID: rishide2
LANG: JAVA
TASK: superbull
*/
// created by rishi on 2/21/16
package February.silver;

import java.io.*;

public class superbull {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("superbull.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("superbull.out")));

        final int N = Integer.parseInt(br.readLine());

        long[] teams = new long[N];
        for (int i = 0; i < N; i++) {
            teams[i] = Long.parseLong(br.readLine());
        }

        boolean[] visit = new boolean[N];
        long[] set = new long[N];
        long ret = 0;

        for (int i = 0; i < N; i++) {

            int idx = - 1;
            for (int j = 0; j < N; j++) {
                if (! visit[j] && (idx == - 1 || set[j] > set[idx])) {
                    idx = j;
                }
            }

            visit[idx] = true;
            ret += set[idx];

            for (int j = 0; j < N; j++) {
                set[j] = Math.max(set[j], teams[j] ^ teams[idx]);
            }

        }

        pw.println(ret);
        pw.close();
    }

}
