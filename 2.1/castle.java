/*
ID: rishide2
LANG: JAVA
TASK: castle
*/
// created by rishi on 8/23/15

package chapter2.sec1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class castle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("castle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        decode();
        search();
        findOptimal();

        pw.println(numberOfRooms);
        pw.println(largestRoom);
        pw.println(combinedRoom);
        pw.println(wall);

        pw.close();
    }

    private static int M, N;
    private static int[] sizes;                // idx = room ID, [idx] -> room size
    private static int[][] map;
    private static boolean[][] visited;
    private static Module[][] mods;

    private static int largestRoom, numberOfRooms, combinedRoom;
    private static String wall;

    private static void init() {
        map = new int[N][M];
        visited = new boolean[N][M];
        mods = new Module[N][M];
        sizes = new int[N * M];           // N * M = max amount of rooms
    }

    private static void decode() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mods[i][j] = decrypt(map[i][j]);
            }
        }

    }

    private static Module decrypt(int n) {

        boolean north = false, south = false;
        boolean east = false, west = false;

        if ((n & 1) == 1) west = true;
        if ((n & 2) == 2) north = true;
        if ((n & 4) == 4) east = true;
        if ((n & 8) == 8) south = true;

        return new Module(north, south, west, east);
    }

    private static void search() {

        largestRoom = - 1;
        numberOfRooms = 0;

        int roomID = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (visited[i][j]) continue;

                numberOfRooms++;                   // new room found

                Queue<Point> q = new LinkedList<Point>();
                q.add(new Point(i, j));

                int tempLargest = 0;

                while (! q.isEmpty()) {

                    Point p = q.poll();

                    final int x = p.x, y = p.y;

                    if (visited[x][y]) continue;
                    visited[x][y] = true;

                    Module mod = mods[x][y];
                    mod.ID = roomID;

                    sizes[roomID]++;               // increment current room size

                    tempLargest++;                 // new module in this room

                    // (no wall and not visited)          q.add(node)
                    if (! mod.north && isValid(x - 1, y)) q.add(new Point(x - 1, y));

                    if (! mod.south && isValid(x + 1, y)) q.add(new Point(x + 1, y));

                    if (! mod.west && isValid(x, y - 1)) q.add(new Point(x, y - 1));

                    if (! mod.east && isValid(x, y + 1)) q.add(new Point(x, y + 1));

                }

                roomID++;

                if (tempLargest > largestRoom) largestRoom = tempLargest;
            }

        }

    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M && ! visited[i][j];
    }

    private static void findOptimal() {

        combinedRoom = - 1;

        for (int j = 0; j < M; j++) {                     //  west -> east
            for (int i = N - 1; i >= 0; i--) {            //  south -> north

                int root = mods[i][j].ID;

                if (i > 0) {
                    int up = mods[i - 1][j].ID;

                    if (root != up) {
                        if (sizes[root] + sizes[up] > combinedRoom) {
                            combinedRoom = sizes[root] + sizes[up];
                            wall = (i + 1) + " " + (j + 1) + " " + 'N';
                        }
                    }

                }

                if (j < M - 1) {
                    int rt = mods[i][j + 1].ID;

                    if (root != rt) {
                        if (sizes[root] + sizes[rt] > combinedRoom) {
                            combinedRoom = sizes[root] + sizes[rt];
                            wall = (i + 1) + " " + (j + 1) + " " + 'E';
                        }
                    }

                }

            }
        }

    }

    private static class Module {

        private final boolean north, south, west, east; // if walls are there
        private int ID;                                 // ID of room 'this' is in

        protected Module(boolean N, boolean S, boolean W, boolean E) {
            this.north = N;
            this.south = S;
            this.west = W;
            this.east = E;
        }

    }

    private static class Point {

        private final int x, y;

        protected Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
