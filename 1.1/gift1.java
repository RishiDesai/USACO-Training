/*
ID: rishide2
LANG:JAVA
TASK: gift1
*/
package chapter1.sec1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gift1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        final int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];
        for (int i = 0; i < N; i++) names[i] = br.readLine();

        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int init = Integer.parseInt(st.nextToken());
            int give = Integer.parseInt(st.nextToken());

            String[] list = new String[give];
            for (int t = 0; t < give; t++) list[t] = br.readLine();

            people[i] = new Person(name, init, list);
        }

        Arrays.sort(people);

        for (Person p : people) {
            for (String s : p.list) {
                int idx = find(people, s);
                people[idx].received += p.each;
            }
        }

        for (String name : names) {
            int idx = find(people, name);
            pw.println(name + " " + people[idx].diff());
        }

        pw.close();
    }

    private static int find(Person[] people, String name) {
        Person p = new Person(name, - 1, new String[0]);    // temp var for search
        return Arrays.binarySearch(people, p);
    }

    private static class Person implements Comparable<Person> {

        private final int init, each;
        private final String name;
        private final String[] list;
        private int received;

        protected Person(String name, int init, String[] list) {
            this.init = init;
            this.name = name;
            this.list = list;
            this.each = (list.length == 0) ? 0 : init / list.length;
            this.received = (each == 0) ? init : init % list.length;
        }

        private int diff() {
            return received - init;
        }

        @Override
        public int compareTo(Person p) {
            return name.compareTo(p.name);
        }

    }

}
