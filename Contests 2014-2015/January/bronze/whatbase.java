/*
ID: rishide2
LANG: JAVA
TASK: whatbase
*/
// created by rishi on 2/19/16
package January.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class whatbase {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whatbase.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whatbase.out")));

        final int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final char[]
                    X = st.nextToken().toCharArray(),
                    Y = st.nextToken().toCharArray();

            int baseX = 10, baseY = 10;

            while (baseX <= 15000 && baseY <= 15000) {
                int numX = toBase(X, baseX);
                int numY = toBase(Y, baseY);

                if (numX < numY) {
                    baseX++;
                } else if (numY < numX) {
                    baseY++;
                } else {
                    pw.println(baseX + " " + baseY);
                    break;
                }
            }

        }

        pw.close();
    }

    private static int toBase(char[] str, int base) {
        return ((str[0] - '0') * base * base +
                (str[1] - '0') * base + (str[2] - '0'));
    }
    
}
