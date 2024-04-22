package dominio;

public abstract class Acceso {

    boolean estaAbierto = false;

    public abstract void abrir();

    public abstract void cerrar();

    public abstract void infoEstado();

}
