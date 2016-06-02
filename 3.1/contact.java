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

        String ln;
        while ((ln = br.readLine()) != null) {
            sb.append(ln);
        }

        row = sb.toString();
        Map<String, Integer> FtoC = new TreeMap<String, Integer>();
        // FtoC = Frequency maps to Count

        for (int i = 0; i < row.length(); i++) {

            sb = new StringBuilder();

            for (int j = i; j < row.length(); j++) {

                sb.append(row.charAt(j));

                if (sb.length() >= A && sb.length() <= B) {

                    String freq = sb.toString();

                    int count = (FtoC.get(freq) == null) ? 1 : FtoC.get(freq) + 1;
                    // check if freq was counted already, if it was,
                    // then increment the prev. value

                    FtoC.put(freq, count);

                } else if (sb.length() > B) {
                    break;   // too long
                }

            }

        }

        // CtoL = Count maps to List(of frequencies in sorted order)
        Map<Integer, List<String>> CtoL = new TreeMap<Integer, List<String>>();
        // here, I'm switching the key-val mapping, from Str -> Int to Int -> Str
        // this is all so I can print out the answer properly

        for (Map.Entry<String, Integer> entry : FtoC.entrySet()) {

            String freq = entry.getKey();
            int count = entry.getValue();

            if (CtoL.get(count) == null)
                CtoL.put(count, new ArrayList<String>());

            CtoL.get(count).add(freq);
        }

        // now, we have to sort the individual lists by the output rules
        for (Map.Entry<Integer, List<String>> entry : CtoL.entrySet()) {

            List<String> freqs = entry.getValue();

            Collections.sort(freqs, new Comparator<String>() {

                public int compare(String s1, String s2) {

                    if (s1.length() != s2.length()) {
                        return s1.length() - s2.length();
                    }

                    int n1 = Integer.parseInt(s1, 2); // 2 is for parsing base 2
                    int n2 = Integer.parseInt(s2, 2);

                    return n1 - n2;
                }
            });

        }

        List<Integer> keys = new ArrayList<Integer>(CtoL.keySet());

        // go backwards in descending order
        for (int i = keys.size() - 1; i >= keys.size() - N && i >= 0; i--) {
            int count = keys.get(i);
            List<String> freqs = CtoL.get(count);

            pw.println(count);

            String line = "";
            for (int k = 0; k < freqs.size(); k++) {

                if (k % 6 == 0 && k != 0) {   // only 6 frequencies per line
                    pw.println(line.trim());  // trim() gets rid of trailing whitespace
                    line = "";
                }

                line += freqs.get(k) + " ";
            }

            pw.println(line.trim());
        }

        pw.close();
    }

}
