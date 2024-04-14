package dominio;

import java.util.ArrayList;

public class TallerMotos extends Taller{

    private ArrayList<Moto> vehiculos = new ArrayList<Moto>();

    public TallerMotos(String nombre, String tipo, int plazas, int elevadores, int compresores) {
        super(nombre, tipo, plazas, elevadores, compresores);
    }

    public void añadirMoto(Moto moto){
        if(!estaLLeno()){
            vehiculos.add(moto);
            super.setPlazasUsadas(super.getPlazasUsadas() + 1);
        } else {
            System.out.println("El taller está lleno");
        }
    }

    public void retirarMoto(Moto moto){
        if(vehiculos.contains(moto)){
            vehiculos.remove(moto);
            super.setPlazasUsadas(super.getPlazasUsadas() - 1);
        } else {
            System.out.println("La moto no está en el taller");
        }
    }

    public void mostrarMotos(){
        for(Moto moto : vehiculos){
            System.out.println(moto.getMatricula() + " " + moto.getMarca() + " " + moto.getModelo());
        }
    }

    @Override
    public String toString() {
        return "En el taller " + super.getNombre() + " hay " + super.getPlazasUsadas() + " motos de un total de " + super.getPlazas()
                + ", " + super.getElevadores().size() + " elevadores y " + super.getCompresores().size() + " compresores.";
    }

}
