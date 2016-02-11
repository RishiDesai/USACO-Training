/*
ID: rishide2
LANG: JAVA
TASK: ride
 */
package chapter1.sec1;

import java.io.*;

public class ride {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        final String comet = br.readLine();
        final String group = br.readLine();

        int cometNum = getNumber(comet);
        int groupNum = getNumber(group);

        if (cometNum == groupNum)
            pw.println("GO");
        else
            pw.println("STAY");

        pw.close();
    }

    private static int getNumber(final String str) {
        int ret = 1;

        for (int i = 0; i < str.length(); i++)
            ret *= str.charAt(i) - 64;

        return ret % 47;
    }

}
