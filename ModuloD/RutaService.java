package DataStructures.ModuloD;

import DataStructures.Linear.DoubleLinkedList;

public class RutaService {

    private final DoubleLinkedList<Parada> ruta = new DoubleLinkedList<>();

    // [1] Agregar al final (Append)
    public void agregarParadaFinal(Parada p) {
        ruta.addLast(p);
    }

    // (opcional) agregar al inicio
    public void agregarParadaInicio(Parada p) {
        ruta.addFirst(p);
    }

    // [3] Cancelar última parada (Delete node)
    public Parada cancelarUltimaParada() {
        if (ruta.isEmpty()) return null;
        return ruta.removeLast();
    }

    // [2] Insertar parada "entre destinos" (Insert)
    // Versión fácil: insertar en una POSICIÓN (entre = en medio)
    public void insertarParadaEn(int index, Parada p) {
        // permite insertar en 0..size (si index==size inserta al final)
        ruta.add(index, p);
    }

    public boolean hayParadas() {
        return !ruta.isEmpty();
    }

    public int totalParadas() {
        return ruta.size();
    }

    public Parada obtenerParada(int index) {
        return ruta.get(index);
    }

    public String mostrarRuta() {
        // si tu DoubleLinkedList no tiene toString, cambia por un recorrido.
        return ruta.toString();
    }
}
