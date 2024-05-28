package dominio;

public class AccesoVehiculos implements Acceso{

    private boolean estaAbierto = false;

    public AccesoVehiculos(boolean estaAbierto) {
        this.estaAbierto = estaAbierto;
    }

    @Override
    public void abrir() {
        if (this.estaAbierto) {
            System.out.println("La puerta de vehiculos ya está abierta");
        } else {
            this.estaAbierto = true;
            this.infoEstado();
        }
    }

    @Override
    public void cerrar() {
        if (this.estaAbierto) {
            this.estaAbierto = false;
            this.infoEstado();
        } else {
            System.out.println("La puerta de vehiculos ya está cerrada");
        }
    }

    @Override
    public void infoEstado() {
        if (this.estaAbierto) {
            System.out.println("La puerta de vehiculos está abierta");
        } else {
            System.out.println("La puerta de vehiculos está cerrada");
        }
    }

}
