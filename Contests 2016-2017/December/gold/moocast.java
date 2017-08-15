/*
ID: rishide2
LANG: JAVA
TASK: moocast
*/
// created by rishi on 8/14/17
package December.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class moocast {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        final int N = Integer.parseInt(br.readLine());
        
        int[] xs = new int[N], ys = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int weight = (xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j]);
                edges.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(edges);
        
        UnionFind graph = new UnionFind(N);
        
        int lastWeight = -1;
        
        for (Edge e : edges) {
            
            if (graph.find(e.a) != graph.find(e.b)) {
                graph.union(e.a, e.b);
                lastWeight = e.weight;
                if (graph.components == 1) break;
            }
        }
        
        pw.println(lastWeight);
        pw.close();
    }
    
    private static class UnionFind {
        
        int[] parent;
        int components;
        
        UnionFind(int size) {
            components = size;
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
        
        int find(int node) {
            // no memoization is sufficient
            return (parent[node] == node) ? parent[node] : find(parent[node]);
        }
        
        void union(int A, int B) {
            if (parent[find(A)] != find(B)) {
                parent[find(A)] = find(B);
                components--;
            }
        }
        
    }
    
    private static class Edge implements Comparable<Edge> {
        
        final int a, b, weight;
        
        Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
        
    }
    
}
