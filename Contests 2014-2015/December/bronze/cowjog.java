/*
ID: rishide2
LANG: JAVA
TASK: cowjog
*/
// created by rishi on 12/23/15
package December.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class cowjog {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));

        final int N = Integer.parseInt(br.readLine());

        int[] speed = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            speed[i] = Integer.parseInt(st.nextToken());
        }

        int ans = N;

        int min = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            if (speed[i] <= min)
                min = speed[i];
            else
                ans--;
        }

        pw.println(ans);
        pw.close();
    }

}

