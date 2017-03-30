package com.plucdrol.dailyprogrammer.letitburn.entity;

public class Tile
{
    public char status;
    public final Coordinates coordinates;

    public Tile(char value, int x, int y)    {
        this.status = value;
        this.coordinates = new Coordinates(x, y);
    }

    public int x() {
        return coordinates.x;
    }

    public int y() {
        return coordinates.y;
    }

    public String toString() {
        return String.format("%c (%d,%d)", status, coordinates.x, coordinates.y);
    }
}
