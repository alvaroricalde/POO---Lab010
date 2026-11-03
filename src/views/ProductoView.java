package views;

import controllers.ProductoController;
import services.DatabaseConnector;

import java.util.Scanner;

public class ProductoView {
    private ProductoController productoController;
    private DatabaseConnector databaseConnector;
    private Scanner scanner;

    public ProductoView(ProductoController productoController, DatabaseConnector databaseConnector, Scanner scanner) {
        this.productoController = productoController;
        this.databaseConnector = databaseConnector;
        this.scanner = scanner;
    }

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Insertar producto" +
                    "\n2. Consultar producto" +
                    "\n3. Buscar un producto" +
                    "\n4. Actualizar producto" +
                    "\n5. Eliminar producto" +
                    "\n6. Consultar producto desde el controlador" +
                    "\n7. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el codigo del producto: ");
                    String id_empleado = scanner.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    float precio = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese la stock del producto: ");
                    int stock= Integer.parseInt(scanner.nextLine());
                    databaseConnector.insertProductos(id_empleado, nombre, precio, stock);
                    break;
                case 2:
                    databaseConnector.selectProductos();
                    productoController.listarProductos();
                    break;
                case 3:
                    System.out.print("\nIngrese el codigo del producto a buscar: ");
                    String id_producto_buscar = scanner.nextLine();

                    databaseConnector.selectEmpleado(id_producto_buscar);
                    break;
                case 4:
                    System.out.print("\nIngrese el identificador del producto a actualizar: ");
                    String id_producto_actualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del producto: ");
                    String nombre_nuevo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo usuario del producto: ");
                    float precio_nuevo = Float.parseFloat(scanner.nextLine());
                    System.out.print("Ingrese la nueva contrasena del producto: ");
                    int stock_nuevo = Integer.parseInt(scanner.nextLine());

                    databaseConnector.updateProducto(id_producto_actualizar, nombre_nuevo, precio_nuevo, stock_nuevo);
                    break;
                case 5:
                    System.out.print("\nIngrese el identificador del producto a eliminar: ");
                    String id_producto_eliminar = scanner.nextLine();

                    databaseConnector.deleteProducto(id_producto_eliminar);
                    break;
                case 6:
                    productoController.listarProductos();
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
