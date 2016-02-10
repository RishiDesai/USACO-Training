/*
ID: rishide2
LANG: JAVA
TASK: runround
*/
// created by rishi on 9/27/15
package chapter2.sec2;

import java.io.*;

public class runround {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("runround.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

        int i = Integer.parseInt(br.readLine());
        while (true) {
            i++;
            if (isRunRound(i)) break;
        }

        pw.println(i);
        pw.close();
    }

    private static boolean isRunRound(int n) {

        char[] str = Integer.toString(n).toCharArray();
        boolean[] visit = new boolean[10];

        for (char c : str) {              // testing if n has unique #s and no 0s
            c -= '0';
            if (c == 0 || visit[c]) return false;

            visit[c] = true;
        }


        visit = new boolean[str.length];   //   testing if n is a runround #
        int ind = 0;

        int count = 0;
        while (count < str.length) {

            int moves = str[ind] - '0';   // eg. '8' - '0' = 8
            visit[ind] = true;

            for (int i = 0; i < moves; i++) {
                ind++;
                if (ind == str.length) ind = 0;
            }

            count++;
        }

        return allTrue(visit) && ind == 0; // all digits visited && returns to start of #
    }

    private static boolean allTrue(boolean[] visit) {
        for (boolean b : visit)
            if (! b) return false;

        return true; // every digit has been visited
    }

}
