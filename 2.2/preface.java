/*
ID: rishide2
LANG: JAVA
TASK: preface
*/
// created by rishi on 9/27/15
package chapter2.sec2;

import java.io.*;

/*
I want to give credit to JasonLTG
at https://github.com/JasonILTG/USACO-Training/blob/master/2.2/preface.java
Thank you.
*/

public class preface {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

        final int N = Integer.parseInt(br.readLine());

        String[] numerals = new String[]{"I", "V", "X", "L", "C", "D", "M"};

        int[] ans = new int[7];
        for (int i = 1; i <= N; i++) {
            int[] curr = toNumeral(i);
            for (int j = 0; j < 7; j++)
                ans[j] += curr[j];
        }

        for (int i = 0; i < 7; i++)
            if (ans[i] != 0)
                pw.println(numerals[i] + " " + ans[i]);

        pw.close();
    }

    private static int[] toNumeral(int n) {

        int[] places = new int[7];
        for (int i = 0; i < places.length; i += 2) {
            places[i] = n % 10;
            n /= 10;
        }

        int[] add = new int[7];
        for (int i = 0; i < add.length; i += 2) {

            if (places[i] == 4) {
                places[i] = 1;
                places[i + 1]++;
            }

            if (places[i] == 9) {
                places[i] = 1;
                add[i + 2]++;
            }

            if (places[i] >= 5) {
                places[i] -= 5;
                places[i + 1]++;
            }

            places[i] += add[i];
        }

        return places;
    }

}
