package dominio;

import java.util.ArrayList;

public class TallerCoches extends Taller{

    private ArrayList<Coche> vehiculos = new ArrayList<Coche>();

    public TallerCoches(String nombre, String tipo, int plazas, int elevadores, int compresores) {
        super(nombre, tipo, plazas, elevadores, compresores);
    }

    public void añadirCoche(Coche coche){
        if(!estaLLeno()){
            vehiculos.add(coche);
            super.setPlazasUsadas(super.getPlazasUsadas() + 1);
        } else {
            System.out.println("El taller está lleno");
        }
    }

    public void retirarCoche(Coche coche){
        if(vehiculos.contains(coche)){
            vehiculos.remove(coche);
            super.setPlazasUsadas(super.getPlazasUsadas() - 1);
        } else {
            System.out.println("El coche no está en el taller");
        }
    }

    public void mostrarCoches(){
        for(Coche coche : vehiculos){
            System.out.println(coche.getMatricula() + " " + coche.getMarca() + " " + coche.getModelo());
        }
    }

    @Override
    public String toString() {
        return "En el taller " + super.getNombre() + " hay " + super.getPlazasUsadas() + " coches de un total de " + super.getPlazas()
                + ", " + super.getElevadores().size() + " elevadores y " + super.getCompresores().size() + " compresores.";
    }

    public void plazasExtra(){ //Si un elevador está arriba(con un coche cargado o no), se gana una plaza debajo suya.
        for(Elevador elevador : elevadores){
            if(elevador.arriba == true){
                this.setPlazas(getPlazas()+1);
            }
        }
    }

}
