/*
ID: rishide2
LANG: JAVA
TASK: transform
*/
// Created by Rishi on 7/26/2015.
package chapter1.sec2;

import java.io.*;
import java.util.Arrays;

public class transform {

    private static int N;
    private static char[][] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        N = Integer.parseInt(br.readLine());

        char[][] start = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                start[i][j] = line.charAt(j);
            }
        }

        target = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                target[i][j] = line.charAt(j);
            }
        }

        int ans;

        if (E(rot(start)))
            ans = 1;

        else if (E(rot(rot(start))))
            ans = 2;

        else if (E(rot(rot(rot(start)))))
            ans = 3;

        else if (E(refl(start)))
            ans = 4;

        else if (E(rot(refl(start))) ||
                E(rot(rot(refl(start)))) ||
                E(rot(rot(rot(refl(start))))))
            ans = 5;

        else if (E(start))
            ans = 6;

        else
            ans = 7;

        pw.println(ans);
        pw.close();
    }

    private static char[][] rot(char[][] in) {  // 90 degrees rotation
        char[][] out = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                out[j][i] = in[N - i - 1][j];

        return out;
    }

    private static char[][] refl(char[][] in) {  // reflection
        char[][] out = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                out[i][j] = in[i][N - j - 1];

        return out;
    }

    private static boolean E(char[][] in) {    // made this function for concise 'if' statements above
        return Arrays.deepEquals(target, in);  // tests that elements equal each other
    }

}
