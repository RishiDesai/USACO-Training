/*
ID: rishide2
LANG: JAVA
TASK: namenum
*/
// created by rishi on 7/27/15

package chapter1.sec2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class namenum {

    private static PrintWriter pw;
    private static char[][] keypad;
    private static List<String> dict;
    private static String input;
    private static boolean none = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));

        dict = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) dict.add(line);

        br = new BufferedReader(new FileReader("namenum.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        input = br.readLine();     // input numbers

        keypad = new char[][]{
                {},
                {},
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
                {'J', 'K', 'L'},
                {'M', 'N', 'O'},
                {'P', 'R', 'S'},
                {'T', 'U', 'V'},
                {'W', 'X', 'Y'}
        };

        recur("");

        if (none) pw.println("NONE");

        pw.close();
    }

    private static void recur(String s) {        // StringBuilder isn't necessary here
        if (s.length() == input.length()) {      // dfs

            if (Collections.binarySearch(dict, s) >= 0) {
                none = false;
                pw.println(s);
            }

            return;
        }

        int key = Integer.parseInt(input.charAt(s.length()) + "");

        for (int i = 0; i < keypad[key].length; i++) {
            recur(s + keypad[key][i]);
        }
    }

}
