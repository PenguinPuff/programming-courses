package de.tum.cit.ase;

// TODO 1.1 Point class should be using generic data types for its attributes
public class Point<T> {
    private final T x;
    private final T y;
    // TODO 1.2 Add constructor
    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x
    public T getX() {
        return x;
    }

    // Getter for y
    public T getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

