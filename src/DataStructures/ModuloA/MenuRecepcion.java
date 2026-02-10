
package DataStructures.ModuloA;
import java.util.Scanner;

public class MenuRecepcion {

    private final RecepcionService recepcion;
    private final Scanner sc;
    //Cada que se instancia, se crea un scanner y un objeto recepcion que hace las operaciones de la cola
    public MenuRecepcion(RecepcionService recepcion, Scanner sc) {
        this.recepcion = recepcion;
        this.sc = sc;
    }
    //Text block para evitar llenar el menu de system.out
    String mensajeMenu= """
                   [1] Registrar llegada de camión (Enqueue)
                   [2] Dar ingreso a patio (Dequeue)
                   [3] Ver próximo camión a atender (Peek)
                   [4] Listar todos los camiones en espera
                   [5] Volver al Menú Principal
                   Digite una opción:""";

    public void run() {
        int op;
        do {
            //Un salto de linea por estética
            System.out.println();
            System.out.println(mensajeMenu);
            op = leerEntero();
            //Switch con cada opción en el menú de acuerdo con las especificaciones del documento
            switch (op) {
                case 1:
                    registrar();
                    break;
                case 2:
                    atender();
                    break;
                case 3:
                    verProximo();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }
    //Metodo para registrar cada camion con sus 3 atributos: Placa,empresa y peso con sus respectivas validaciones
    private void registrar() {

        System.out.print("Placa: ");
        String placa = sc.nextLine().trim();

        System.out.print("Empresa: ");
        String empresa = sc.nextLine().trim();
        if (empresa.isEmpty()) empresa = null;

        System.out.print("Peso (kg): ");
        double peso = leerDouble();

        Camion c = new Camion(placa, empresa, peso);
        recepcion.registrarLlegada(c);
        System.out.println("Camión registrado.");
    }
    //Metodo para desencolar y dar acceso al patio de camiones
    private void atender() {
        Camion c = recepcion.darIngresoAPatio();
        if (c == null) System.out.println("No hay camiones en espera.");
        else System.out.println("Ingresó al patio: " + c);
    }
    //Metodo para obtener el próximo camión a ser atentido
    private void verProximo() {
        Camion c = recepcion.verProximoCamion();
        if (c == null) System.out.println("No hay camiones en espera.");
        else System.out.println("Próximo: " + c);
    }

    private void listar() {
        // se imprime toda la cola sin sacar elementos
        System.out.println(recepcion.listarCamiones());
    }
    //Metodos auxiliares para validar
    //Metodo para validar entrada de numero entero
    private int leerEntero() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s); }
            catch (NumberFormatException e) {
                System.out.print("Ingrese un número: "); }
        }
    }
    //Metodo para leer un numero double
    private double leerDouble() {
        while (true) {
            String s = sc.nextLine().trim();
            //Se lee el string y se hace parse con la clase Wrapper de double, más fácil de hacer validacion
            try { return Double.parseDouble(s); }
            catch (NumberFormatException e) { System.out.print("Ingrese un número válido: "); }
        }
    }
}

