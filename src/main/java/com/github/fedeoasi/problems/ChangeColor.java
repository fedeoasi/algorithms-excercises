package com.github.fedeoasi.problems;

public class ChangeColor {
    private int[][] matrix;

    public ChangeColor(int[][] matrix) {
        this.matrix = matrix;
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void changeColor(int x, int y) {
        changeColor(new Coordinate(x, y));
    }

    public void changeColor(Coordinate c) {
        if(inBounds(c)) {
            conditionalChangeColor(c, colorOf(c));
        }
    }

    private void conditionalChangeColor(Coordinate c, int color) {
        if(inBounds(c) && colorOf(c) == color) {
            switchColor(c);
            conditionalChangeColor(new Coordinate(c.x + 1, c.y), color);
            conditionalChangeColor(new Coordinate(c.x, c.y + 1), color);
            conditionalChangeColor(new Coordinate(c.x - 1, c.y), color);
            conditionalChangeColor(new Coordinate(c.x, c.y - 1), color);
        }
    }

    private int colorOf(Coordinate c) {
        return matrix[c.x][c.y];
    }

    private boolean inBounds(Coordinate c) {
        return matrix.length > 0 && matrix[0].length > 0 &&
                c.x >= 0 && c.x < matrix.length &&
                 c.y >= 0 && c.y < matrix[0].length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private void switchColor(Coordinate c) {
        matrix[c.x][c.y] = switchColor(colorOf(c));
    }

    private int switchColor(int color) {
        return (color + 1) % 2;
    }
}