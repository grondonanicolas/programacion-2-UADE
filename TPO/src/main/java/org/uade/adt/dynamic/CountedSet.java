package org.uade.adt.dynamic;

import java.util.Random;

public class CountedSet implements ICountedSet {

    private CountedNode first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new CountedNode(a, 1,null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            this.first.setQty(this.first.getQty()+1);
            return;
        }

        CountedNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                this.first.setQty(this.first.getQty()+1);
                return;
            }
        }
        candidate.setNext(new CountedNode(a, 1, null));
        this.count++;
    }
    public void add(int a, int quantity_to_add) {
        if (this.first == null) {
            this.first = new CountedNode(a, quantity_to_add,null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            this.first.setQty(this.first.getQty()+quantity_to_add);
            return;
        }

        CountedNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                this.first.setQty(this.first.getQty()+quantity_to_add);
                return;
            }
        }
        candidate.setNext(new CountedNode(a, quantity_to_add, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }
        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                if (this.first.getQty() > 0){
                    this.first.setQty(this.first.getQty()-1);
                }
                else {
                    this.first = null;
                    this.count--;
                }

                if (this.first.getQty() == 0){
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getQty() > 0){
                this.first.setQty(this.first.getQty()-1);
            }
            else {
                this.first = this.first.getNext();
                this.count--;
            }

            if (this.first.getQty() == 0){
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        CountedNode backup = this.first;
        CountedNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                if (candidate.getQty() > 0){
                    candidate.setQty(candidate.getQty()-1);
                }
                else {
                    this.count--;
                    return;

                }
                if (candidate.getQty() == 0){
                    this.count--;
                    return;
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }


    public void remove(int a, int quantity_to_remove) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }
        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                if (this.first.getQty() > 0 && this.first.getQty() >= quantity_to_remove){
                    this.first.setQty(this.first.getQty()-quantity_to_remove);
                }
                else {
                    this.first = null;
                    this.count--;
                }

                if (this.first.getQty() == 0){
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getQty() > 0 && this.first.getQty() >= quantity_to_remove){
                this.first.setQty(this.first.getQty()-quantity_to_remove);
            }
            else {
                this.first = this.first.getNext();
                this.count--;
            }

            if (this.first.getQty() == 0){
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        CountedNode backup = this.first;
        CountedNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                if (candidate.getQty() > 0 && candidate.getQty() >= quantity_to_remove){
                    candidate.setQty(candidate.getQty()-1);
                }
                else {
                    this.count--;
                    return;

                }
                if (candidate.getQty() == 0){
                    this.count--;
                    return;
                }
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
    public CountedNode choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        CountedNode candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate;
    }
}