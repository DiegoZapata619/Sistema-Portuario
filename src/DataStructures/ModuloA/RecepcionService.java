package DataStructures.ModuloA;

import DataStructures.Linear.CustomQueue;

public class RecepcionService {
    private final CustomQueue<Camion> cola= new CustomQueue<>();

    //Usando la operación de cola definida en las estructuras, se registra el camión
    public void registrarLlegada (Camion camion){
        cola.enqueue(camion);
    }
    public Camion darIngresoAPatio (){
        return cola.poll();
    }
    public Camion verProximoCamion(){
        return cola.peek();
    }
    public boolean hayCamiones(){
        return !cola.isEmpty();
    }
    public int totalEnEspera (){
        return cola.size();
    }
    public String listarCamiones (){
        return cola.toString();
    }
}
