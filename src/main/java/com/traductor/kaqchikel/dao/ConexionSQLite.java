package com.traductor.kaqchikel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLite {

    private static final String URL = "jdbc:sqlite:src/main/resources/database/traducciones.db";

    public static Connection getConexion() {
        Connection connection = null;
        try {
            //Proyectos Antiguos requerido el controlador
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);

        } catch (Exception e) {
            System.out.println("Error al conectar a la BD" + e.getMessage());
        }

        return connection;
    }

//    public static void main(String[] args) {
//        var conexion = ConexionSQLite.getConexion();
//        if (conexion != null) {
//            System.out.println("Conexión exitosa" + conexion);
//        } else {
//            System.out.println("Error al conectar");
//        }
//    }
}
