package org.uade.adt.dynamic;

import java.util.Objects;

public class CoordNode {

    private Coord coord;
    private CoordNode next;

    public CoordNode(Coord coord, CoordNode next) {
        this.coord = coord;
        this.next = next;
    }
    public CoordNode(double x, double y, CoordNode next) {
        this.coord = new Coord(x, y);
        this.next = next;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public CoordNode getNext() {
        return next;
    }

    public void setNext(CoordNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordNode coordNode)) return false;
        return Objects.equals(coord, coordNode.coord) && Objects.equals(getNext(), coordNode.getNext());
    }

}
