package com.traductor.kaqchikel.dao;

import com.traductor.kaqchikel.model.Palabra;
import java.sql.Connection;
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
    public Palabra buscarTermino(Palabra palabraBuscar) {
        PreparedStatement ps;
        ResultSet rs;
        var con = ConexionSQLite.getConexion();
        // insensible a mayúsculas/minúsculas, eliminar espacios inicio, final.
        var sql = "SELECT * FROM traduccion "
                        + "WHERE LOWER(TRIM(texto_espanol)) LIKE LOWER(TRIM(?))"; 
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, palabraBuscar.getEspañol());
            rs = ps.executeQuery();
            //si hay registro
            if (rs.next()) {
                palabraBuscar.setEspañol(rs.getString("texto_espanol"));
                palabraBuscar.setKaqchikel(rs.getString("texto_kaqchikel"));
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

        return palabraBuscar;
    }

    @Override
    public List<Palabra> filtrarListaPorLetra(Palabra filtrar) {
        List<Palabra> listaFiltrada = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionSQLite.getConexion();
        String sql = "SELECT * FROM traduccion WHERE texto_espanol GLOB ? ORDER BY id ASC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, filtrar.getEspañol()); // Regex*
            rs = ps.executeQuery();
            while (rs.next()) {
                Palabra lista = new Palabra();
                lista.setId(rs.getInt("id"));
                lista.setEspañol(rs.getString("texto_espanol"));
                lista.setKaqchikel(rs.getString("texto_kaqchikel"));
                // agrar a la lista
                listaFiltrada.add(lista);
            }
        } catch (SQLException e) {
            System.out.println("Error al filtrar la lista: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

        return listaFiltrada;
    }

    @Override
    public List<Palabra> obtenerSugerencias(Palabra palabra) {
        List<Palabra> sugerencias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionSQLite.getConexion();
        String sql = "SELECT texto_espanol FROM traduccion WHERE texto_espanol LIKE ? LIMIT 10";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, palabra.getEspañol() + "%"); //autocomplete
            rs = ps.executeQuery();
            while (rs.next()) {
                Palabra palabraBuscar = new Palabra();
                palabraBuscar.setEspañol(rs.getString("texto_espanol"));
                sugerencias.add(palabraBuscar);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener Segerencias: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex);
            }
        }

        return sugerencias;
    }

    public static void main(String[] args) {
        // Listar clientes
//    System.out.println("*** Listar traducción ***");
        IPalabraDAO palabraDao = new PalabraDAOimpl();
//        var palabras = palabraDao.listarPalabra();
//        palabras.forEach(System.out::println);

        // *** Busqueda por nombre *** 
//        var palabra = new Palabra("Abeja");
//        System.out.println("Palabra antes de la busqueda: " + palabra);
//        var encontrado = palabraDao.buscarTermino(palabra);
//
//        if (encontrado.getKaqchikel() != null) {
//            System.out.println("Palabra encontrado: " + palabra);
//        } else {
//            System.out.println("NO SE ENCONTRO: " + palabra.getEspañol());
//        }
        // *** filtrarListaPorLetra  ***
//        String regex = "[R]*";
//        Palabra palabra = new Palabra(regex);
//        var filtrarPalabraLista = palabraDao.filtrarListaPorLetra(palabra);
//        if (palabra.getEspañol().isEmpty()) {
//            System.out.println("Cadena vacía, ingrese una letra");
//            return;
//        }
//        filtrarPalabraLista.forEach(System.out::println);

        // *** Mostrar Sugerencias de Busqueda***
//        String palabraBuscar = "ab";
//        Palabra palabra = new Palabra(palabraBuscar);
//        var mostrarSegerencia = palabraDao.obtenerSugerencias(palabra);
//        if (palabra.getEspañol().isEmpty()) {
//            System.out.println("Cadena vacía, ingrese una letra");
//            return;
//        }
//        
//        mostrarSegerencia.forEach(System.out::println);

    }

}
