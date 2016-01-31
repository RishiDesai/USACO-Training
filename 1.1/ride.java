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
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String comet = br.readLine();
        String group = br.readLine();

        int cometSum = 1;
        char[] ch = comet.toCharArray();
        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 64;
            if (temp <= 90 & temp >= 65) {
                int letter = temp - temp_integer;
                cometSum *= letter;
            }
        }

        int groupSum = 1;
        char[] ch2 = group.toCharArray();
        for (char s : ch2) {
            int temp2 = (int) s;
            int temp_integer2 = 64;
            if (temp2 <= 90 & temp2 >= 65) {
                int letter2 = temp2 - temp_integer2;
                groupSum *= letter2;
            }
        }

        if (groupSum % 47 == cometSum % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();
    }
}
