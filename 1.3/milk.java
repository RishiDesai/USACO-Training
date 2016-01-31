/*
ID: rishide2
LANG: JAVA
TASK: milk
*/
// created by rishi on 8/4/15
package chapter1.sec3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new File("milk.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int milkNeeded = Integer.parseInt(st.nextToken()); // amount company needs
        final int clients = Integer.parseInt(st.nextToken()); // amount of farmers needed

        Farmer[] farmers = new Farmer[clients];

        String line;
        int j = 0;
        while ((line = br.readLine()) != null) {
            int price = Integer.parseInt(line.split(" ")[0]);
            int max = Integer.parseInt(line.split(" ")[1]);
            farmers[j] = new Farmer(price, max);
            j++;
        }

        Arrays.sort(farmers, new Comparator<Farmer>() {
            @Override
            public int compare(Farmer o1, Farmer o2) {
                if (o1.price > o2.price)
                    return 1;
                else if (o1.price < o2.price)
                    return - 1;
                else
                    return 0;
            }
        });

        int milk = 0;
        int paid = 0;

        for (Farmer farmer : farmers) {
            if (milk < milkNeeded) {
                if (farmer.getMax() + milk >= milkNeeded) {
                    int difference = milkNeeded - milk;
                    milk += difference;
                    paid += difference * farmer.getPrice();
                    break;
                } else {
                    milk += farmer.getMax();
                    paid += farmer.getMax() * farmer.getPrice();

                }
            } else {
                break;
            }
        }

        pw.println(paid);
        System.out.println(paid);

        pw.close();
        System.exit(0);
    }

    private static class Farmer {

        private final int price;
        private int max;

        public Farmer(int price, int max) {
            this.price = price;
            this.max = max;

        }

        public String toString() {
            return "[" + price + " " + max + "]";
        }

        public int getPrice() {
            return this.price;
        }

        public int getMax() {
            return this.max;
        }

    }

    private static void print(Object[] array) {
        for (Object o : array) {
            System.out.println(o);
        }
        System.out.println();
    }

}