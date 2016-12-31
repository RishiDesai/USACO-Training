/*
ID: rishide2
LANG: JAVA
TASK: moocast
*/
// created by rishi on 12/18/16
package December.silver;

import java.io.*;
import java.util.*;

public class moocast {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        final int N = Integer.parseInt(br.readLine());
        
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            cows[i] = new Cow(x, y, p, i);
        }
        
        for (int i = 0; i < N; i++) {
            Cow A = cows[i];
            
            for (int j = 0; j < N; j++) {
                Cow B = cows[j];
                
                if (i != j && canReach(A, B)) {
                    A.reach.add(B);
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) { // bfs
            
            boolean[] visited = new boolean[N];
            
            Queue<Cow> q = new LinkedList<Cow>();
            q.add(cows[i]);
            
            int reach = 0;
            
            while (! q.isEmpty()) {
                
                Cow a = q.poll();
                
                reach++;
                visited[a.ID] = true;
                
                for (Cow c : a.reach) {
                    if (! visited[c.ID]) {
                        q.add(c);
                        visited[c.ID] = true;
                    }
                }
            }
            
            ans = Math.max(ans, reach);
        }
        
        pw.println(ans);
        pw.close();
    }
    
    private static boolean canReach(Cow a, Cow b) {
        
        double dist = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        
        return (((double) a.power) >= dist);
    }
    
    private static final class Cow {
        
        final int x, y, power, ID;
        List<Cow> reach;
        
        Cow(int x, int y, int power, int ID) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.ID = ID;
            reach = new ArrayList<Cow>();
        }
        
    }
    
}

