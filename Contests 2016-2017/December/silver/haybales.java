/*
ID: rishide2
LANG: JAVA
TASK: haybales
*/
// created by rishi on 12/18/16
package December.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());
        
        int[] row = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            row[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(row);
        // Arrays.binarySearch returns (-(insertion point) - 1) if element not in array
        // Situation where knowing the Java Class Library well is useful
        
        for (int i = 0; i < Q; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if (B < row[0] || A > row[row.length - 1]) { // ans will always be 0 here
                pw.println(0);
                continue;
            }
            
            A = Math.max(A, row[0]);            // to narrow down indexes
            B = Math.min(B, row[row.length - 1]);
            
            int x = Arrays.binarySearch(row, A);
            
            if (x < 0) {
                
                x = Math.abs(x) - 1;
                
                if (x == row.length) x--; // if index is n, where array length is n
                
                if (A > row[x]) x++;
                
            }
            
            int y = Arrays.binarySearch(row, B);
            
            if (y < 0) {
                
                y = Math.abs(y) - 1;
                
                if (B < row[y]) y--;
            }
            
            pw.println(y - x + 1);
        }
        
        pw.close();
    }
    
}
