package DataStructures.ModuloD;

public class Parada {
    private final String nombre;

    public Parada(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
