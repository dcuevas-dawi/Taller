package dominio;

public class Coche extends Vehiculo{
    private int puertas;
    private int plazas;

    public Coche(String matricula, String marca, String modelo, int peso, int puertas, int plazas) {
        super(matricula, marca, modelo, peso);
        this.puertas = puertas;
        this.plazas = plazas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
}
