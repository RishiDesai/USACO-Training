/*
ID: rishide2
LANG: JAVA
TASK: div7
*/
// created by rishi on 9/2/16
package January.silver;

import java.io.*;
import java.util.Arrays;

public class div7 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        
        final int N = Integer.parseInt(br.readLine());
        
        int[] id = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            id[i] = Integer.parseInt(br.readLine());
        }
        
        final int L = 7;
        int[] first = new int[L], last = new int[L];
        
        Arrays.fill(first, Integer.MAX_VALUE);
        first[0] = 0;
        
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            
            sum += id[i];
            sum %= L;
            
            first[sum] = Math.min(first[sum], i);
            last[sum] = i;
        }
        
        int ans = 0;
        for (int i = 0; i < L; i++) {
            if (first[i] <= N) {
                ans = Math.max(ans, last[i] - first[i]);
            }
        }
        
        pw.println(ans);
        pw.close();
    }
    
}
