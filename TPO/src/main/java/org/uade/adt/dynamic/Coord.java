package org.uade.adt.dynamic;

import java.util.Objects;

public class Coord {
    private double x;
    private double y;

    public Coord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(int value) {
        this.x = value;
    }
    public void setY(int value) {
        this.y = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord coord)) return false;
        return Double.compare(coord.getX(), x) == 0 && Double.compare(coord.getY(), y) == 0;
    }
}
