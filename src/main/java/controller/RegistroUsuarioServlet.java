package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.data.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if(req.getParameter("edad").length()==0 || req.getParameter("nombre").length()==0 || req.getParameter("rut").length()==0){
            req.setAttribute("textoRespuesta","Datos Incorrectos, favor comprobar nuevamente");
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req,resp);
        }
        else{
            String rutExtraido = null;
            try {
                Connection connection = DBConnector.connection("registrousuario","root","");
                PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where rut = ?");
                preparedStatement.setString(1,req.getParameter("rut"));
                ResultSet set1 = preparedStatement.executeQuery();

                while (set1.next()){
                    rutExtraido = set1.getString(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(rutExtraido == null){
                String nombre = req.getParameter("nombre");
                int edad = Integer.parseInt(req.getParameter("edad"));
                String rut = req.getParameter("rut");
                Usuario usuario = new Usuario(nombre,edad,rut);
                usuario.registrarUsuario();
                req.setAttribute("nombreUsuario",nombre);
                RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                respuesta.forward(req,resp);
            }else{
                req.setAttribute("textoRespuesta","El rut ya ha sido ingresado previamente");
                RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
                respuesta.forward(req,resp);
            }
        }
    }
}
