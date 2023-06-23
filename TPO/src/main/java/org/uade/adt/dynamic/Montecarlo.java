package org.uade.adt.dynamic;

public class Montecarlo {
    private Coord maxCoords;
    private Coord minCoords;
    private CoordSet coords;

    public Montecarlo(double maxX, double maxY, double minX, double minY){
        this.maxCoords = new Coord(maxX, maxY);
        this.minCoords = new Coord(minX, minY);
        this.coords = new CoordSet();
    }


    public void add(Coord coord){
        if (coord.getX() < this.maxCoords.getX() && coord.getY() < this.maxCoords.getY() && coord.getX() > this.minCoords.getX() && coord.getY() > this.minCoords.getY()){
            this.coords.add(coord.getX(), coord.getY());
        }
    }
    public double obtenerPi(){
        double long_coords = this.coords.cardinality();
        double puntos_dentro_del_circulo = 0.0;
        while (!this.coords.isEmpty()) {
            Coord coordenada = this.coords.choose();
            this.coords.remove(coordenada.getX(), coordenada.getY());
            double x = coordenada.getX() * coordenada.getX();
            double y = coordenada.getY() * coordenada.getY();
            double distancia = x + y;
            if (distancia < (maxCoords.getX() * maxCoords.getX())) {
                puntos_dentro_del_circulo++;
            }

        }
        return 4.0 * (puntos_dentro_del_circulo / long_coords);
    }
}
