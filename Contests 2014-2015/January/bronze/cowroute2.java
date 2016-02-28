/*
ID: rishide2
LANG: JAVA
TASK: cowroute2
*/
// created by rishi on 2/20/16
package January.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class cowroute2 {

    private static int A, B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        List<Route> routes = new ArrayList<Route>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int[] places = new int[num];
            st = new StringTokenizer(br.readLine());

            boolean hasA = false, hasB = false;
            for (int j = 0; j < num; j++) {
                int loc = Integer.parseInt(st.nextToken());
                places[j] = loc;

                if (loc == A) hasA = true;
                if (loc == B) hasB = true;
            }

            if (hasA || hasB) {
                routes.add(new Route(cost, places, hasA, hasB));
            }

        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < routes.size(); i++) {
            Route a = routes.get(i);
            if (! a.hasA) continue;

            for (int j = 0; j < routes.size(); j++) {
                Route b = routes.get(j);
                if (! b.hasB) continue;

                if (i != j && areLinked(a, b)) {
                    if (a.cost + b.cost < ans) ans = a.cost + b.cost;

                } else if (i == j) {            // make sure A comes before B

                    boolean seenA = false;
                    for (int k = 0; k < a.places.length; k++) {
                        if (a.places[k] == A) seenA = true;
                        if (a.places[k] == B && ! seenA) break;
                        if (a.places[k] == B && seenA) {
                            if (a.cost < ans) ans = a.cost;
                        }
                    }

                }

            }
        }

        if (ans != Integer.MAX_VALUE)
            pw.println(ans);
        else
            pw.println(- 1);
        
        pw.close();
    }

    private static boolean areLinked(Route a, Route b) {
        int idxA = - 1;
        for (int i = 0; i < a.places.length; i++) {
            if (a.places[i] == A) {
                idxA = i;
                break;
            }
        }

        int idxB = - 1;
        for (int i = 0; i < b.places.length; i++) {
            if (b.places[i] == B) {
                idxB = i;
                break;
            }
        }

        for (int i = idxA + 1; i < a.places.length; i++) {
            for (int j = 0; j < idxB; j++) {
                if (a.places[i] == b.places[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class Route {

        private final int cost;
        private final int[] places;
        private final boolean hasA, hasB;

        protected Route(int cost, int[] places, boolean hasA, boolean hasB) {
            this.cost = cost;
            this.places = places;
            this.hasA = hasA;
            this.hasB = hasB;
        }

    }
    
}
