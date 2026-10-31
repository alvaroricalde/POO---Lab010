package views;

import controllers.VentaController;
import services.DatabaseConnector;

import java.util.Scanner;

public class MainView {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        VentaController ventaController = new VentaController();
        DatabaseConnector databaseConnector = new DatabaseConnector(ventaController);

        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Conectar la base de datos" +
                    "\n2. Administrar la tabla PRODUCTOS" +
                    "\n3. Administrar la tabla EMPLEADOS" +
                    "\n4. Administrar la tabla VENTA" +
                    "\n5. Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    databaseConnector.conectarBaseDeDatos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Finalizando programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }
    }
}
