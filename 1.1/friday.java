/*
ID: rishide2
LANG: JAVA
TASK: friday
*/
// Created by Rishi on 7/11/2015.
package chapter1.sec1;

import java.io.*;

public class friday {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        final int N = Integer.parseInt(br.readLine());

        int year = 1900 + N;
        int[] wk = new int[7];
        int dayOfWeek = 6;

        for (int y = 1900; y < year; y++) {
            for (int m = 1; m <= 12; m++) {
                wk[dayOfWeek]++;

                int days = monthDays(y, m);

                dayOfWeek += days;
                dayOfWeek %= 7;
            }
        }

        pw.print(
                wk[6] + " " +
                wk[0] + " " +
                wk[1] + " " +
                wk[2] + " " +
                wk[3] + " " +
                wk[4] + " " +
                wk[5] + '\n'
        );

        pw.close();
    }

    public static int monthDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year % 4 == 0 && year != 2100 && year != 1900 && year != 2200) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return - 1;
        }
    }
}
