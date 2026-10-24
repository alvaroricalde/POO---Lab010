import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.conectarBaseDeDatos();
        //databaseConnector.selectProductos();


        //databaseConnector.insertProductos("P6", "Camisa", 35, 20);
        //databaseConnector.updateProducto("P6", "Camiseta", 30, 35);

        //databaseConnector.deleteProducto("P6");

        Scanner scanner = new Scanner(System.in);

        int opcion;
        int opcionSubMenu;
        do {
            System.out.println("\n1. Administrar la tabla PRODUCTOS" +
                    "\n2. Administrar la 2da tabla" +
                    "\n3. Administrar la 3ra tabla" +
                    "\n4. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("\n1. Registrar un nuevo elemento" +
                                "\n2. Listar los elementos registrados" +
                                "\n3. Buscar un elemento por su identificador" +
                                "\n4. Actualizar un elemento" +
                                "\n5. Eliminar un elemento" +
                                "\n6. Regresar al menu principal");
                        opcionSubMenu = Integer.parseInt(scanner.nextLine());
                        switch (opcionSubMenu) {
                            case 1:
                                System.out.print("\nIngrese el identificador del producto: ");
                                String id_producto = scanner.nextLine();
                                System.out.print("Igrese el nombre del producto: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Ingrese el precio del producto: ");
                                float precio = Float.parseFloat(scanner.nextLine());
                                System.out.print("Ingrese el stock del producto: ");
                                int stock = Integer.parseInt(scanner.nextLine());

                                databaseConnector.insertProductos(id_producto, nombre, precio, stock);
                                break;
                            case 2:
                                databaseConnector.selectProductos();
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                System.out.println("Regresando al menu principal");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    } while (opcionSubMenu != 6);

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
        } while (opcion != 4);

    }
}