package main;

import controller.TavoloController;
import gui.TavoloPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // 1. Creiamo il controller
        TavoloController tavoloController = new TavoloController();

        // 2. Creiamo il panel passandogli il controller
        TavoloPanel tavoloPanel = new TavoloPanel(tavoloController);

        // 3. Creiamo la finestra principale
        JFrame frame = new JFrame("Gestione Ristorante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // 4. Aggiungiamo il panel alla finestra
        frame.add(tavoloPanel.getMainPanel());

        // 5. Rendiamo visibile la finestra
        frame.setVisible(true);
    }
}