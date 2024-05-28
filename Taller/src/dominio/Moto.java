package dominio;

public class Moto extends Vehiculo{

    private int cilindrada;
    private int potencia;

    public Moto(String matricula, String marca, String modelo, int peso, int cilindrada, int potencia) {
        super(matricula, marca, modelo, peso);
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

}
