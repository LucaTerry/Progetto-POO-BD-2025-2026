package gui;

import controller.TavoloController;

import javax.swing.*;
import java.awt.*;

// Finestra per gestire i tavoli
public class TavoloPanel {
    private JPanel mainPanel;
    private JButton btnAggiungi;
    private JTextField txtNumeroTavolo;
    private JTextField txtPosti;

    // Aggiugiamo il controller
    private TavoloController controller;

    // Costruttore che riceve il controller
    public TavoloPanel(TavoloController controller){
        this.controller = controller;
        inizializzaUI();
    }

    private void inizializzaUI(){

        // Creazione componenti
        mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtNumeroTavolo = new JTextField(10);                         // Riquadro per inserimento del numero tavolo
        txtPosti = new JTextField(10);                                // Riquadro inserimento numero posti
        btnAggiungi = new JButton("Aggiungi Tavolo");          // Pulsante "Aggiungi Tavolo"

        // Aggiungiamo etichette e campi
        mainPanel.add(new JLabel("Numero Tavolo:"));
        mainPanel.add(txtNumeroTavolo);

        mainPanel.add(new JLabel("Posti:"));
        mainPanel.add(txtPosti);

        mainPanel.add(new JLabel(""));                          // Posizione tavolo (Vuoto al momento)

        mainPanel.add(btnAggiungi);

        // Colleghiamo il bottone al metodo (l'azione)
        btnAggiungi.addActionListener(e -> aggiungiTavolo());
    }

    private void aggiungiTavolo(){
        // addActionListener() potrebbe produrre un Exception, usiamo un try catch
        try {
            int numeroTavolo = Integer.parseInt(txtNumeroTavolo.getText());
            int capienza = Integer.parseInt(txtPosti.getText());
            boolean successo = controller.aggiungiTavolo(numeroTavolo, capienza, null);

            if (successo) {
                JOptionPane.showMessageDialog(mainPanel, "Tavolo inserito con successo!");
                txtNumeroTavolo.setText("");
                txtPosti.setText("");
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Errore: Esiste già un tavolo con questo numero.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel, "Errore: Inserisci solo numeri!");
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}




