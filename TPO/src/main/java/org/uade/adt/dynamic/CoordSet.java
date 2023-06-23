package org.uade.adt.dynamic;

import org.uade.adt.definitions.ICoordSet;

import java.util.Random;

public class CoordSet implements ICoordSet {

    private CoordNode first;
    private int count;

    @Override
    public void add(double x, double y) {
        Coord aux = new Coord(x, y);

        if (this.first == null) {
            this.first = new CoordNode(x,y, null);
            this.count++;
            return;
        }
        if (aux.equals(this.first.getCoord())) {
            return;
        }

        CoordNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (aux.equals(candidate.getCoord())) {
                return;
            }
        }
        candidate.setNext(new CoordNode(x,y, null));
        this.count++;
    }

    @Override
    public void remove(double x, double y) {
        Coord aux = new Coord(x, y);

        if (this.first == null || (this.first.getNext() == null && !(aux.equals(this.first.getCoord())))) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (aux.equals(this.first.getCoord())) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if ((aux.equals(this.first.getCoord()))) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        CoordNode backup = this.first;
        CoordNode candidate = this.first.getNext();

        while (candidate != null) {
            if ((aux.equals(candidate.getCoord()))) {
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
        CoordNode candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getCoord();
    }

    public int cardinality() {
        return this.count;
    }

}