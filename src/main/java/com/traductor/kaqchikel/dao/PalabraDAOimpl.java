package com.traductor.kaqchikel.dao;

import com.traductor.kaqchikel.model.Palabra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAOimpl implements IPalabraDAO {

    @Override
    public List<Palabra> listarPalabra() {
        List<Palabra> listar = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionSQLite.getConexion();
        var sql = "SELECT * FROM traduccion ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var lista = new Palabra();
                lista.setId(rs.getInt("id"));
                lista.setEspañol(rs.getString("texto_espanol"));
                lista.setKaqchikel(rs.getString("texto_kaqchikel"));
                // agregar a la lista
                listar.add(lista);
            }
        } catch (Exception e) {
            System.out.println("Error DAO: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
        return listar;
    }

    @Override
    public Palabra buscarTermino(Palabra palabra) {
        PreparedStatement ps;
        ResultSet rs;
        var con = ConexionSQLite.getConexion();
        var sql = "SELECT * FROM traduccion WHERE texto_espanol = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, palabra.getEspañol());
            rs = ps.executeQuery();
            //si hay registro
            if (rs.next()) {
                palabra.setEspañol(rs.getString("texto_espanol"));
                palabra.setKaqchikel(rs.getString("texto_kaqchikel"));
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar cliente:  " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return palabra;
    }

    public static void main(String[] args) {
        // Listar clientes
//    System.out.println("*** Listar traducción ***");
        IPalabraDAO palabraDao = new PalabraDAOimpl();
//        var palabras = palabraDao.listarPalabra();
//        palabras.forEach(System.out::println);

        // Busqueda por nombre
        var palabra = new Palabra("Abeja");
        System.out.println("Palabra antes de la busqueda: " + palabra);
        var encontrado = palabraDao.buscarTermino(palabra);

        if (encontrado.getKaqchikel() != null) {
            System.out.println("Palabra encontrado: " + palabra);
        } else {
            System.out.println("NO SE ENCONTRO: " + palabra.getEspañol());
        }
    }

}
