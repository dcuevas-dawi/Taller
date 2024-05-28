package dominio;

public class PuertaPersonal implements Acceso{

    private boolean estaAbierto = false;

    public PuertaPersonal(boolean estaAbierto) {
        this.estaAbierto = estaAbierto;
    }

    @Override
    public void abrir() {
        if (this.estaAbierto) {
            System.out.println("La puerta del personal ya está abierta");
        } else {
            this.infoEstado();
        }
    }

    @Override
    public void cerrar() {
        if (this.estaAbierto) {
            this.infoEstado();
        } else {
            System.out.println("La puerta del personal ya está cerrada");
        }
    }

    @Override
    public void infoEstado() {
        if (this.estaAbierto) {
            System.out.println("La puerta del personal está abierta");
        } else {
            System.out.println("La puerta del personal está cerrada");
        }
    }

}
