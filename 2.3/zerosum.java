/* 
ID: rishide2
LANG: JAVA
TASK: zerosum
*/
// Created by Rishi on 11/23/2015.
package chapter2.sec3;

import java.io.*;

public class zerosum {

    private static int N;
    private static int[] C = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("zerosum.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        N = Integer.parseInt(br.readLine());

        dfs(1, "1");

        pw.close();
    }

    private static void dfs(int idx, String str) {
        if (idx == N) {

            if (eval(str)) {
                System.out.println(str);
                pw.println(str);
            }

            return;
        }

        idx++;

        dfs(idx, str + " " + C[idx]);
        dfs(idx, str + "+" + C[idx]);
        dfs(idx, str + "-" + C[idx]);
    }

    private static boolean eval(String str) {

        int sum = 0, add = 1, n = 2, idx = 1;
        char last = '+';

        while (n <= N) {

            char c = str.charAt(idx);

            if (c == ' ') {
                add *= 10;
                add += n;
            } else {

                if (last == '+')
                    sum += add;
                if (last == '-')
                    sum -= add;

                add = n;
                last = c;
            }

            n++;
            idx += 2;
        }

        return sum + (last == '+' ? add : 0 - add) == 0;
    }

}
