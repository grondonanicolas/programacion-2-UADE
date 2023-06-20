package org.uade.adt.dynamic;

import org.uade.adt.dynamic.ICoordSet;

import java.util.Random;

public class CoordSet implements ICoordSet {

    private Coord first;
    private int count;

    @Override
    public void add(double x, double y) {
        if (this.first == null) {
            this.first = new Coord(x,y, null);
            this.count++;
            return;
        }

        if (this.first.get_x() == x && this.first.get_y() == y) {
            return;
        }

        Coord candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.get_x() == x && candidate.get_y() == y) {
                return;
            }
        }
        candidate.setNext(new Coord(x,y, null));
        this.count++;
    }

    @Override
    public void remove(double x, double y) {
        if (this.first == null || (this.first.getNext() == null && this.first.get_x() != x && this.first.get_y() != y)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.get_x() == x && this.first.get_y() == y) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.get_x() == x && this.first.get_y() == y) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Coord backup = this.first;
        Coord candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.get_x() == x && candidate.get_y() == y) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Coord choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Coord candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate;
    }

    public int cardinality() {
//        CoordSet aux = new CoordSet();
//        int count = 0;
//        while (!this.isEmpty()) {
//            Coord element = this.choose();
//            aux.add(element.get_x(), element.get_y());
//            this.remove(element.get_x(), element.get_y());
//            count++;
//        }
//        while (!aux.isEmpty()){
//            Coord element = aux.choose();
//            this.add(element.get_x(), element.get_y());
//            aux.remove(element.get_x(), element.get_y());
//        }
//        return count;
        return this.count;
    }

}