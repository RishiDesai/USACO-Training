/*
ID: rishide2
LANG: JAVA
TASK: transform
*/
// Created by Rishi on 7/26/2015.
package chapter1.sec2;

import java.io.*;
import java.util.Arrays;

public class transform {

    public static void main(String[] args) throws IOException {

        /* filling in 2D char arrays */
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new File("transform.out"));

        final int N = Integer.parseInt(br.readLine());

        char[][] original = new char[N][N];
        for (int i = 0; i < original.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < original[i].length; j++) {
                original[i][j] = line.charAt(j);
            }
        }

        char[][] target = new char[N][N];
        for (int i = 0; i < target.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < target[i].length; j++) {
                target[i][j] = line.charAt(j);
            }
        }

        /* deciding transformation */
        if (Arrays.deepEquals(original, rotate(target)))
            pw.println(1);

        else if (Arrays.deepEquals(target, rotate(rotate(original))))
            pw.println(2);

        else if (Arrays.deepEquals(target, rotate(rotate(rotate(original)))))
            pw.println(3);

        else if (Arrays.deepEquals(target, reflect(original)))
            pw.println(4);

        else if (Arrays.deepEquals(target, rotate(reflect(original))) ||
                Arrays.deepEquals(target, rotate(rotate(reflect(original)))) ||
                Arrays.deepEquals(target, rotate(rotate(rotate(reflect(original))))))
            pw.println(5);

        else if (Arrays.deepEquals(target, original))
            pw.println(6);

        else
            pw.println(7);


        pw.close();
    }

    private static void print(char[][] input) {
        for (char[] i : input)
            System.out.println(Arrays.toString(i));
    }

    private static char[][] rotate(char[][] input) {  // 90 degrees
        char[][] output = new char[input.length][input.length];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[i].length; j++)
                output[j][input.length - i - 1] = input[i][j];

        return output;
    }

    private static char[][] reflect(char[][] input) {
        char[][] output = new char[input.length][input.length];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[i].length; j++)
                output[i][j] = input[i][input.length - j - 1];

        return output;
    }

}
