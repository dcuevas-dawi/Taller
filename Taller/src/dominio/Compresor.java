package dominio;

import java.time.LocalDate;

public class Compresor implements Maquina{

    int numSerie;
    int maxPresion;
    int minPresion;
    int presionActual;
    boolean encendido;
    LocalDate fechaProximaRevision;

    public Compresor(int numSerie, int maxPresion, int minPresion, int presionActual, boolean encendido, LocalDate fechaProximaRevision) {
        this.numSerie = numSerie;
        this.maxPresion = maxPresion;
        this.minPresion = minPresion;
        this.presionActual = presionActual;
        this.encendido = encendido;
        this.fechaProximaRevision = fechaProximaRevision;
    }

    public int getMaxPresion() {
        return maxPresion;
    }

    public void setMaxPresion(int maxPresion) {
        this.maxPresion = maxPresion;
    }

    public int getMinPresion() {
        return minPresion;
    }

    public void setMinPresion(int minPresion) {
        this.minPresion = minPresion;
    }

    public int getPresionActual() {
        return presionActual;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public LocalDate getfechaProximaRevision() {
        return fechaProximaRevision;
    }

    public void setfechaProximaRevision(LocalDate fechaProximaRevision){
        this.fechaProximaRevision = fechaProximaRevision;
    }

    public void encender(){
        if(!encendido){
            encendido = true;
        }
    }

    public void apagar(){
        if(encendido){
            encendido = false;
        }
    }

    public boolean revisionPasada(){
        if (fechaProximaRevision.isBefore(LocalDate.now())){
            return false;
        }
        return true;
    }

}