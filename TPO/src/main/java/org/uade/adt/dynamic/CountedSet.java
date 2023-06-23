package org.uade.adt.dynamic;

import org.uade.adt.definitions.ICountedSet;

import java.util.ArrayList;
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

        if (this.first.getNode().getValue() == a) {
            this.first.getNode().setQty(this.first.getNode().getQty()+1);
            return;
        }

        CountedNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getNode().getValue() == a) {
                this.first.getNode().setQty(this.first.getNode().getQty()+1);
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

        if (this.first.getNode().getValue() == a) {
            this.first.getNode().setQty(this.first.getNode().getQty()+quantity_to_add);
            return;
        }

        CountedNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getNode().getValue() == a) {
                this.first.getNode().setQty(this.first.getNode().getQty()+quantity_to_add);
                return;
            }
        }
        candidate.setNext(new CountedNode(a, quantity_to_add, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getNode().getValue() != a)) {
            return;
        }
        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getNode().getValue() == a) {
                if (this.first.getNode().getQty() > 0){
                    this.first.getNode().setQty(this.first.getNode().getQty()-1);
                }
                else {
                    this.first = null;
                    this.count--;
                }

                if (this.first.getNode().getQty() == 0){
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getNode().getValue() == a) {
            if (this.first.getNode().getQty() > 0){
                this.first.getNode().setQty(this.first.getNode().getQty()-1);
            }
            else {
                this.first = this.first.getNext();
                this.count--;
            }

            if (this.first.getNode().getQty() == 0){
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        CountedNode backup = this.first;
        CountedNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getNode().getValue() == a) {
                backup.setNext(candidate.getNext());
                if (candidate.getNode().getQty() > 0){
                    candidate.getNode().setQty(candidate.getNode().getQty()-1);
                }
                else {
                    this.count--;
                    return;

                }
                if (candidate.getNode().getQty() == 0){
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
        if (this.first == null || (this.first.getNext() == null && this.first.getNode().getValue() != a)) {
            return;
        }
        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getNode().getValue() == a) {
                if (this.first.getNode().getQty() > 0 && this.first.getNode().getQty() >= quantity_to_remove){
                    this.first.getNode().setQty(this.first.getNode().getQty()-quantity_to_remove);
                }
                else {
                    this.first = null;
                    this.count--;
                }

                if (this.first.getNode().getQty() == 0){
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getNode().getValue() == a) {
            if (this.first.getNode().getQty() > 0 && this.first.getNode().getQty() >= quantity_to_remove){
                this.first.getNode().setQty(this.first.getNode().getQty()-quantity_to_remove);
            }
            else {
                this.first = this.first.getNext();
                this.count--;
            }

            if (this.first.getNode().getQty() == 0){
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        CountedNode backup = this.first;
        CountedNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getNode().getValue() == a) {
                backup.setNext(candidate.getNext());
                if (candidate.getNode().getQty() > 0 && candidate.getNode().getQty() >= quantity_to_remove){
                    candidate.getNode().setQty(candidate.getNode().getQty()-1);
                }
                else {
                    this.count--;
                    return;

                }
                if (candidate.getNode().getQty() == 0){
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
    public int size(){
       return this.count;
    }
    @Override
    public Counted choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        ArrayList<Counted> aux = new ArrayList<>();
        CountedNode candidate = this.first;
        for (int i = 1; i <= this.count; i++) {
            int valor = candidate.getNode().getValue();
            int cantidad = candidate.getNode().getQty();
            for (int j = 1; j <= cantidad; j++){
                Counted aux_node = new Counted(valor, cantidad);
                aux.add(aux_node);
            }
            candidate = candidate.getNext();
        }
        int randomIndex = (new Random()).nextInt(aux.size());
        Counted returnNode = aux.get(randomIndex);
        return returnNode;
    }
}