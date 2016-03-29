/*
ID: rishide2
LANG: JAVA
TASK: skidesign
*/
// created by rishi on 8/8/15
package chapter1.sec3;

import java.io.*;
import java.util.Arrays;

public class skidesign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

        final int N = Integer.parseInt(br.readLine());

        int[] hills = new int[N];
        for (int i = 0; i < N; i++) hills[i] = Integer.parseInt(br.readLine());

        Arrays.sort(hills);

        int sum = Integer.MAX_VALUE;
        for (int min = 0; min <= 100; min++) {

            int tempSum = 0;
            for (int i = 0; i < N; i++) {

                int diff = hills[i] - min;
                if (diff > 17) {
                    diff -= 17;
                    tempSum += diff * diff;
                } else if (diff < 0) {
                    tempSum += diff * diff;
                }

            }

            if (tempSum < sum) sum = tempSum;
        }

        pw.println(sum);
        pw.close();
    }

}
