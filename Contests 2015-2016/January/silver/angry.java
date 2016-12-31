/*
ID: rishide2
LANG: JAVA
TASK: angry
*/
// created by rishi on 12/17/16

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angry {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        
        int[] row = new int[N];
        for (int i = 0; i < N; i++) {
            row[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(row);
        
        int R = 0;
        while (true) { // much slower than binary search method, but still works 10/10 cases
            
            R++;
            
            boolean flag = false;
            
            int
                    start = row[0],
                    reach = start + 2 * R,
                    used = 0;
            
            for (int bale : row) {
                
                if (bale < start || bale > reach) { // bale not in range
                    
                    used++;
                    
                    if (used >= K) { // no point going on if we're out of cows
                        flag = true;
                        break;
                    }
                    start = bale;
                    reach = start + 2 * R;
                }
            }
            
            if (! flag) break;
        }
        
        pw.println(R);
        pw.close();
    }
    
}
