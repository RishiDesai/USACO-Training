/*
ID: rishide2
LANG: JAVA
TASK: trapped
*/
// created by rishi on 2/28/16
package USOpen.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class trapped {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));

        final int N = Integer.parseInt(br.readLine());

        Bale[] bales = new Bale[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            bales[i] = new Bale(x, size);
        }

        Arrays.sort(bales);

        int ret = 0;
        for (int i = 0; i < N - 1; i++) {

            int area = bales[i + 1].pos - bales[i].pos;
            int left = i, right = i + 1;

            while (left >= 0 && right <= N - 1) {
                boolean broke = false;

                int dist = bales[right].pos - bales[left].pos;

                if (dist > bales[left].size) {
                    left--;
                    broke = true;
                }

                if (dist > bales[right].size) {
                    right++;
                    broke = true;
                }

                if (! broke) break;
            }

            if (left >= 0 && right <= N - 1) {
                ret += area;
            }

        }

        pw.println(ret);
        pw.close();
    }

    private static class Bale implements Comparable<Bale> {  // immutable

        private final int pos, size;

        public Bale(int pos, int size) {
            this.pos = pos;
            this.size = size;
        }

        public int compareTo(Bale b) {
            return pos - b.pos;
        }

    }

}
