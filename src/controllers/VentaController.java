package controllers;

import models.VentaModel;

import java.util.ArrayList;

public class VentaController {
    private ArrayList<VentaModel> listaVentas = new ArrayList<VentaModel>();

    public void agregarVenta(String id_venta, String id_empleado, String id_cliente, String fecha_venta) {
        VentaModel nuevaVenta = new VentaModel(id_venta, id_empleado, id_cliente, fecha_venta);
        listaVentas.add(nuevaVenta);
    }

    public void listarVentas() {
        for (int i = 0; i < listaVentas.size(); ++i) {
            listaVentas.get(i).mostrarInformacion();
        }
    }

    public void actualizarVenta(String id_venta, String id_empleado, String id_cliente, String fecha_venta) {
        for (int i = 0; i < listaVentas.size(); ++i) {
            if (id_venta.equals(listaVentas.get(i).getId_venta())) {
                listaVentas.get(i).setId_empleado(id_empleado);
                listaVentas.get(i).setId_cliente(id_cliente);
                listaVentas.get(i).setFecha_venta(fecha_venta);
                break;
            }
        }
    }

    public void eliminarVenta(String id_venta) {
        for (int i = 0; i < listaVentas.size(); ++i) {
            if (id_venta.equals(listaVentas.get(i).getId_venta())) {
                listaVentas.remove(i);
                break;
            }
        }
    }
}
