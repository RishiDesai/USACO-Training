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
    private static String input;
    private static List<String> dict;
    private static char[][] keypad;
    private static int count = 0; // if there are no names

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
        pw = new PrintWriter(new File("namenum.out"));

        dict = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) dict.add(line.trim());

        br = new BufferedReader(new FileReader("namenum.in"));
        input = br.readLine().trim();

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

        recur(0, new StringBuilder());

        if (count == 0) pw.println("NONE");

        pw.close();
    }

    private static void recur(int ind, StringBuilder sb) {
        if (sb.length() == input.length()) {
            String str = sb.toString();
            if (Collections.binarySearch(dict, str) > 0) {
                pw.println(str);
//                System.out.println(str);
                count++;
            }
            return;
        }

        int key = Integer.parseInt(input.charAt(ind) + "");
        for (int i = 0; i < keypad[key].length; i++)
            recur(ind + 1, new StringBuilder(sb).append(keypad[key][i]));

    }

}
