package com.traductor.kaqchikel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLite {
    private static final String url = "jdbc:sqlite:src/main/resources/database/traducciones.db";

    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "Traductor Kaqchikel";

        try {
            // Cargar el driver JDBC de SQLite
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Error al conectar a la BD" + e.getMessage());
        }

        return conexion;
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
