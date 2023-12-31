package model;

import model.data.DBConnector;
import model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
public class Usuario {
    private String nombre;
    private int edad;
    private String rut;
    public Usuario(String nombre, int edad, String rut) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public boolean registrarUsuario(){
        Connection connection = DBConnector.connection("registrousuario","root","");
        DSLContext query = DSL.using(connection);
        return new UsuarioDAO().registrarUsuario(query,this);
    }
}
