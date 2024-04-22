package dominio;

import java.time.LocalDate;

public interface Maquina {

    public void setfechaProximaRevision(LocalDate fechaProximaRevision);

    public boolean revisionPasada();

}