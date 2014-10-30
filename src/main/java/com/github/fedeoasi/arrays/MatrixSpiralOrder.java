package com.github.fedeoasi.arrays;

public class MatrixSpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        int h = matrix.length;
        if(h == 0) {
            return new int[0];
        }
        int w = matrix[0].length;
        int resultSize = h * w;
        int[] result = new int[resultSize];

        Position p = new Position(0, 0);
        int offset = 1;
        for(int i = 0; i < resultSize; ) {
            //Center of the matrix
            if(i == resultSize - 1) {
                result[i++] = get(matrix, p);
            }
            while (p.y < w - offset) {
                result[i++] = get(matrix, p);
                p.right();
            }
            while (p.x < w - offset) {
                result[i++] = get(matrix, p);
                p.down();
            }
            while (p.y > offset - 1) {
                result[i++] = get(matrix, p);
                p.left();
            }
            while (p.x > offset - 1) {
                result[i++] = get(matrix, p);
                p.up();
            }
            p.down();
            p.right();
            offset += 1;
        }
        return result;
    }

    public static int get(int[][] matrix, Position p) {
        return matrix[p.x][p.y];
    }

    private static class Position {
        int x;
        int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        public void right() { y += 1; }

        public void down() { x += 1; }

        public void left() { y -= 1; }

        public void up() { x -= 1; }
    }
}
