package com.github.fedeoasi.problems;

public class IslandMatrix {
    int height;
    int width;

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public IslandMatrix(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public float probabilityOfAlive(int x, int y, int steps) {
        return probabilityOfAlive(new Coordinate(x, y), steps);
    }

    public float probabilityOfAlive(Coordinate c, int steps) {
        if (steps == 0) {
            return isAlive(c) ? 1.0f : 0.0f;
        }
        float p = 0;
        Coordinate up = up(c);
        if(isAlive(up)) {
            p += probabilityOfAlive(up, steps - 1);
        }
        Coordinate down = down(c);
        if(isAlive(down)) {
            p += probabilityOfAlive(down, steps - 1);
        }
        Coordinate left = left(c);
        if(isAlive(left)) {
            p += probabilityOfAlive(left, steps - 1);
        }
        Coordinate right = right(c);
        if(isAlive(right)) {
            p += probabilityOfAlive(right, steps - 1);
        }
        return p / 4;
    }

    public Coordinate up(Coordinate c) {
        return new Coordinate(c.x - 1, c.y);
    }

    public Coordinate down(Coordinate c) {
        return new Coordinate(c.x + 1, c.y);
    }

    public Coordinate left(Coordinate c) {
        return new Coordinate(c.x, c.y - 1);
    }

    public Coordinate right(Coordinate c) {
        return new Coordinate(c.x, c.y + 1);
    }

    public boolean isAlive(Coordinate c) {
        return c.x >= 0 && c.x < height && c.y >= 0 && c.y < width;
    }
}
