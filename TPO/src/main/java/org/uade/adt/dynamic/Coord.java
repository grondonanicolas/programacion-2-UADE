package org.uade.adt.dynamic;

public class Coord {
    private double x;
    private double y;
    private Coord next;

    public Coord(double x, double y, Coord next){
        this.x = x;
        this.y = y;
        this.next = next;
    }

    public double get_x(){
        return this.x;
    }
    public double get_y(){
        return this.y;
    }
    public void set_x(int value) {
        this.x = value;
    }
    public void set_y(int value) {
        this.y = value;
    }

    public Coord getNext() {
        return next;
    }

    public void setNext(Coord next) {
        this.next = next;
    }

}
