package controllers;

import models.EmpleadoModel;

import java.util.ArrayList;

public class EmpleadoController {

    private ArrayList<EmpleadoModel> listaEmpleados = new ArrayList<EmpleadoModel>();

    // public EmpleadoModel(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
    public void agregarEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        EmpleadoModel nuevoEmpleado = new EmpleadoModel(id_empleado, nombre, usuario, contrasena, rol);
        listaEmpleados.add(nuevoEmpleado);
    }

    public void listarEmpleados() {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            listaEmpleados.get(i).mostrarInformacion();
        }
    }

    public void actualizarEmpleado(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (id_empleado.equals(listaEmpleados.get(i).getId_empleado())) {
                listaEmpleados.get(i).setNombre(nombre);
                listaEmpleados.get(i).setUsuario(usuario);
                listaEmpleados.get(i).setContrasena(contrasena);
                listaEmpleados.get(i).setRol(rol);
                break;
            }
        }
    }

    public void eliminarEmpleado(String id_empleado) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (id_empleado.equals(listaEmpleados.get(i).getId_empleado())) {
                listaEmpleados.remove(i);
                break;
            }
        }
    }

}
