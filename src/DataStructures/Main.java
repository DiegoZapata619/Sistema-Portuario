package DataStructures;

import DataStructures.ModuloA.MenuRecepcion;
import DataStructures.ModuloA.RecepcionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecepcionService recepcionService = new RecepcionService();
        MenuRecepcion menuRecepcion = new MenuRecepcion(recepcionService,new Scanner(System.in));
        menuRecepcion.run();

    }
}