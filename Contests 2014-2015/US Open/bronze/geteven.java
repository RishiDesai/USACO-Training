/*
ID: rishide2
LANG: JAVA
TASK: geteven
*/
// created by rishi on 2/28/16
package USOpen.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class geteven {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("geteven.out")));

        final int N = Integer.parseInt(br.readLine());

        int[][] L = new int['Z' + 1][2];
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            char letter = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());

            if (val % 2 == 0)
                L[letter][0]++;
            else
                L[letter][1]++;
        }

        int ret = 0;
        for (int B = 0; B < 2; B++) {             // O(2^7) => O(1)
            for (int E = 0; E < 2; E++) {
                for (int S = 0; S < 2; S++) {
                    for (int I = 0; I < 2; I++) {
                        for (int G = 0; G < 2; G++) {
                            for (int O = 0; O < 2; O++) {
                                for (int M = 0; M < 2; M++) {

                                    if (((B + E + S + S + I + E) * (G + O + E + S) * (M + O + O)) % 2 == 0) {

                                        ret += L['B'][B] * L['E'][E] * L['S'][S] * L['I'][I]
                                                * L['G'][G] * L['O'][O] * L['M'][M];

                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        pw.println(ret);
        pw.close();
    }
    
}
