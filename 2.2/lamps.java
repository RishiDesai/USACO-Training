/*
ID: rishide2
LANG: JAVA
TASK: lamps
*/
// created by rishi on 10/24/15

//package chapter2.sec2;

import java.io.*;
import java.util.*;

/*
I want to give credit to iklein on github
at https://github.com/lklein/usaco-training/blob/master/usaco/lamps/lamps.java
Thank you.
*/

public class lamps {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        final int N = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());

        List<Integer> on = new ArrayList<Integer>();
        List<Integer> off = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t != - 1) {
            on.add(t);
            t = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        while (t != - 1) {
            off.add(t);
            t = Integer.parseInt(st.nextToken());
        }


        List<String> ans = new ArrayList<String>();
        for (int state = 0; state < 16; state++) {

            int[] a = new int[4];
            int sum = 0;                   // # lights on

            for (int i = 0; i < 4; i++) {
                a[i] = state >> i & 1;     // generate all the possible states
                sum += a[i];               // either 1 or 0
            }

            if (sum % 2 != C % 2 || sum > C) continue;


            int[] lamps = new int[N + 1];
            Arrays.fill(lamps, 1);         // all on

            for (int i = 1; i <= N; i++) {
                lamps[i] += a[0];
                if (i % 2 == 1) lamps[i] += a[1];
                if (i % 2 == 0) lamps[i] += a[2];
                if (i % 3 == 1) lamps[i] += a[3];
                lamps[i] %= 2;
            }

            if (isOk(lamps, on, off))
                ans.add(lampString(lamps));

        }

        if (ans.size() == 0)
            pw.println("IMPOSSIBLE");
        else {
            Collections.sort(ans);

            for (String str : ans) pw.println(str);
        }

        pw.close();
    }

    private static boolean isOk(int[] lamps, List<Integer> on, List<Integer> off) {
        for (int i : on)
            if (lamps[i] != 1) return false;

        for (int i : off)
            if (lamps[i] != 0) return false;

        return true;
    }

    private static String lampString(int[] lamps) {
        StringBuilder sb = new StringBuilder(lamps.length);

        for (int i = 1; i < lamps.length; i++)
            sb.append(lamps[i]);

        return sb.toString();
    }

}
