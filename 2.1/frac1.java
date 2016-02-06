/*
ID: rishide2
LANG: JAVA
TASK: frac1
*/
// created by rishi on 8/23/15
package chapter2.sec1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class frac1 {

    private static ArrayList<Fraction> fractions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        final int N = Integer.parseInt(br.readLine());

        fractions = new ArrayList<Fraction>();

        for (int i = 1; i <= N; i++) generate(i);

        fractions.add(new Fraction(0, 1));
        fractions.add(new Fraction(1, 1));

        Collections.sort(fractions);

        for (Fraction f : fractions)
            pw.println(f);

        pw.close();
    }

    private static void generate(int num) {

        for (int i = 1; i < num; i++) {
            Fraction frac = new Fraction(i, num);

            if (simplifiable(frac))
                simplify(frac);

            if (! fractions.contains(frac))
                fractions.add(frac);

        }

    }

    private static boolean simplifiable(Fraction f) {
        return gcd(f.numer, f.denom) != 1;
    }

    private static void simplify(Fraction f) {
        int n = f.numer;
        int d = f.denom;
        f.denom /= gcd(n, d);
        f.numer /= gcd(n, d);
    }

    private static int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }

    private static class Fraction implements Comparable<Fraction> {

        private int numer, denom;
        private final double value;

        protected Fraction(int numer, int denom) {
            this.numer = numer;
            this.denom = denom;
            this.value = (double) numer / (double) denom;
        }

        @Override
        public int compareTo(Fraction f) {
            if (value > f.value) return 1;
            if (value < f.value) return - 1;
            return 0;
        }

        @Override
        public String toString() {
            return this.numer + "/" + this.denom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Fraction)) return false;

            Fraction fraction = (Fraction) o;

            return numer == fraction.numer &&
                    denom == fraction.denom &&
                    Double.compare(fraction.value, value) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = numer;
            result = 31 * result + denom;
            temp = Double.doubleToLongBits(value);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

    }

}
