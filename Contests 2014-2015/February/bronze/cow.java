/*
ID: rishide2
LANG: JAVA
TASK: cow
*/
// created by rishi on 2/21/16
package February.bronze;

import java.io.*;

public class cow {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cow.out")));

        final int N = Integer.parseInt(br.readLine());
        final String row = br.readLine();

        long C = 0, CO = 0, COW = 0;
        for (int i = 0; i < N; i++) {
            char c = row.charAt(i);
            if (c == 'C') C++;
            if (c == 'O') CO += C;
            if (c == 'W') COW += CO;
        }

        pw.println(COW);
        pw.close();
    }

}
