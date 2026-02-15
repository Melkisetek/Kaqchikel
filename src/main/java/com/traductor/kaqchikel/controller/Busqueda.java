package com.traductor.kaqchikel.controller;

import com.traductor.kaqchikel.dao.IPalabraDAO;
import com.traductor.kaqchikel.dao.PalabraDAOimpl;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.traductor.kaqchikel.util.StringUtilidad;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public final class Busqueda {

    private MainGUI vista;
    private PalabraDAOimpl daoImp;
    private Timer timer;

    public Busqueda(MainGUI vista) {
        this.vista = vista;
        this.daoImp = new PalabraDAOimpl();
        iniciarEventos();
        configuraPopup();  // solo una vez
    }

// Se ejecuta UNA SOLA VEZ
    public void configuraPopup() {

// USAMOS los componentes del diseñador
        //  vista.getPopupMenu().add(new JScrollPane(vista.getLista()));
        vista.getPopupMenu().add(vista.getLista());
        

    }

    // Escucha escritura en el JTextField
    private void iniciarEventos() {

        // Timer para no consultar la BD en cada tecla
        timer = new Timer(200, e -> mostrarSugerencias());
        timer.setRepeats(false);

        vista.getTxtBuscar().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // mostrarSugerencias();
                timer.restart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //mostrarSugerencias();
                timer.restart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // para txtField no utiliza
            }
        });

        // Click sobre una sugerencia
        vista.getLista().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String seleccion = vista.getLista().getSelectedValue();

                if (seleccion != null) {
                    vista.getTxtBuscar().setText(seleccion);
                    vista.getPopupMenu().setVisible(false);
                    buscar();
                }
                
            }
        });
    }

    private void mostrarSugerencias() {
        String texto = vista.getTxtBuscar().getText().trim();
        // Limpiamos la entrada del usuario antes de enviarla
        String criterioLimpio = StringUtilidad.normalizar(texto);
        if (criterioLimpio.isEmpty()) {
            vista.getPopupMenu().setVisible(false);
            return;
        }

        List<Palabra> sugerencias = this.daoImp.obtenerSugerencias(new Palabra(criterioLimpio));

        if (sugerencias.isEmpty()) {
            vista.getPopupMenu().setVisible(false);
            return;
        }

        // Convertimos Palabra → String
        String[] datos = sugerencias.stream()
                .map(Palabra::getEspañol)
                .toArray(String[]::new);

        vista.getLista().setListData(datos);

        // Mostrar popup debajo del JTextField
        vista.getPopupMenu().show(
                vista.getTxtBuscar(),
                0,
                vista.getTxtBuscar().getHeight()
        );
    }
    
    public void buscar() {
        JTextArea txtArea = (JTextArea) vista.getTextArea();
        // 1. Obtener el texto que escribió el usuario en la interfaz
        String buscar = vista.getTxtBuscar().getText().trim();

        IPalabraDAO buscarPalabra = new PalabraDAOimpl();
        Palabra palabra = new Palabra(buscar);
        var encontrado = buscarPalabra.buscarTermino(palabra);

        if (encontrado.getKaqchikel() != null) {
            txtArea.setText(" " + "Español:  " + palabra.getEspañol() + "\n" + " " + "Kaqchikel:  " + palabra.getKaqchikel());
            //txtArea.setText(palabra.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Error de busqueda");
        }
    }

}
