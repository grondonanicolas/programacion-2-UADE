package org.uade.adt.dynamic;

public class Montecarlo {
    private Coord max_coords;
    private Coord min_coords;
    private CoordSet coords;

    public Montecarlo(double max_x, double max_y, double min_x, double min_y){
        this.max_coords = new Coord(max_x, max_y, null);
        this.min_coords = new Coord(min_x, min_y, null);
        this.coords = new CoordSet();
    }


    public void add(Coord coord){
        if (coord.get_x() < this.max_coords.get_x() && coord.get_y() < this.max_coords.get_y() && coord.get_x() > this.min_coords.get_x() && coord.get_y() > this.min_coords.get_y()){
            System.out.println(coord.get_x() + "..." + coord.get_y());
            this.coords.add(coord.get_x(), coord.get_y());
        }
    }
    public CoordSet obtener_coordenadas(){
        return this.coords;
    }
}
