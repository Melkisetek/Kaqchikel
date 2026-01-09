
package com.traductor.kaqchikel.controller;

import com.traductor.kaqchikel.dao.PalabraDAOimpl;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DiccionarioController {
    private MainGUI vista;
    private PalabraDAOimpl dao;
    
    public DiccionarioController(MainGUI vista){
        this.vista = vista;
        this.dao = new PalabraDAOimpl();
        cargarTabla();
    }
    
    public void cargarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0); // limpiar tabla
        
        List<Palabra> datos  = dao.listarPalabra();
        
        for (Palabra d : datos) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getEspañol(),
                d.getKaqchikel()
            });
        }
    }
}
