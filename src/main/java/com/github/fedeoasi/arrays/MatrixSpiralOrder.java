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
        int rightTarget = h - 1;
        int downTarget = h - 1;
        int leftTarget = 0;
        int upTarget = 1;
        for(int i = 0; i < resultSize; ) {
            result[i++] = get(matrix, p);

            p.right();
            while (p.y <= rightTarget) {
                result[i++] = get(matrix, p);
                p.right();
            }
            p.left();
            rightTarget -= 1;

            p.down();
            while (p.x <= downTarget) {
                result[i++] = get(matrix, p);
                p.down();
            }
            p.up();
            downTarget -= 1;

            p.left();
            while (p.y >= leftTarget) {
                result[i++] = get(matrix, p);
                p.left();
            }
            p.right();
            leftTarget += 1;

            p.up();
            while (p.x >= upTarget) {
                result[i++] = get(matrix, p);
                p.up();
            }
            p.down();
            upTarget += 1;
            p.right();
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
