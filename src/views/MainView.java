package views;

import controllers.EmpleadoController;
import controllers.VentaController;
import services.DatabaseConnector;

import java.util.Scanner;
// VOY A AGREGAR ALGO
public class MainView {
    private VentaController ventaController;
    private EmpleadoController empleadoController;
    private DatabaseConnector databaseConnector;
    private Scanner scanner;

    public MainView(VentaController ventaController,EmpleadoController empleadoController, DatabaseConnector databaseConnector, Scanner scanner) {
        this.ventaController = ventaController;
        this.empleadoController = empleadoController;
        this.databaseConnector = databaseConnector;
        this.scanner = scanner;
    }

    public void ejecutar() {
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
            switch (opcion) {
                case 1:
                    databaseConnector.conectarBaseDeDatos();
                    break;
                case 2:
                    break;
                case 3:
                    EmpleadoView empleadoView = new EmpleadoView(empleadoController,databaseConnector,scanner);
                    empleadoView.ejecutar();
                    break;
                case 4:
                    VentaView ventaView = new VentaView(ventaController, databaseConnector, scanner);
                    ventaView.ejecutar();
                    break;
                case 5:
                    System.out.println("Finalizando programa");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }
    }
}
