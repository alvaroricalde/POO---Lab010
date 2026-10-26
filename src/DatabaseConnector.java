import java.sql.*;

public class DatabaseConnector {
    private String url = "jdbc:mysql://localhost:3306/tienda_ropa";
    private String usuario = "root";
    private String contrasena = "";
    private Connection connection;

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

                System.out.println(id_producto + " - " + nombre + " - " + precio + " - " + stock);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void selectProductos(String id_producto_buscar) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM producto WHERE id_producto = '" + id_producto_buscar + "'";

            ResultSet resultSet = statement.executeQuery(query);

            //si resulset tiene mas filas
            if (resultSet.next()) {
                String id_producto = resultSet.getString("id_producto");
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                int stock = resultSet.getInt("stock");

                System.out.println(id_producto + " - " + nombre + " - " + precio + " - " + stock);
            } else {
                System.out.println("No se encontro un producto con ese identificador");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertProductos(String id_producto, String nombre, float precio, int stock) {
        try {
            Statement statement = connection.createStatement();
            //a los strings encerrarlos entre '', como en el caso del nombre
            String query = "INSERT INTO producto VALUES('"
                    + id_producto + "', '" + nombre + "', "
                    + precio + ", " + stock + ");";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("\nFilas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto registrado correctamente");
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateProducto(String id_producto, String nombre, float precio, int stock) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE producto SET " +
                    "nombre = '" + nombre + "', " +
                    "precio = " + precio + ", " +
                    "stock = " + stock +
                    " WHERE id_producto = '" + id_producto + "'";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto actualizado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteProducto(String id_producto) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM producto WHERE id_producto = '" + id_producto + "'";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    // TABLA EMPLEADOS -------------------------------------------------------
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

                System.out.println(id_empleado + " - " + nombre + " - " + usuario + " - " + contrasena + " - " + rol);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectEmpleado(String id_empleado_buscar) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM empleado WHERE id_empleado = '" + id_empleado_buscar + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String id_empleado = resultSet.getString("id_empleado");
                String nombre = resultSet.getString("nombre");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                String rol = resultSet.getString("rol");

                System.out.println(id_empleado + "-" + nombre + " - " + usuario + " - " + contrasena + " - " + rol);
            } else {
                System.out.println("No existe el empleado con ese identificador");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void insertEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO empleado VALUES('" + id_empleado + "', '" + nombre + "', '" + usuario + "', '" + contrasena + "', '" + rol + "');";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("\nFilas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Empleado registrado correctamente");
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE empleado SET nombre='" + nombre + "', usuario='" + usuario + "', contrasena='" + contrasena + "', rol='" + rol + "' WHERE id_empleado='" + id_empleado + "';";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);
            if (filasAfectadas > 0) {
                System.out.println("Empleado actualizado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    // RECUERDA QUE LOS VALORES SON : id_empleado, nombre, usuario, contrasena, rol
    //  a los strings encerrarlos entre '', como en el caso del nombre

    public void deleteEmpleado(String id_empleado) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM empleado WHERE id_empleado = '" + id_empleado + "'";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Empleado eliminado correctamente");
            }
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

                System.out.println(id_venta + " - " + id_empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void selectVentas(String id_venta_buscar) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM venta WHERE id_venta = '" + id_venta_buscar + "'";

            ResultSet resultSet = statement.executeQuery(query);

            //si resulset tiene mas filas
            if (resultSet.next()) {
                String id_venta = resultSet.getString("id_venta");
                String id_empleado = resultSet.getString("id_empleado");

                System.out.println(id_venta + " - " + id_empleado);
            } else {
                System.out.println("No se encontro una venta con ese identificador");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertVentas(String id_venta, String id_empleado) {
        try {
            Statement statement = connection.createStatement();
            //a los strings encerrarlos entre '', como en el caso del nombre
            String query = "INSERT INTO venta VALUES('" + id_venta + "', '" + id_empleado + "' );";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("\nFilas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Venta registrado correctamente");
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateVentas(String id_venta, String id_empleado) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE venta SET " +
                    "id_empleado = '" + id_empleado + "', " +
                    " WHERE id_venta = '" + id_venta + "'";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Venta actualizado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteVentas(String id_venta) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM venta WHERE id_venta = '" + id_venta + "'";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("Venta eliminado correctamente");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
}
