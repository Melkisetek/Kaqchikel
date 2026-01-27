package com.traductor.kaqchikel;
import com.traductor.kaqchikel.ui.MainGUI;
import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 *
 * @author melquisedec
 */
public class App {

    public static void main(String[] args) {
        try {
            // Usar el look and feel del sistema
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            MainGUI main = new MainGUI();
            main.setVisible(true);
        });

    }
}
