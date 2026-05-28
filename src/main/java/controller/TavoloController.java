package controller;

import model.PosizioneTavolo;
import model.Tavolo;

import java.util.ArrayList;
import java.util.List;

// Controller che gestisce i tavoli
public class TavoloController {

    // Database temporaneo (solo per i tavoli)
    private List<Tavolo> listaTavoli = new ArrayList<>();
    private int contatoreId = 1;      // per simulare l'ID del database


    public boolean aggiungiTavolo(int numeroTavolo, int capienza, PosizioneTavolo posizione){

        // Controllo logico per vedere se esiste già un tavolo con lo stesso numero
        for (Tavolo t : this.listaTavoli){
            if (t.getNumeroTavolo() == numeroTavolo){       // Controlla ogni numeroTavolo presente nella lista
                return false;     // Errore
            }
        }

        // Se NON esiste, creo l'oggetto (del model) e lo salvo nella lista
        Tavolo nuovoTavolo = new Tavolo(contatoreId, numeroTavolo, capienza, posizione);
        this.listaTavoli.add(nuovoTavolo);                  // Aggiungiamo il nuovo tavolo (appena creato) alla lista
        contatoreId++;                                      // Prepriamo ID per il prossimo tavolo

        return true;             // Successo
    }


    // Metodo per estrarre i dati in formato testo per la GUI
    public String getTavoliFormattati() {
        if (listaTavoli.isEmpty()) {
            return "Nessun tavolo registrato.";
        }

        StringBuilder sb = new StringBuilder();
        for (Tavolo t : listaTavoli) {
            sb.append("Tavolo ").append(t.getNumeroTavolo())
            .append(" | Posti: ").append(t.getCapienzaMassima())
            .append(" | Posizione: ").append(t.getPosizione())
            .append("\n");
        }
        return sb.toString();
    }

}



