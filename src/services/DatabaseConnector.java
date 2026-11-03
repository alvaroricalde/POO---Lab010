package services;

import controllers.EmpleadoController;
import controllers.ProductoController;
import controllers.VentaController;

import java.sql.*;

public class DatabaseConnector {
    private String url = "jdbc:mysql://localhost:3306/tienda_ropa";
    private String usuario = "root";
    private String contrasena = "";
    private Connection connection;

    private VentaController ventaController;
    private EmpleadoController empleadoController;
    private ProductoController productoController;

    public DatabaseConnector(VentaController ventaController, EmpleadoController empleadoController, ProductoController productoController) {
        this.ventaController = ventaController;
        this.empleadoController = empleadoController;
        this.productoController = productoController;
    }

    public void conectarBaseDeDatos() {
        try {
            connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectProductos() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM producto";

            ResultSet resultSet = statement.executeQuery(query);

            //si resulset tiene mas filas
            while (resultSet.next()) {
                String id_producto = resultSet.getString("id_producto");
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                int stock = resultSet.getInt("stock");

                productoController.agregarProducto(id_producto, nombre, precio, stock);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void selectProductos(String id_producto_buscar) {
        try {
            String query = "SELECT * FROM producto WHERE id_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_producto_buscar);
            ResultSet resultSet = preparedStatement.executeQuery();

            //si resulset tiene mas filas
            if (resultSet.next()) {
                String id_producto = resultSet.getString("id_producto");
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                int stock = resultSet.getInt("stock");
                productoController.buscarProducto(id_producto_buscar);
            } else {
                System.out.println("No se encontro un producto con ese identificador");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertProductos(String id_producto, String nombre, float precio, int stock) {
        try {
            String query = "INSERT INTO producto VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_producto);
            preparedStatement.setString(2, nombre);
            preparedStatement.setFloat(3, precio);
            preparedStatement.setInt(4, stock);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("\nFilas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto registrado correctamente");
                productoController.agregarProducto(id_producto, nombre, precio, stock);
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateProducto(String id_producto, String nombre, float precio, int stock) {
        try {
            String query = "UPDATE producto SET nombre = ?, precio = ?, stock = ? WHERE id_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setFloat(2, precio);
            preparedStatement.setInt(3, stock);
            preparedStatement.setString(4, id_producto);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto actualizado correctamente");
                productoController.actualizarProductos(id_producto, nombre, precio, stock);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteProducto(String id_producto) {
        try {
            String query = "DELETE FROM producto WHERE id_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_producto);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado correctamente");
                productoController.eliminarProductos(id_producto);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    // TABLA EMPLEADOS --------------------------------------------------------------------
    public void selectEmpleado() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM empleado";

            ResultSet resultSet = statement.executeQuery(query);

            //si resulset tiene mas filas
            while (resultSet.next()) {
                String id_empleado = resultSet.getString("id_empleado");
                String nombre = resultSet.getString("nombre");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                String rol = resultSet.getString("rol");

                empleadoController.agregarEmpleado(id_empleado, nombre, usuario, contrasena, rol);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectEmpleado(String id_empleado_buscar) {
        try {
            String query = "SELECT * FROM empleado WHERE id_empleado = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_empleado_buscar);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id_empleado = resultSet.getString("id_empleado");
                String nombre = resultSet.getString("nombre");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                String rol = resultSet.getString("rol");
                empleadoController.buscarEmpleado(id_empleado);
            } else {
                System.out.println("No existe el empleado con ese identificador");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
    /* Por hacer */

    public void insertEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        try {
            String query = "INSERT INTO empleado VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_empleado);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, usuario);
            preparedStatement.setString(4, contrasena);
            preparedStatement.setString(5, rol);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            empleadoController.agregarEmpleado(id_empleado, nombre, usuario, contrasena, rol);
            if (filasAfectadas > 0) {
                System.out.println("Empleado registrado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        try {
            //            String query = "UPDATE productos SET nombre = ?, precio = ? where codigo = ?";
            //            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //            preparedStatement.setString(1, nombre);
            //            preparedStatement.setFloat(2, precio);
            //            preparedStatement.setInt(3, codigo);
            //            int filasAfectadas = preparedStatement.executeUpdate();
            //            System.out.println("Filas afectadas: " + filasAfectadas);
            //            productoController.actualizarProducto(codigo, nombre, precio);

            String query = "UPDATE empleado SET nombre=?, usuario=?, contrasena=?, rol=? WHERE id_empleado = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, usuario);
            preparedStatement.setString(3, contrasena);
            preparedStatement.setString(4, rol);
            preparedStatement.setString(5, id_empleado);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            if (filasAfectadas > 0) {
                System.out.println("Empleado actualizado correctamente");
            }
            empleadoController.actualizarEmpleado(id_empleado, nombre, usuario, contrasena, rol);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    // RECUERDA QUE LOS VALORES SON : id_empleado, nombre, usuario, contrasena, rol
    //  a los strings encerrarlos entre '', como en el caso del nombre

    public void deleteEmpleado(String id_empleado) {
        try {
            String query = "DELETE FROM empleado WHERE id_empleado = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_empleado);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            if (filasAfectadas > 0) {
                System.out.println("Empleado eliminado correctamente");
            }
            empleadoController.eliminarEmpleado(id_empleado);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    // Tabla Venta
    public void selectVentas() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM venta";

            ResultSet resultSet = statement.executeQuery(query);

            //si resulset tiene mas filas
            while (resultSet.next()) {
                String id_venta = resultSet.getString("id_venta");
                String id_empleado = resultSet.getString("id_empleado");
                String id_cliente = resultSet.getString("id_cliente");
                String fecha_venta = resultSet.getString("fecha_venta");
                ventaController.agregarVenta(id_venta, id_empleado, id_cliente, fecha_venta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void selectVentas(String id_venta_buscar) {
        try {
            String query = "SELECT * FROM venta WHERE id_venta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_venta_buscar);

            ResultSet resultSet = preparedStatement.executeQuery();

            //si resulset tiene mas filas
            if (resultSet.next()) {
                String id_venta = resultSet.getString("id_venta");
                String id_empleado = resultSet.getString("id_empleado");
                String id_cliente = resultSet.getString("id_cliente");
                String fecha_venta = resultSet.getString("fecha_venta");

                ventaController.buscarVenta(id_venta_buscar);
            } else {
                System.out.println("No se encontro una venta con ese identificador");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertVentas(String id_venta, String id_empleado, String id_cliente, String fecha_venta) {
        try {
            String query = "INSERT INTO venta VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_venta);
            preparedStatement.setString(2, id_empleado);
            preparedStatement.setString(3, id_cliente);
            preparedStatement.setString(4, fecha_venta);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("\nFilas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Venta registrado correctamente");
                ventaController.agregarVenta(id_venta, id_empleado, id_cliente, fecha_venta);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateVentas(String id_venta, String id_empleado, String id_cliente, String fecha_venta) {
        try {
            String query = "UPDATE venta SET id_empleado = ?, id_cliente = ?, fecha_venta = ? WHERE id_venta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_empleado);
            preparedStatement.setString(2, id_cliente);
            preparedStatement.setString(3, fecha_venta);
            preparedStatement.setString(4, id_venta);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            if (filasAfectadas > 0) {
                System.out.println("Venta actualizado correctamente");
                ventaController.actualizarVenta(id_venta, id_empleado, id_cliente, fecha_venta);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteVentas(String id_venta) {
        try {
            String query = "DELETE FROM venta WHERE id_venta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id_venta);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            if (filasAfectadas > 0) {
                System.out.println("Venta eliminado correctamente");
                ventaController.eliminarVenta(id_venta);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
}
