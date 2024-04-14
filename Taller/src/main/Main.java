package main;

import java.time.LocalDate;

import dominio.*;

public class Main {
    public static void main(String[] args){
        TallerCoches miTaller = new TallerCoches("Taller Dani", "Mecánica rápida", 6, 2, 1);
        Coche coche = new Coche("4578JPK", "Seat", "Ibiza",1100);
        Coche coche2 = new Coche("3254DFX", "Audi", "A3",1400);
        
        miTaller.añadirCoche(coche);
        miTaller.añadirCoche(coche2);

        Compresor miCompresor = new Compresor(12451,9000,1000,1000,false, LocalDate.of(2025,4,3));
        Elevador miElevador = new Elevador(99652, 2000, false, LocalDate.of(2023, 1, 2));
        
        miTaller.añadirCompresor(miCompresor);
        miTaller.añadirElevador(miElevador);
        miElevador.setArriba(true);

        System.out.println(miTaller.getPlazas());
        miElevador.setMatricula(coche); // Vamos a ganar una plaza extra debajo de este elevador
                                        // subiendo en él el Ibiza
        System.out.println("En el elevador está el coche: " + miElevador.getMatricula());
        miTaller.plazasExtra(); 
        System.out.println(miTaller.getPlazas());

        System.out.println("El compresor tiene la revisión pasada? " + miCompresor.revisionPasada());
        System.out.println("El elevador tiene la revisión pasada? " + miElevador.revisionPasada()); 

        System.out.println(miTaller);
        miTaller.mostrarCoches();    
        
        Acceso puertaPersonal = new PuertaPersonal();
        Acceso AccesoVehiculos = new AccesoVehiculos();
        miTaller.añadirAcceso(puertaPersonal);
        miTaller.añadirAcceso(AccesoVehiculos);
        miTaller.abrirAcceso(0);
        miTaller.abrirAcceso(1);

    }
}
