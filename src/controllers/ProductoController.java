package controllers;

import models.ProductoModel;

import java.util.ArrayList;

public class ProductoController {
    private ArrayList<ProductoModel> listaProductos = new ArrayList<ProductoModel>();

    public void agregarProducto(String id_producto, String nombre, float precio, int stock) {
        ProductoModel nuevoProducto = new ProductoModel(id_producto, nombre, precio, stock);
        listaProductos.add(nuevoProducto);
    }

    public void listarProductos() {
        for (int i = 0; i < listaProductos.size(); i++) {
            listaProductos.get(i).mostrarInformacion();
        }
    }

    public void buscarProducto(String id_producto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (id_producto.equals(listaProductos.get(i).getId_producto())) {
                listaProductos.get(i).mostrarInformacion();
                break;
            }
        }
    }

    public void actualizarProductos(String id_producto, String nombre, float precio, int stock) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (id_producto.equals(listaProductos.get(i).getId_producto())) {
                listaProductos.get(i).setId_producto(nombre);
                listaProductos.get(i).setNombre(nombre);
                listaProductos.get(i).setPrecio(precio);
                listaProductos.get(i).setStock(stock);
                break;
            }
        }
    }

    public void eliminarProductos(String id_empleado) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (id_empleado.equals(listaProductos.get(i).getId_producto())) {
                listaProductos.remove(i);
                break;
            }
        }
    }
}
