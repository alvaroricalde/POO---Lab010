package views;

import controllers.VentaController;
import services.DatabaseConnector;

import java.util.Scanner;

public class VentaView {
    private VentaController ventaController;
    private DatabaseConnector databaseConnector;
    private Scanner scanner;

    public VentaView(VentaController ventaController, DatabaseConnector databaseConnector, Scanner scanner) {
        this.ventaController = ventaController;
        this.databaseConnector = databaseConnector;
        this.scanner = scanner;
    }

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Insertar venta" +
                    "\n2. Consultar ventas" +
                    "\n3. Buscar una venta" +
                    "\n4. Actualizar venta" +
                    "\n5. Eliminar venta" +
                    "\n6. Consultar venta desde el controlador" +
                    "\n7. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el identificador de la venta: ");
                    String id_venta = scanner.nextLine();
                    System.out.print("Ingrese el identificador del empleado: ");
                    String id_empleado = scanner.nextLine();
                    System.out.print("\nIngrese el identificador del cliente: ");
                    String id_cliente = scanner.nextLine();
                    System.out.print("Ingrese la fecha de la venta: ");
                    String fecha_venta = scanner.nextLine();
                    databaseConnector.insertVentas(id_venta, id_empleado, id_cliente, fecha_venta);
                    break;
                case 2:
                    databaseConnector.selectVentas();
                    ventaController.listarVentas();
                    break;
                case 3:
                    System.out.print("\nIngrese el identificador de la venta a buscar: ");
                    String id_venta_buscar = scanner.nextLine();

                    databaseConnector.selectVentas(id_venta_buscar);

                    break;
                case 4:
                    System.out.print("\nIngrese el identificador de la venta a actualizar: ");
                    String id_venta_actualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo identificador del empleado: ");
                    String id_empleado_nuevo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo identificador del cliente: ");
                    String id_cliente_nuevo = scanner.nextLine();
                    System.out.print("Ingrese la nueva fecha de la venta: ");
                    String fecha_venta_nueva = scanner.nextLine();

                    databaseConnector.updateVentas(id_venta_actualizar, id_empleado_nuevo, id_cliente_nuevo, fecha_venta_nueva);
                    break;
                case 5:
                    System.out.print("\nIngrese el identificador de la venta a eliminar: ");
                    String id_venta_eliminar = scanner.nextLine();

                    databaseConnector.deleteVentas(id_venta_eliminar);
                    break;
                case 6:
                    ventaController.listarVentas();
                    break;
                case 7:
                    System.out.println("Regresando al menu principal");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
}
