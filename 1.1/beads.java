/*
ID: rishide2
LANG: JAVA
TASK: beads
*/
// Created by Rishi on 7/11/2015.
package chapter1.sec1;

import java.io.*;

public class beads {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        final int N = Integer.parseInt(br.readLine());

        char[] beads = br.readLine().toCharArray();

        int ans = solve(beads);

        pw.println(ans);
        pw.close();
    }

    private static int solve(char[] beads) {
        final int len = beads.length;
        int ret = 0;

        for (int ind = 0; ind < beads.length; ind++) {

            int rb = 0, lb = 0, rr = 0, lr = 0;

            for (int i = ind + 1; rr < len; i++) { // right reds
                if (i == len) i = 0;
                if (beads[i] == 'r' || beads[i] == 'w') rr++;
                else break;
            }

            for (int i = ind + 1; rb < len; i++) { // right blues
                if (i == len) i = 0;
                if (beads[i] == 'b' || beads[i] == 'w') rb++;
                else break;
            }

            for (int i = ind - 1; lr < len; i--) { // left reds
                if (i == - 1) i = len - 1;
                if (beads[i] == 'r' || beads[i] == 'w') lr++;
                else break;
            }

            for (int i = ind - 1; lb < len; i--) { // left blues
                if (i == - 1) i = len - 1;
                if (beads[i] == 'b' || beads[i] == 'w') lb++;
                else break;
            }

            int c1 = rr + lb + 1; // + 1 for the beads[ind] itself
            int c2 = lr + rb + 1;

            ret = Math.max(ret, Math.max(c1, c2));
        }

        return Math.min(ret, len);  // (answer <= len)
    }

}
