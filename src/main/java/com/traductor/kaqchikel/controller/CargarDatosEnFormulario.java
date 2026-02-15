package com.traductor.kaqchikel.controller;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class CargarDatosEnFormulario {
    
    private final MainGUI vista;
    private final Palabra palabra = new Palabra();
    
    public CargarDatosEnFormulario(MainGUI vista) {
      this.vista = vista;
        eventos();
    }
    
    private void eventos() {
        // Seleccionar fila de la tabla
        vista.getTabla().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int filaSeleccionada = vista.getTabla().getSelectedRow();
                if (filaSeleccionada != -1) {
                    seleccionarFormulario(filaSeleccionada);
                }
            }
        });
    }
    
    private void seleccionarFormulario(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla().getModel();

        // crear objetos 
        this.palabra.setEspañol(modelo.getValueAt(fila, 1).toString());
        this.palabra.setKaqchikel(modelo.getValueAt(fila, 2).toString());
        // Pasar objeto a los métodos
        mostrarDatos(this.palabra);
    }
    
    private void mostrarDatos(Palabra palabra) {
        vista.getTextArea().setText("Español: " + palabra.getEspañol() + "\n" + "Kaqchikel: " + palabra.getKaqchikel());
    }
    
}
