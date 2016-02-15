/*
ID: rishide2
LANG: JAVA
TASK: fracdec
*/
// created by rishi on 1/17/16
package chapter2.sec4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class fracdec {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fracdec.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String ans = solve(N, K);

        final int L = 76;
        while (ans.length() > L) {
            pw.println(ans.substring(0, L));
            ans = ans.substring(L);
        }

        pw.println(ans);
        pw.close();
    }

    private static String solve(int num, int denom) {
        int com = gcd(num, denom);

        num /= com;
        denom /= com;

        int intPart = num / denom;
        num -= (denom * intPart);

        if (num == 0) {
            return String.format("%d.0", intPart);
        }

        Map<Integer, Integer> remain = new HashMap<Integer, Integer>();
        StringBuilder sbFrac = new StringBuilder();
        String fracPart;

        int idx = 0;
        while (true) {
            remain.put(num, idx++);

            num *= 10;
            sbFrac.append(num / denom);

            num %= denom;

            if (remain.containsKey(num)) {
                fracPart = sbFrac.toString();
                int d = remain.get(num);

                String str = num > 0 ? "(" + fracPart.substring(d) + ")" : "";
                fracPart = fracPart.substring(0, d);
                fracPart += str;
                break;
            }
        }

        return String.valueOf(intPart) + "." + fracPart;
    }

    private static int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }

}
