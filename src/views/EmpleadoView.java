package views;

import controllers.EmpleadoController;
import services.DatabaseConnector;

import java.util.Scanner;

public class EmpleadoView {
    private EmpleadoController empleadoController;
    private DatabaseConnector databaseConnector;
    private Scanner scanner;

    public EmpleadoView(EmpleadoController empleadoController, DatabaseConnector databaseConnector, Scanner scanner) {
        this.empleadoController = empleadoController;
        this.databaseConnector = databaseConnector;
        this.scanner = scanner;
    }

    public void ejecutar() {
        boolean ejecutando = true;
        int opcion;
        while (ejecutando) {
            System.out.println("\n1. Insertar empleado" +
                    "\n2. Consultar empleados" +
                    "\n3. Buscar un empleado" +
                    "\n4. Actualizar empleado" +
                    "\n5. Eliminar empleado" +
                    "\n6. Consultar empleados desde el controlador" +
                    "\n7. Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el identificador del empleado: ");
                    String id_empleado = scanner.nextLine();
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el usuario del empleado: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Ingrese la contrasena del empleado: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("Ingrese el rol del empleado: ");
                    String rol = scanner.nextLine();
                    databaseConnector.insertEmpleado(id_empleado, nombre, usuario, contrasena, rol);
                    break;
                case 2:
                    databaseConnector.selectEmpleado();
                    empleadoController.listarEmpleados();
                    break;
                case 3:
                    System.out.print("\nIngrese el identificador del empleado a buscar: ");
                    String id_empleado_buscar = scanner.nextLine();

                    databaseConnector.selectEmpleado(id_empleado_buscar);
                    break;
                case 4:
                    System.out.print("\nIngrese el identificador del empleado a actualizar: ");
                    String id_empleado_actualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del empleado: ");
                    String nombre_nuevo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo usuario del empleado: ");
                    String usuario_nuevo = scanner.nextLine();
                    System.out.print("Ingrese la nueva contrasena del empleado: ");
                    String contrasena_nueva = scanner.nextLine();
                    System.out.print("Ingrese el nuevo rol del empleado: ");
                    String rol_nuevo = scanner.nextLine();

                    databaseConnector.updateEmpleado(id_empleado_actualizar, nombre_nuevo, usuario_nuevo, contrasena_nueva, rol_nuevo);
                    break;
                case 5:
                    System.out.print("\nIngrese el identificador del empleado a eliminar: ");
                    String id_empleado_eliminar = scanner.nextLine();

                    databaseConnector.deleteEmpleado(id_empleado_eliminar);
                    break;
                case 6:
                    empleadoController.listarEmpleados();
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