/*
ID: rishide2
LANG:JAVA
TASK: gift1
*/
package chapter1.sec1;

import java.io.*;
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

        for (Person giver : people) {
            for (String name : giver.list) {
                int i;
                for (i = 0; i < people.length; i++)
                    if (people[i].name.equals(name)) break;

                people[i].recieved += giver.each;
            }

        }

        for (String name : names) {
            int ind;
            for (ind = 0; ind < people.length; ind++)
                if (name.equals(people[ind].name)) {
                    people[ind].setDiff();
                    break;
                }

            pw.println(people[ind].name + " " + people[ind].diff);
        }

        pw.close();
    }

    private static class Person {

        protected final int init, each;
        protected int recieved, diff;
        protected final String name;
        protected final String[] list;

        protected Person(String name, int init, String[] list) {
            this.init = init;
            this.name = name;
            this.list = list;
            this.each = (list.length == 0) ? 0 : init / list.length;
            this.recieved = (each == 0) ? init : init % list.length;
        }

        protected void setDiff() {
            this.diff = recieved - init;
        }

        @Override
        public String toString() {
            return "[" + name + ": " + init +
                    " : " + recieved + " ]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Person)) return false;

            Person person = (Person) o;

            return init == person.init && each == person.each && name.equals(person.name);

        }

        @Override
        public int hashCode() {
            int result = init;
            result = 31 * result + each;
            result = 31 * result + name.hashCode();
            return result;
        }

    }

}
