package models;

public class ProductoModel {
    private String id_producto;
    private String nombre;
    private float precio;
    private int stock;

    public ProductoModel(String id_producto, String nombre, float precio, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void mostrarInformacion() {
        System.out.println("+----------------------------------------+");
        System.out.println("| CODIGO : " + id_producto);
        System.out.println("| NOMBRE : " + nombre);
        System.out.println("| PRECIO : " + precio);
        System.out.println("| STOCK : " + stock);
        System.out.println("+----------------------------------------+");
    }
}
