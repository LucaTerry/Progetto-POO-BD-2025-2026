package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Controller controller;

    // COSTRUTTORE
    public MainFrame(Controller controller){
        this.controller = controller;

        // Impostazioni base della finestra Swing
        setTitle("Gestione Ristorante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inizializzaUI();
    }

    private void inizializzaUI(){
        // Qui creiamo i componenti (JPanel, JButton, etc.)

        // Impostiamo un layout semplice
        setLayout(new BorderLayout());

        // Creiamo un bottone gigante da mettere al centro
        JButton btnTest = new JButton("Premi per testare il collegamento");

        // Cosa succede quando clicco il bottone?
        btnTest.addActionListener(e -> {
            // la GUI chiama il controller
            controller.testConnessione();

            // Mostriamo anche un piccolo popup a schermo
            JOptionPane.showMessageDialog(this, "Comando inviato! Controlla la console in basso nel tuo IDE.");
        });

        // Aggiungiamo il bottone alla finestra
        add(btnTest, BorderLayout.CENTER);

    }

}
