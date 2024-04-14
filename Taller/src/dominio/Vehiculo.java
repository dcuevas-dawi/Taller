package dominio;

public abstract class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private int peso;

    public Vehiculo(String matricula, String marca, String modelo, int peso) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
