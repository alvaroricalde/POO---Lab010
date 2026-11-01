package models;

public class EmpleadoModel {
    private String  id_empleado;
    private String  nombre;
    private String  usuario;
    private String  contrasena;
    private String  rol;

    public EmpleadoModel(String id_empleado, String nombre, String usuario, String contrasena, String rol) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void mostrarInformacion(){
        System.out.println("+----------------------------------------+");
        System.out.println("| CÓDIGO : "+id_empleado);
        System.out.println("| NOMBRE : "+nombre);
        System.out.println("| USUARIO : "+usuario);
        System.out.println("| CONTRASEÑA : "+contrasena);
        System.out.println("| ROL : "+rol);
        System.out.println("+----------------------------------------+");
    }

}
