package com.traductor.kaqchikel.controller;

import com.traductor.kaqchikel.dao.PalabraDAOimpl;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FiltrarPalabra {

    private MainGUI vista;
    private PalabraDAOimpl dao;

    public FiltrarPalabra(MainGUI vista) {
        this.vista = vista;
        this.dao = new PalabraDAOimpl();
        eventos();
    }

    private void eventos() {
        this.vista.getJButtonA().addActionListener(e -> buscarA());
        this.vista.getJButtonB().addActionListener(e -> buscarB());
        this.vista.getJButtonC().addActionListener(e -> buscarC());
        this.vista.getJButtonD().addActionListener(e -> buscarD());
        this.vista.getJButtonE().addActionListener(e -> buscarE());
        this.vista.getJButtonF().addActionListener(e -> buscarF());
        this.vista.getJButtonG().addActionListener(e -> buscarG());
        this.vista.getJButtonH().addActionListener(e -> buscarH());
        this.vista.getJButtonI().addActionListener(e -> buscarI());
        this.vista.getJButtonJ().addActionListener(e -> buscarJ());
        this.vista.getJButtonK().addActionListener(e -> buscarK());
        this.vista.getJButtonL().addActionListener(e -> buscarL());
        this.vista.getJButtonM().addActionListener(e -> buscarM());
        this.vista.getJButtonN().addActionListener(e -> buscarN());
        this.vista.getJButtonO().addActionListener(e -> buscarO());
        this.vista.getJButtonP().addActionListener(e -> buscarP());
        this.vista.getJButtonQ().addActionListener(e -> buscarQ());
        this.vista.getJButtonR().addActionListener(e -> buscarR());
        this.vista.getJButtonS().addActionListener(e -> buscarS());
        this.vista.getJButtonT().addActionListener(e -> buscarT());
        this.vista.getJButtonU().addActionListener(e -> buscarU());
        this.vista.getJButtonV().addActionListener(e -> buscarV());
        this.vista.getJButtonW().addActionListener(e -> buscarW());
        this.vista.getJButtonX().addActionListener(e -> buscarX());
        this.vista.getJButtonY().addActionListener(e -> buscarY());
        this.vista.getJButtonZ().addActionListener(e -> buscarZ());

    }

    // Filtrar listar Por letra
    private void buscarA() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String regex = "[AÁaá]*";
        Palabra palabra = new Palabra(regex);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarB() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Bb]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarC() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Cc]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarD() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Dd]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarE() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ee]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarF() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ff]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarG() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Gg]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }

    private void buscarH() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Hh]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarI() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ii]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarJ() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Jj]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarK() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Kk]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarL() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ll]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarM() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Mm]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarN() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Nn]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarO() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Oo]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarP() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Pp]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarQ() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Qq]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarR() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Rr]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarS() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ss]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarT() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Tt]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarU() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Uu]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarV() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Vv]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarW() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Ww]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarX() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Xx]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarY() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Yy]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

    private void buscarZ() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        String letra = "[Zz]*";
        Palabra palabra = new Palabra(letra);
        List<Palabra> datos = dao.filtrarListaPorLetra(palabra);

        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }

    }

}
