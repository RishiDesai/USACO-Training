/*
ID: rishide2
LANG: JAVA
TASK: frac1
*/
// created by rishi on 8/23/15
package chapter2.sec1;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class frac1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        final int N = Integer.parseInt(br.readLine());

        Set<Fraction> set = new TreeSet<Fraction>();

        for (int d = 1; d <= N; d++)
            for (int n = 0; n <= d; n++)
                set.add(new Fraction(n, d));


        for (Fraction f : set)
            pw.println(f.n + "/" + f.d);


        pw.close();
    }

    private static class Fraction implements Comparable<Fraction> {

        private final int n, d;
        private final double value;

        protected Fraction(int n, int d) {
            int com = gcd(n, d);

            this.n = n / com;
            this.d = d / com;
            this.value = n / (double) d;
        }

        private static int gcd(int i, int j) {
            return (j == 0) ? i : gcd(j, i % j);
        }

        @Override
        public int compareTo(Fraction f) {
            return Double.compare(value, f.value);
        }

    }

}
