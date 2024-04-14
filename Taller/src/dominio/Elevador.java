package dominio;

import java.time.LocalDate;

public class Elevador implements Maquina{

    int numSerie;
    int maxPeso;
    boolean arriba;
    LocalDate fechaProximaRevision;
    String matricula;

    public Elevador (int numSerie, int maxPeso, boolean arriba, LocalDate fechaProximaRevision) {
        this.numSerie = numSerie;
        this.maxPeso = maxPeso;
        this.arriba = arriba;
        this.fechaProximaRevision = fechaProximaRevision;
    }

    public Elevador (int numSerie, int maxPeso, boolean arriba, LocalDate fechaProximaRevision, String matricula) {
        this.numSerie = numSerie;
        this.maxPeso = maxPeso;
        this.arriba = arriba;
        this.fechaProximaRevision = fechaProximaRevision;
        this.matricula = matricula;
    }

    public int getMaxPeso() {
        return maxPeso;
    }

    public void setMaxPeso(int maxPeso) {
        this.maxPeso = maxPeso;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public LocalDate getfechaProximaRevision() {
        return fechaProximaRevision;
    }

    public void setfechaProximaRevision(LocalDate fechaProximaRevision){
        this.fechaProximaRevision = fechaProximaRevision;
    }

    public boolean revisionPasada(){
        if (fechaProximaRevision.isBefore(LocalDate.now())){
            return false;
        }
        return true;
    }

    public void setMatricula(Coche coche){

        if (this.getMaxPeso() >= coche.getPeso()){
            
            if(this.matricula == null){
                this.matricula = coche.getMatricula();
            } else {
                System.out.println("El elevador ya está ocupado");
            }

        } else {
            System.out.println("El coche es demasiado pesado para el elevador");
        }

    }

    public void vaciarElevador(){
        this.matricula = null;
    }

    public String getMatricula(){
        if(this.matricula == null){
            return "El elevador está vacío";
        }
        return matricula;
    }

}
