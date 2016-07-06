/*
ID: rishide2
LANG: JAVA
TASK: highcard
*/
// created by rishi on 4/1/16
package December.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class highcard {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));

        final int N = Integer.parseInt(br.readLine());

        boolean[] elsieHas = new boolean[2 * N + 1];
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());

            elsieHas[c] = true;
        }

        List<Integer>
                bessie = new ArrayList<Integer>(),
                elsie = new ArrayList<Integer>();

        for (int i = 1; i < elsieHas.length; i++) {
            if (elsieHas[i]) {
                elsie.add(i);
            } else {
                bessie.add(i);
            }
        }

        int bIndex = 0, eIndex = 0, points = 0;
        while (bIndex < N && eIndex < N) {
            if (bessie.get(bIndex) > elsie.get(eIndex)) {
                eIndex++;
                bIndex++;
                points++;  // bessie has higher card so she gets a point
            } else {
                bIndex++;
            }
        }

        pw.println(points);
        pw.close();
    }
    
}
