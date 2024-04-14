package dominio;

import java.time.LocalDate;

public interface Maquina {

    int numSerie = -1;

    public void setfechaProximaRevision(LocalDate fechaProximaRevision);

    public boolean revisionPasada();

}