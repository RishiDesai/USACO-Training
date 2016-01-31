/*
ID: rishide2
LANG: JAVA
TASK: beads
*/
// Created by Rishi on 7/11/2015.
package chapter1.sec1;

import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class beads {

    private static char[] beads;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        final int N = Integer.parseInt(br.readLine());

        beads = br.readLine().toCharArray();

        int ans = solve();

        System.out.println(ans);
        pw.println(ans);

        pw.close();
    }

    private static int solve() {
        final int len = beads.length;
        int max = 0;

        for (int ind = 0; ind < beads.length; ind++) {

            int rb = 0, lb = 0, rr = 0, lr = 0;

            for (int i = ind + 1; ; i++) { // right reds
                if (i == len) i = 0;
                if (beads[i] == 'r' || beads[i] == 'w') rr++;
                else break;
                if (rr == len) break;
            }

            for (int i = ind + 1; ; i++) { // right blues
                if (i == len) i = 0;
                if (beads[i] == 'b' || beads[i] == 'w') rb++;
                else break;
                if (rb == len) break;
            }

            for (int i = ind - 1; ; i--) { // left reds
                if (i == - 1) i = len - 1;
                if (beads[i] == 'r' || beads[i] == 'w') lr++;
                else break;
                if (lr == len) break;
            }

            for (int i = ind - 1; ; i--) { // left blues
                if (i == - 1) i = len - 1;
                if (beads[i] == 'b' || beads[i] == 'w') lb++;
                else break;
                if (lb == len) break;
            }

            int c1 = rr + lb + 1; // + 1 for the beads[ind] itself
            int c2 = lr + rb + 1;

            max = min(max(max, max(c1, c2)), len); // most can be len of beads
        }

        return max;
    }

}
