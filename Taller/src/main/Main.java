package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;

public class Main {

    static ArrayList <Taller> talleres = new ArrayList<Taller>();
    static ArrayList <Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    static ArrayList<Elevador> elevadores = new ArrayList<Elevador>();
    static ArrayList <Compresor> compresores = new ArrayList<Compresor>();
    static ArrayList <PuertaPersonal> puertasPersonales = new ArrayList<PuertaPersonal>();
    static ArrayList <AccesoVehiculos> accesosVehiculos = new ArrayList<AccesoVehiculos>();

    public static void main(String[] args) {

        DBManager.loadDriver();
        DBManager.connect();

        boolean salir = false;
        do {
            salir = menu();
        } while (!salir);

        DBManager.close();
    }
    public static boolean menu(){
        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Registrar Taller de Coches");
        System.out.println("2. Registrar Taller de Motos");
        System.out.println("3. Crear Coche");
        System.out.println("4. Crear Moto");
        System.out.println("5. Crear Elevador");
        System.out.println("6. Crear Compresor");
        System.out.println("7. Crear Puerta Personal");
        System.out.println("8. Crear Acceso Vehiculos");
        System.out.println("9. Añadir Coche a Taller");
        System.out.println("10. Añadir Moto a Taller");
        System.out.println("11. Mostrar Coches en Taller");
        System.out.println("12. Mostrar Motos en Taller");
        System.out.println("13. Retirar Coche de Taller");
        System.out.println("14. Retirar Moto de Taller");
        System.out.println("15. Añadir Compresor a Taller");
        System.out.println("16. Añadir Elevador a Taller");
        System.out.println("17. Subir Elevador");
        System.out.println("18. Bajar Elevador");
        System.out.println("19. Añadir Coche a Elevador");
        System.out.println("20. Añadir Moto a Elevador");
        System.out.println("21. Imprimir Vehiculo en Elevador");
        System.out.println("22. Abrir Puerta");
        System.out.println("23. Cerrar Puerta");
        System.out.println("24. Imprimir Numero de Talleres");
        System.out.println("25. Salir");

        Scanner in = new Scanner(System.in);

        int opcion = pideNumero("Elige una opción: ");

        switch (opcion) {
            case 1:
                talleres.add(crearTallerCoches());
                return false;
            case 2:
                talleres.add(crearTallerMotos());
                return false;
            case 3:
                vehiculos.add(crearCoche());
                return false;
            case 4:
                vehiculos.add(crearMoto());
                return false;
            case 5:
                elevadores.add(crearElevador());
                return false;
            case 6:
                compresores.add(crearCompresor());
                return false;
            case 7:
                puertasPersonales.add(crearPuertaPersonal());
                return false;
            case 8:
                accesosVehiculos.add(crearAccesoVehiculos());
                return false;
            case 9:
                String nombreTallerCoches = pideString("Introduce el nombre del taller: ");
                String matriculaCoche = pideString("Introduce la matrícula del coche: ");
                TallerCoches taller = (TallerCoches)buscarTallerPorNombre(nombreTallerCoches);
                Coche coche = (Coche)buscarCochePorMatricula(matriculaCoche);
                if (taller != null) {
                    añadirCocheTaller(taller, coche);
                    vehiculos.remove(coche);
                    System.out.println("Coche añadido al taller " + nombreTallerCoches);
                    return false;
                } else {
                    System.out.println("No se encontró ningún taller con el nombre " + nombreTallerCoches);
                }

            case 10:
                String nombreTallerMotos = pideString("Introduce el nombre del taller: ");
                String matriculaMoto = pideString("Introduce la matrícula de la moto: ");
                TallerMotos tallerMotos = (TallerMotos)buscarTallerPorNombre(nombreTallerMotos);
                Moto moto = (Moto)buscarMotoPorMatricula(matriculaMoto);
                if (tallerMotos != null) {
                    añadirMotoTaller(tallerMotos, moto);
                    vehiculos.remove(moto);
                    System.out.println("Moto añadida al taller " + nombreTallerMotos);
                    return false;
                } else {
                    System.out.println("No se encontró ningún taller con el nombre " + nombreTallerMotos);
                }
            /*case 13:
                tallerCoches = seleccionarTallerCoches();
                coche = seleccionarCoche();
                retirarCoche(tallerCoches, coche);
                return false;
            case 14:
                tallerMotos = seleccionarTallerMotos();
                moto = seleccionarMoto();
                retirarMoto(tallerMotos, moto);
                return false;
            case 15:
                tallerCoches = seleccionarTallerCoches();
                Compresor compresor = seleccionarCompresor();
                añadirCompresor(tallerCoches, compresor);
                return false;
            case 16:
                tallerCoches = seleccionarTallerCoches();
                Elevador elevador = seleccionarElevador();
                añadirElevador(tallerCoches, elevador);
                return false;
            case 19:
                elevador = seleccionarElevador();
                coche = seleccionarCoche();
                añadirCocheElevador(elevador, coche);
                return false;
            case 20:
                elevador = seleccionarElevador();
                moto = seleccionarMoto();
                añadirMotoElevador(elevador, moto);
                return false;
            case 22:
                Acceso acceso = seleccionarAcceso();
                abrirPuerta(acceso);
                return false;
            case 23:
                acceso = seleccionarAcceso();
                cerrarPuerta(acceso);
                return false;*/

            case 24:
                imprimirNumeroTalleres();
                return false;
            case 25:
                return true;
            default:
                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                return false;
        }
    }

    public static int pideNumero(String mensaje){

        while(true) {
            try {
                System.out.print(mensaje);
                Scanner in = new Scanner(System.in);
                int valor = in.nextInt();
                //in.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("No has introducido un número entero. Vuelve a intentarlo.");
            }
        }
    }

    public static String pideString(String mensaje){
        System.out.print(mensaje);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static boolean pideBoolean(String mensaje){
        System.out.print(mensaje);
        Scanner in = new Scanner(System.in);
        return in.nextBoolean();
    }

    public static TallerCoches crearTallerCoches(){
        String licencia = pideString("Introduce la licencia del taller: ");
        String nombre = pideString("Introduce el nombre del taller: ");
        String tipo = pideString("Introduce el tipo de taller: ");
        int plazas = pideNumero("Introduce el número de plazas: ");
        int elevadores = pideNumero("Introduce el número de elevadores: ");
        int compresores = pideNumero("Introduce el número de compresores: ");
        return new TallerCoches(licencia, nombre, tipo, plazas, elevadores, compresores);
    }

    public static TallerMotos crearTallerMotos(){
        String licencia = pideString("Introduce la licencia del taller: ");
        String nombre = pideString("Introduce el nombre del taller: ");
        String tipo = pideString("Introduce el tipo de taller: ");
        int plazas = pideNumero("Introduce el número de plazas: ");
        int elevadores = pideNumero("Introduce el número de elevadores: ");
        int compresores = pideNumero("Introduce el número de compresores: ");
        return new TallerMotos(licencia, nombre, tipo, plazas, elevadores, compresores);
    }

    public static void imprimirTaller(TallerCoches taller){
        System.out.println(taller.toString());
    }

    public static void imprimirPlazas(Taller taller){
        System.out.println("Plazas totales: " + taller.getPlazas());
        System.out.println("Plazas usadas: " + taller.getPlazasUsadas());
    }

    public static Coche crearCoche(){
        String matricula = pideString("Introduce la matrícula del coche: ");
        String marca = pideString("Introduce la marca del coche: ");
        String modelo = pideString("Introduce el modelo del coche: ");
        int peso = pideNumero("Introduce el peso del coche: ");
        int numPuertas = pideNumero("Introduce el número de puertas del coche: ");
        int numPlazas = pideNumero("Introduce el número de plazas del coche: ");
        return new Coche(matricula, marca, modelo, peso, numPuertas, numPlazas);
    }

    public static Moto crearMoto(){
        String matricula = pideString("Introduce la matrícula de la moto: ");
        String marca = pideString("Introduce la marca de la moto: ");
        String modelo = pideString("Introduce el modelo de la moto: ");
        int peso = pideNumero("Introduce el peso de la moto: ");
        int cilindrada = pideNumero("Introduce la cilindrada de la moto: ");
        int potencia = pideNumero("Introduce la potencia de la moto: ");
        return new Moto(matricula, marca, modelo, peso, cilindrada, potencia);
    }

    public static void añadirCocheTaller(TallerCoches taller, Coche coche){
        taller.añadirCoche(coche);
    }

    public static void añadirMotoTaller(TallerMotos taller, Moto moto){
        taller.añadirMoto(moto);
    }

    public static void mostrarCoches(TallerCoches taller){
        taller.mostrarCoches();
    }

    public static void mostrarMotos(TallerMotos taller){
        taller.mostrarMotos();
    }

    public static void retirarCoche(TallerCoches taller, Coche coche){
        taller.retirarCoche(coche);
    }

    public static void retirarMoto(TallerMotos taller, Moto moto){
        taller.retirarMoto(moto);
    }

    public static Elevador crearElevador(){
        int id = pideNumero("Introduce el id del elevador: ");
        int capacidad = pideNumero("Introduce la capacidad del elevador: ");
        boolean arriba = pideBoolean("Está arriba el elevador? ");
        LocalDate fecha = LocalDate.of(pideNumero("Introduce el año de la revisión: "), pideNumero("Introduce el mes de la revisión: "), pideNumero("Introduce el día de la revisión: "));
        return new Elevador(id, capacidad, arriba, fecha);
    }

    public static Compresor crearCompresor(){
        int id = pideNumero("Introduce el id del compresor: ");
        int capacidad = pideNumero("Introduce la capacidad del compresor: ");
        int presion = pideNumero("Introduce la presión del compresor: ");
        int presionMax = pideNumero("Introduce la presión máxima del compresor: ");
        boolean revision = pideBoolean("Está revisado el compresor? ");
        LocalDate fecha = LocalDate.of(pideNumero("Introduce el año de la revisión: "), pideNumero("Introduce el mes de la revisión: "), pideNumero("Introduce el día de la revisión: "));
        return new Compresor(id, capacidad, presion, presionMax, revision, fecha);
    }

    public static void añadirCompresor(Taller taller, Compresor compresor){
        taller.añadirCompresor(compresor);
    }

    public static void revisionCompresor(Compresor compresor){
        if(compresor.revisionPasada()){
            System.out.println("El compresor está revisado");
        } else {
            System.out.println("El compresor no está revisado");
        }
    }

    public static void revisionElevador(Elevador elevador){
        if(elevador.revisionPasada()){
            System.out.println("El elevador está revisado");
        } else {
            System.out.println("El elevador no está revisado");
        }
    }

    public static void añadirElevador(Taller taller, Elevador elevador){
        taller.añadirElevador(elevador);
    }

    public static void subirElevador(Elevador elevador){
        elevador.setArriba(true);
    }

    public static void bajarElevador(Elevador elevador){
        elevador.setArriba(false);
    }

    public static void añadirCocheElevador(Elevador elevador, Coche coche){
        elevador.setMatricula(coche);
    }

    public static void añadirMotoElevador(Elevador elevador, Moto moto){
        elevador.setMatricula(moto);
    }

    public static void imprimirVehiculoElevador(Elevador elevador){
        System.out.println("En el elevador está el vehículo: " + elevador.getMatricula());
    }

    public static PuertaPersonal crearPuertaPersonal(){
        int id = pideNumero("Introduce el id de la puerta personal: ");
        boolean abierta = pideBoolean("Está abierta la puerta personal? ");
        return new PuertaPersonal(true);
    }

    public static AccesoVehiculos crearAccesoVehiculos(){
        int id = pideNumero("Introduce el id de la puerta de vehículos: ");
        boolean abierta = pideBoolean("Está abierta la puerta de vehículos? ");
        return new AccesoVehiculos(true);
    }

    public static void abrirPuerta(Acceso acceso){
        acceso.abrir();
    }

    public static void cerrarPuerta(Acceso acceso){
        acceso.cerrar();
    }

    public static void imprimirNumeroTalleres(){
        System.out.println("El número de talleres registrados es: " + Taller.getNTalleres());
    }

    public static Taller buscarTallerPorNombre(String nombre) {
        for (Taller taller : talleres) {
            if (taller.getNombre().equals(nombre)) {
                return taller;
            }
        }
        return null;
    }

    public static Vehiculo buscarCochePorMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula) && vehiculo instanceof Coche) {
                return vehiculo;
            }
        }
        return null;
    }

    public static Vehiculo buscarMotoPorMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula) && vehiculo instanceof Moto) {
                return vehiculo;
            }
        }
        return null;
    }

}


    //Este es el main que tenia para hacer pruebas en el que me he basado para hacer el menú final

    /*TallerCoches miTaller = new TallerCoches("M123456", "Taller Dani", "Mecánica rápida", 6, 2, 1);
    Coche coche = new Coche("4578JPK", "Seat", "Ibiza", 1100, 5, 5);
    Coche coche2 = new Coche("3254DFX", "Audi", "A3", 1400, 3, 4);

    TallerMotos miTallerMotos = new TallerMotos("L987654", "Bike garage", "Mecánica ráìda", 12, 0, 0);

    miTaller.añadirCoche(coche);
    miTaller.añadirCoche(coche2);

    Compresor miCompresor = new Compresor(12451, 9000, 1000, 1000, false, LocalDate.of(2025, 4, 3));
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

    System.out.println(Taller.getNTalleres());

    DBManager.insertVehiculo(coche);
    DBManager.insertVehiculo(coche2);
    DBManager.printTablaVehiculos();*/
