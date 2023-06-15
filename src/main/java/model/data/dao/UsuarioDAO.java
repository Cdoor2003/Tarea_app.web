package model.data.dao;

import model.Usuario;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class UsuarioDAO {
    public boolean registrarUsuario(DSLContext query, Usuario usuario) {
        String rut = usuario.getRut();
        String nombre = usuario.getNombre();
        int edad = usuario.getEdad();
        int result = query.insertInto(DSL.table("usuario"),
                DSL.field("rut"),DSL.field("nombre"),DSL.field("edad")).values(
                        rut,nombre,edad
        ).execute();
        return result==1;
    }
}
