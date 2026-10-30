package models;

public class VentaModel {
    private String id_venta;
    private String id_empleado;
    private String id_cliente;
    private String fecha_venta;

    public VentaModel(String id_venta, String id_empleado, String id_cliente, String fecha_venta) {
        this.id_venta = id_venta;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.fecha_venta = fecha_venta;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void mostrarInformacion(){
        System.out.println("ID_VENTA: "+id_venta+" - ID_EMPLEADO: "+id_empleado
                + " - ID_CLIENTE: "+id_cliente +  " - FECHA_VENTA: "+fecha_venta);
    }
}
