/*
ID: rishide2
LANG: JAVA
TASK: censor
*/
// created by rishi on 2/21/16
package February.bronze;

import java.io.*;

public class censor {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        final String S = br.readLine();
        final String T = br.readLine();

        int tl = T.length();

        StringBuilder sb = new StringBuilder(S.length());
        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));

            int sl = sb.length();

            if (sl >= tl) {
                if (sb.substring(sl - tl).equals(T)) {
                    sb.delete(sl - tl, sl);
                }
            }

        }

        pw.println(sb.toString());
        pw.close();
    }

}
