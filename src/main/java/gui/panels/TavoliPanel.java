package gui.panels;

import controller.Controller;
import model.Tavolo;
import model.enums.PosizioneTavolo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TavoliPanel extends JPanel {

    private Controller controller;
    private JTable tabella;
    private DefaultTableModel modello;

    public TavoliPanel(Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());              // Impostiamo il tipo di layout

        // Metodo che gestisce il titolo
        titolo();

        // Metodo che gestisce la tabella dei tavoli
        tabella();

        // Metodo che gestisce i pulsanti e le loro azioni
        pulsanti();
    }


    public void titolo(){
        // Titolo
        JLabel titolo = new JLabel("Gestione Tavoli", SwingConstants.CENTER);
        titolo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titolo, BorderLayout.NORTH);
    }

    public void tabella(){
        // Tabella
        String[] colonne = {"ID", "Numero", "Capienza", "Posizione"};   // Definiamo le 4 colonne della tabella

        // Crea il modello della tabella (colonne definite, 0 righe)
        modello = new DefaultTableModel(colonne, 0) {

            // Sovrascriviamo il metodo isCellEditable() ritornando falso: impedisce all'utente di modificare le celle
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

        };

        tabella = new JTable(modello);                             // Crea la tabella effettiva basandosi sul modello che abbiamo stabilito sopra
        add(new JScrollPane(tabella), BorderLayout.CENTER);        // Avvolge la tabella creata al centro di uno scroll panel (nel caso in cui ci fossero tanti dati)
    }


    public void pulsanti(){

        // Crea un sotto-pannello dedicato ai pulsanti (FlowLayout di default)
        JPanel pannelloPulsanti = new JPanel();

        // Crea un menu a tendina contenente tutti i valori dell'enum PosizioneTavolo
        JComboBox<PosizioneTavolo> combo = new JComboBox<>(PosizioneTavolo.values());

        // Crea un pulsante con la scritta "cambia posizione"
        JButton btnCambia = new JButton("Cambia Posizione");

        // Aggiunge un testo come indicazione al sotto-pannello
        pannelloPulsanti.add(new JLabel("Posizione:"));

        // Aggiunge il menu a tendina contenente i valori dell'enum PosizioneTavolo al sotto-pannello
        pannelloPulsanti.add(combo);

        // Aggiunge il pulsante creato ("Cambia Posizione") al sotto-pannello
        pannelloPulsanti.add(btnCambia);

        // Aggiunge l'intero sotto-pannello (con gli elementi creati e inseriti) nella zona SOUTH del TavoliPanel
        add(pannelloPulsanti, BorderLayout.SOUTH);


        // Carica i dati dal controller
        caricaTavoli();


        // Aggiungiamo l'azione al pulsante per cambiare posizione del tavolo
        btnCambia.addActionListener(e -> {

            // getSelectedRow() restituisce -1 se nessuna riga è selezionata
            int riga = tabella.getSelectedRow();

            // Controllo se è stata selezionata una riga
            if (riga == -1) {

                // CASO 1: Nessuna riga è stata selezionata
                JOptionPane.showMessageDialog(this, "Seleziona un tavolo prima!");      // Mostra popup di avviso
                return;                                                                                         // esce subito con return

            }

            // CASO 2: La riga è selezionata

            // Prende l'ID dalla riga selezionata.
            // getValueAt() restituisce un Object generico per questo usiamo un cast (int)
            int idTavolo = (int) modello.getValueAt(riga, 0);


            // 1. getSelectedItem() legge il valore selezionato nella tendina e restituisce un object generico quindi abbiamo biosgno del cast
            // 2. Effettuiamo il cast (PosizioneTavolo)
            // 3. Memorizziamo la nuova posizione selezionata nella variabile nuovaPosizione
            PosizioneTavolo nuovaPosizione = (PosizioneTavolo) combo.getSelectedItem();

            // Aggiorniamo il model chiamando il metodo .cambiaPosizioneTavolo() presente nel controller
            controller.cambiaPosizioneTavolo(idTavolo, nuovaPosizione);


            // Aggiorna solo la UI nella colonna 3 (dove si trova la posizione del tavolo)
            modello.setValueAt(nuovaPosizione, riga, 3);
        });
    }


    // Metodo privato che carica i tavoli nella tabella
    private void caricaTavoli() {

        modello.setRowCount(0);                             // Svuotiamo inizialmente la tabella
        List<Tavolo> tavoli = controller.getTavoli();       // Prendiamo tramite controller la lista di tutti i tavoli

        for (Tavolo tavolo : tavoli) {                      // Scorriamo la lista dei tavoli uno ad uno
            modello.addRow(new Object[]{                    // Ad ogni ciclo, aggiungiamo una nuova riga al modello della tabella

                    tavolo.getIdTavolo(),                   // Colonna 0: Inserisce l'ID del tavolo
                    tavolo.getNumeroTavolo(),               // Colonna 1: Inserisce il numero del tavolo
                    tavolo.getCapienzaMassima(),            // Colonna 2: Inserisce la capienza del tavolo
                    tavolo.getPosizione()                   // Colonna 3: Inserisce la posizione del tavolo

            });
        }

    }



}