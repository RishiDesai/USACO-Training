/*
ID: rishide2
LANG: JAVA
TASK: censor
*/
// created by rishi on 2/21/16
package February.silver;

import java.io.*;

/*
completes 13 / 15 test cases. too slow for #4 and #8.
Will work on this later.
*/

public class censor {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        final String
                txt = br.readLine(),
                pat = br.readLine();

        String ans = search(pat, txt);

        pw.println(ans);
        pw.close();
    }

    private static String search(String pat, String row) {

        final int M = pat.length();

        int[] table = makeTable(pat);
        StringBuilder sb = new StringBuilder(row);

        while (true) {

            final int N = sb.length();
            int i = 0, j = 0, count = 0;

            while (i < N) {
                if (pat.charAt(j) == sb.charAt(i)) {
                    j++;
                    i++;
                }

                if (j == M) {
                    sb.delete(i - j, i - j + M);
                    j = table[j - 1];

                    count++;
                    break;             // redo KMP on new string

                } else if (i < N && pat.charAt(j) != sb.charAt(i)) {
                    if (j != 0) {
                        j = table[j - 1];
                    } else {
                        i = i + 1;
                    }
                }
            }

            if (count == 0) break;      // pat is no longer in sb
        }

        return sb.toString();
    }

    private static int[] makeTable(String pat) {
        final int M = pat.length();
        int[] table = new int[M];

        int len = 0, i = 1;
        while (i < M) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len += 1;
                table[i] = len;
                i += 1;
            } else {
                if (len != 0) {
                    len = table[len - 1];
                } else {
                    table[i] = 0;
                    i += 1;
                }
            }

        }

        return table;
    }

}
