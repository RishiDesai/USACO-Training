/*
ID: rishide2
LANG: JAVA
TASK: friday
*/
// Created by Rishi on 7/11/2015.
package chapter1.sec1;

import java.io.*;
import java.util.StringTokenizer;

public class friday {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int year = 1900 + N;
        int[] thirteens = new int[7];
        int dayOfWeek = 6;

        for (int i = 1900; i < year; i++) {
            for (int k = 0; k <= 11; k++) {
                int days = monthDays(i, k);
                thirteens[dayOfWeek]++;
                dayOfWeek += days;
                dayOfWeek %= 7;
            }
        }
        out.print(thirteens[6] + " ");
        out.print(thirteens[0] + " ");
        out.print(thirteens[1] + " ");
        out.print(thirteens[2] + " ");
        out.print(thirteens[3] + " ");
        out.print(thirteens[4] + " ");
        out.print(thirteens[5] + " ");

        System.out.print(thirteens[6] + " ");
        System.out.print(thirteens[0] + " ");
        System.out.print(thirteens[1] + " ");
        System.out.print(thirteens[2] + " ");
        System.out.print(thirteens[3] + " ");
        System.out.print(thirteens[4] + " ");
        System.out.print(thirteens[5] + " ");
    }

    public static int monthDays(int year, int month) {
        switch (month) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (year % 4 == 0 && year != 2100 && year != 1900 && year != 2200) {
                    return 29;
                } else {
                    return 28;
                }
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                return 0;
        }
    }
}
