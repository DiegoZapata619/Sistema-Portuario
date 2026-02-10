package DataStructures.ModuloD;

import java.util.Scanner;

public class MenuRutas {

    private final RutaService rutaService;
    private final Scanner sc;

    public MenuRutas(RutaService rutaService, Scanner sc) {
        this.rutaService = rutaService;
        this.sc = sc;
    }

    String mensajeMenu = """
            [1] Agregar nueva parada al final (Append)
            [2] Insertar parada entre destinos (Insert por posición)
            [3] Cancelar última parada (Delete final)
            [4] Simular recorrido (Anterior / Siguiente)
            [5] Volver al Menú Principal
            Digite una opción:""";

    public void run() {
        int op;
        do {
            System.out.println();
            System.out.println(mensajeMenu);
            op = leerEntero();

            switch (op) {
                case 1 -> agregarFinal();
                case 2 -> insertarEntre();
                case 3 -> cancelarFinal();
                case 4 -> simularRecorrido();
                case 5 -> System.out.println("Saliendo de Módulo D...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 5);
    }

    private void agregarFinal() {
        System.out.print("Nombre de la parada: ");
        String nombre = sc.nextLine().trim();
        rutaService.agregarParadaFinal(new Parada(nombre));
        System.out.println("Parada agregada al final.");
    }

    private void insertarEntre() {
        if (!rutaService.hayParadas()) {
            System.out.println("Aún no hay paradas. Se insertará como primera.");
            System.out.print("Nombre de la parada: ");
            String nombre = sc.nextLine().trim();
            rutaService.insertarParadaEn(0, new Parada(nombre));
            return;
        }

        System.out.println("Paradas actuales (índices):");
        for (int i = 0; i < rutaService.totalParadas(); i++) {
            System.out.println("[" + i + "] " + rutaService.obtenerParada(i));
        }

        System.out.print("¿En qué posición quieres insertar? (0 a " + rutaService.totalParadas() + "): ");
        int index = leerEnteroRango(0, rutaService.totalParadas());

        System.out.print("Nombre de la nueva parada: ");
        String nombre = sc.nextLine().trim();

        rutaService.insertarParadaEn(index, new Parada(nombre));
        System.out.println("Parada insertada en la posición " + index + ".");
    }

    private void cancelarFinal() {
        Parada p = rutaService.cancelarUltimaParada();
        if (p == null) System.out.println("No hay paradas.");
        else System.out.println("Parada cancelada: " + p);
    }

    private void simularRecorrido() {
        if (!rutaService.hayParadas()) {
            System.out.println("No hay ruta definida.");
            return;
        }

        int actual = 0; // empezamos en la primera parada
        int op;

        do {
            System.out.println("\nParada actual [" + actual + "]: " + rutaService.obtenerParada(actual));
            System.out.println("[1] Siguiente");
            System.out.println("[2] Anterior");
            System.out.println("[3] Salir");
            System.out.print("Opción: ");
            op = leerEntero();

            if (op == 1) {
                if (actual < rutaService.totalParadas() - 1) actual++;
                else System.out.println("Ya estás en la última parada.");
            } else if (op == 2) {
                if (actual > 0) actual--;
                else System.out.println("Ya estás en la primera parada.");
            }

        } while (op != 3);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número: ");
            }
        }
    }

    private int leerEnteroRango(int min, int max) {
        while (true) {
            int n = leerEntero();
            if (n >= min && n <= max) return n;
            System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
        }
    }

    // Para probar SOLO Módulo D
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RutaService service = new RutaService();
        new MenuRutas(service, sc).run();
    }
}
