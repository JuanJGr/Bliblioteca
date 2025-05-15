package org.example.util;


import java.sql.*;


public class conexion {
    private static final String URL = "dbc:mysql://localhost:3320/biblioteca?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
