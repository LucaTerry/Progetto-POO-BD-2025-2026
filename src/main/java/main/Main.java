package main;

import controller.Controller;
import gui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Usiamo invoekLater() per assicurarci che la finestra venga creata in modo sicuro evitando crash improvvisi
        SwingUtilities.invokeLater(() -> {

            // Creiamo il controller
            Controller controller = new Controller();

            // Creiamo il MainFrame passando il controller in modo che possa interagire con la logica del programma
            new MainFrame(controller);

        });
    }
}