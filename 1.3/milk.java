/*
ID: rishide2
LANG: JAVA
TASK: milk
*/
// created by rishi on 8/4/15
package chapter1.sec3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Farmer[] fs = new Farmer[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            fs[i] = new Farmer(price, amount);
        }

        Arrays.sort(fs);

        int milk = 0, cost = 0;
        for (Farmer f : fs) {
            if (milk + f.max <= N) {
                milk += f.max;
                cost += f.price * f.max;
            } else {
                int diff = N - milk;
                cost += f.price * diff;
                break;
            }
        }

        pw.println(cost);
        pw.close();
    }

    private static class Farmer implements Comparable<Farmer> { // immutable

        protected final int price, max;

        protected Farmer(int price, int max) {
            this.price = price;
            this.max = max;
        }

        @Override
        public int compareTo(Farmer f) {
            if (price > f.price) return 1;
            if (price < f.price) return - 1;
            return 0;
        }

    }

}
