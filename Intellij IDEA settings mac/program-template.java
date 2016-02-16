/*
ID: rishide2
LANG: JAVA
TASK: program
*/
// created by rishi on 2/15/16

import java.io.*;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class program {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("program.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("program.out")));


        pw.close();
    }
    
    private static boolean isValid(int i, int j) { // change
        return i >= 0 && i < 0 && j >= 0 && j < 0;
    }

    private static class Point {
        
        protected final int x, y;
        
        protected Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Point)) return false;

            Point point = (Point) o;

            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }
    
    private static final int[] dx = {- 1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, - 1};
    private static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

}
