package com.traductor.kaqchikel.controller;
import com.traductor.kaqchikel.dao.PalabraDAOimpl;
import com.traductor.kaqchikel.model.Palabra;
import com.traductor.kaqchikel.ui.MainGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Busqueda {

    private MainGUI vista;
    private PalabraDAOimpl daoImp;

    public Busqueda(MainGUI vista) {
        this.vista = vista;
        this.daoImp = new PalabraDAOimpl();
        iniciarEventos();
        configuraPopup();  // solo una vez
    }
    
// Se ejecuta UNA SOLA VEZ
    private void configuraPopup() {
// USAMOS los componentes del diseñador
        //  vista.getPopupMenu().add(new JScrollPane(vista.getLista()));
        vista.getPopupMenu().add(vista.getLista());
    }

    // Escucha escritura en el JTextField
    private void iniciarEventos() {
        vista.getTxtBuscar().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrarSugerencias();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrarSugerencias();
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
                }
            }
        });
    }

    private void mostrarSugerencias() {
        String texto = vista.getTxtBuscar().getText().trim();
        
        if (texto.isEmpty()) {
            vista.getPopupMenu().setVisible(false);
            return;
        }
        
        
        List<Palabra> sugerencias = this.daoImp.obtenerSugerencias(new Palabra(texto));

        if (sugerencias.isEmpty()) {
            vista.getPopupMenu().setVisible(false);
            return;
        }

        // Convertimos Palabra → String
        String[] datos = sugerencias.stream()
                .map(Palabra::getEspañol) // AJUSTA según tu modelo
                .toArray(String[]::new);

        vista.getLista().setListData(datos);

        // Mostrar popup debajo del JTextField
        vista.getPopupMenu().show(
                vista.getTxtBuscar(),
                0,
                vista.getTxtBuscar().getHeight()
        );
    }

}
