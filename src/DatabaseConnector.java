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

    public void insertProductos(String id_producto, String nombre, float precio, int stock) {
        try {
            Statement statement = connection.createStatement();
            //a los strings encerrarlos entre '', como en el caso del nombre
            String query = "INSERT INTO producto VALUES('"
                    + id_producto + "', '" + nombre + "', "
                    + precio + ", " + stock + ");";
            int filasAfectadas = statement.executeUpdate(query);
            System.out.println("Filas afectadas: " + filasAfectadas);
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
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

}
