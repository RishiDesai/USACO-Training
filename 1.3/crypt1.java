/*
ID: rishide2
LANG: JAVA
TASK: crypt1
*/
// created by rishi on 8/5/15
package chapter1.sec3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class crypt1 {

    private static Integer[] digits;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw = new PrintWriter(new File("crypt1.out"));

        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        digits = new Integer[N];
        for (int i = 0; i < N; i++) digits[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int A : digits) {
            for (int B : digits) {
                for (int C : digits) {
                    for (int D : digits) {
                        for (int E : digits) {

                            int ABC = A * 100 + B * 10 + C;
                            int DE = D * 10 + E;

                            if (isReal(ABC) && isReal(DE) && isReal(E * ABC) &&
                                    isReal(D * ABC) && isReal(ABC * DE) &&
                                    valueOf(E * ABC).length() == 3 &&
                                    valueOf(D * ABC).length() == 3 &&
                                    valueOf(DE * ABC).length() == 4)
                                ans++;

                        }
                    }
                }
            }
        }

        pw.println(ans);
        pw.close();
    }

    private static boolean isReal(int a) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(digits));
        String s = valueOf(a);

        for (int i = 0; i < s.length(); i++)
            if (! nums.contains(s.charAt(i) - '0'))
                return false;

        return true;
    }

}
