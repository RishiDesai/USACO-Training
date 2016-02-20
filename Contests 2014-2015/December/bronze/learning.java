/*
ID: rishide2
LANG: JAVA
TASK: learning
*/
// created by rishi on 2/18/16
package December.bronze;

/*
I recieved help from the contest overview
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class learning {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("learning.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                N = Integer.parseInt(st.nextToken()),
                A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken());

        Cow[] cows = new Cow[N + 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean spots = st.nextToken().equals("S");
            int weight = Integer.parseInt(st.nextToken());

            cows[i] = new Cow(spots, weight);
        }

        cows[N] = new Cow(false, Integer.MIN_VALUE);
        cows[N + 1] = new Cow(false, Integer.MAX_VALUE);
        Arrays.sort(cows);

        int ans = 0;
        for (int i = 0; i <= N; i++) {
            int low = cows[i].weight;
            int high = cows[i + 1].weight;
            int mid = (low + high) / 2;

            if (cows[i].spots) {
                int s = Math.max(A, low + 1);
                int e = Math.min(B, mid);
                if (e >= s) {
                    ans += e - s + 1;
                }
            }

            if (cows[i + 1].spots) {
                int s = Math.max(A, mid + 1);
                int e = Math.min(B, high);
                if (e >= s) {
                    ans += e - s + 1;
                }
            }

            if (cows[i + 1].spots && ! cows[i].spots && (low % 2) == (high % 2)
                    && A <= mid && mid <= B) {
                ans++;
            }
        }

        pw.println(ans);
        pw.close();
    }

    private static class Cow implements Comparable<Cow> {  // immutable

        private final boolean spots;
        private final int weight;

        protected Cow(boolean spots, int weight) {
            this.spots = spots;
            this.weight = weight;
        }

        @Override
        public int compareTo(Cow cow) {
            if (weight > cow.weight) return 1;
            if (weight < cow.weight) return - 1;
            return 0;
        }

    }
    
}
