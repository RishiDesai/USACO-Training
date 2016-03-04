/*
ID: rishide2
LANG: JAVA
TASK: contact
*/
// created by rishi on 2/15/16
package chapter3.sec1;

import java.io.*;
import java.util.*;

public class contact {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("contact.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int
                A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken());

        final String row;

        StringBuilder sb = new StringBuilder(br.readLine());

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        row = sb.toString();

        /* search string */
        Map<String, Integer> pat = new HashMap<String, Integer>();
        for (int i = 0; i < row.length(); i++) {

            sb = new StringBuilder();
            for (int j = i; j <= Math.min(i + B, row.length() - 1); j++) {

                sb.append(row.charAt(j));
                String str = sb.toString();

                if (str.length() >= A && str.length() <= B) {

                    int uses = 1;
                    if (pat.containsKey(str)) {
                        uses += pat.get(str);
                    }

                    pat.put(str, uses);
                }

                if (str.length() > B) break;
            }
        }

        int longest = 0;
        List<Pair> ans = new ArrayList<Pair>();
        for (Map.Entry<String, Integer> e : pat.entrySet()) {     // yes, java can be ugly
            if (e.getValue() > longest) longest = e.getValue();

            ans.add(new Pair(e.getValue(), e.getKey()));
        }

        Collections.sort(ans);

        @SuppressWarnings("unchecked")
        ArrayList<String>[] ret = new ArrayList[longest + 1];

        for (int i = 0; i < ret.length; i++) ret[i] = new ArrayList<String>();

        for (Pair p : ans) {
            ret[p.idx].add(p.str);
        }

        /* printing the answer - the hard part */
        int done = 0;
        for (int i = longest; i >= 0; i--) {
            if (ret[i].size() == 0) continue;

            pw.println(i);

            Collections.sort(ret[i], new Comparator<String>() {

                public int compare(String s1, String s2) {
                    if (s1.length() > s2.length()) return 1;
                    if (s1.length() < s2.length()) return - 1;
                    return Integer.parseInt(s1, 2) - Integer.parseInt(s2, 2);
                }

            });

            pw.print(ret[i].get(0));
            for (int j = 1; j < ret[i].size(); j++) {
                if (j % 6 == 0)
                    pw.print('\n' + ret[i].get(j));
                else
                    pw.print(" " + ret[i].get(j));
            }

            pw.println();

            done++;
            if (done == N) break;
        }

        pw.close();
    }

    private static class Pair implements Comparable<Pair> {    // immutable

        private final int idx;
        private final String str;

        protected Pair(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

        public int compareTo(Pair p) {   // reverse
            return p.idx - idx;
        }

    }
    
}
