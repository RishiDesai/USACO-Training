/*
ID: rishide2
LANG: JAVA
TASK: prefix
*/
// created by rishi on 11/22/15
package chapter2.sec3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prefix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

        @SuppressWarnings("unchecked")
        ArrayList<String>[] prim = new ArrayList[11];

        for (int i = 0; i < prim.length; i++)
            prim[i] = new ArrayList<String>();

        String line = br.readLine();
        while (! line.equals(".")) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                prim[str.length()].add(str);
            }

            line = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null)
            sb.append(line.trim());

        final String row = sb.toString();

        boolean[] dp = new boolean[row.length() + 1];  // knapsack

        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {

            if (! dp[i]) continue;

            for (int j = 10; j >= 1; j--) {

                if (i + j > row.length()) continue;

                String piece = row.substring(i, i + j);  // call substring() once
                for (String p : prim[j]) {

                    if (piece.equals(p)) {
                        dp[i + j] = true;
                    }

                }

            }

        }

        int ret = dp.length - 1;
        while (! dp[ret]) ret--;

        pw.println(ret);
        pw.close();
    }

}
