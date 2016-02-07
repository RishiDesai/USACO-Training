/*
ID: rishide2
LANG: JAVA
TASK: hamming
*/
// created by rishi on 8/25/15
package chapter2.sec1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class hamming {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                N = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                D = Integer.parseInt(st.nextToken());

        List<Integer> codes = new ArrayList<Integer>();
        codes.add(0);

        int limit = 1 << B;
        for (int i = 0; i < limit && codes.size() < N; i++) {
            boolean fits = true;
            for (int c : codes)
                if (hamDist(i, c) < D) fits = false;

            if (fits) codes.add(i);
        }

        int key = 0;
        for (int i = 0; i < codes.size(); i++) {
            key++;
            if (key == 10 || i == codes.size() - 1) {
                pw.println(codes.get(i));
                key = 0;
            } else
                pw.print(codes.get(i) + " ");
        }

        pw.close();
    }

    private static int hamDist(int a, int b) {
        int num = a ^ b;
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) count++;
            num /= 2;
        }

        return count;
    }

}
