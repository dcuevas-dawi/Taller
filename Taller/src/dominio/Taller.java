package dominio;

import java.util.ArrayList;

public abstract class Taller {

    private final String LICENCIA_MUNICIPAL;
    private String nombre;
    private String tipo;
    private int plazas; //Plazas máximas
    private int plazasUsadas;
    private static int nTalleres = 0;
    protected ArrayList<Elevador> elevadores = new ArrayList<Elevador>();
    private ArrayList<Compresor> compresores = new ArrayList<Compresor>();
    private ArrayList<Acceso> accesos = new ArrayList<Acceso>();

    public Taller(String licencia){
        this.LICENCIA_MUNICIPAL = licencia;
    }

    public Taller(String licencia ,String nombre, String tipo, int plazas, int elevadores, int compresores) {
        this.LICENCIA_MUNICIPAL = licencia;
        this.nombre = nombre;
        this.tipo = tipo;
        this.plazas = plazas;
        this.plazasUsadas = 0;
        Taller.nTalleres++;
    }

    public String getLicencia(){
        return this.LICENCIA_MUNICIPAL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPlazasUsadas() {
        return plazasUsadas;
    }

    public void setPlazasUsadas(int plazasUsadas) {
        this.plazasUsadas = plazasUsadas;
    }

    public  ArrayList<Elevador> getElevadores() {
        return elevadores;
    }

    public void añadirElevador(Elevador elevador) {
        elevadores.add(elevador);
    }

    public ArrayList<Compresor> getCompresores() {
        return compresores;
    }

    public void añadirCompresor(Compresor compresor) {
        compresores.add(compresor);
    }

    public boolean estaLLeno(){
        return this.getPlazasUsadas() == this.getPlazas();
    }

    public void añadirAcceso(Acceso acceso){
        accesos.add(acceso);
    }

    public void abrirAcceso(int a){
        accesos.get(a).abrir();
    }

    public void cerrarAcceso(int a){
        accesos.get(a).cerrar();
    }

    public static int getNTalleres(){
        return Taller.nTalleres;
    }

}
