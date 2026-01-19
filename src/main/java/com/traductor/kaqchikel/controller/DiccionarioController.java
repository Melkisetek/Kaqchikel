
package com.traductor.kaqchikel.controller;
import com.traductor.kaqchikel.dao.IPalabraDAO;
import com.traductor.kaqchikel.dao.PalabraDAOimpl;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public  class DiccionarioController {
    private  MainGUI vista;
    private PalabraDAOimpl dao;
    
    public DiccionarioController(MainGUI vista){
        this.vista = vista;
        this.dao = new PalabraDAOimpl();
        cargarTabla();
        eventos();
    }
    
    private void cargarTabla(){
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

    private void eventos() {
        vista.getBtnBuscar().addActionListener(e  -> buscar());
    }
    
    private void buscar(){
        JTextArea txtArea = (JTextArea) vista.getTextArea();
        String buscar = vista.getTxtBuscar().getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor, ingrese un texto para buscar", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        IPalabraDAO buscarPalabra = new PalabraDAOimpl();
        Palabra palabra = new Palabra(buscar);
        var encontrado = buscarPalabra.buscarTermino(palabra);
         
        if (encontrado.getKaqchikel() != null) {
            txtArea.setText(palabra.toString());
        }else{
            JOptionPane.showMessageDialog(null, 
                    "No se encontro la Palabra:  "+palabra.getEspañol(),
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
