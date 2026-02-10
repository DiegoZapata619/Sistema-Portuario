package DataStructures.ModuloA;

public class Camion {

    //Atributos final: No se puede modificar información sobre camiones una vez registrados
    private final String placa;
    private final String empresa;
    private final double pesoKg;

    //Constructor
    public Camion(String placa, String empresa, double pesoKg) {
        this.placa = placa;
        this.empresa = empresa;
        this.pesoKg = pesoKg;
    }

    //Getters
    public String getPlaca() {
        return placa; }
    public String getEmpresa() {
        return empresa; }
    public double getPesoKg() {
        return pesoKg; }

    //Devuelve información de cada camión registrado. Uso de operador ternario para contemplar campos vacios
    @Override
    public String toString() {
        return "Placa [" + placa + "]" + (empresa != null ? " - " + empresa : "") +
                (pesoKg > 0 ? " (" + pesoKg + " kg)" : "");
    }
}
