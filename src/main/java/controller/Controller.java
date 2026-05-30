package controller;

import model.Tavolo;
import model.enums.PosizioneTavolo;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Tavolo> tavoli;

    public Controller() {
        tavoli = new ArrayList<>();

        // metodo che aggiunge dati temporanei finti
        aggiungiTavoliTemp();
    }


    public void aggiungiTavoliTemp(){
        // Dati temporanei finiti
        tavoli.add(new Tavolo(1, 1, 2, PosizioneTavolo.INTERNO));
        tavoli.add(new Tavolo(2, 2, 4, PosizioneTavolo.INTERNO));
        tavoli.add(new Tavolo(3, 3, 4, PosizioneTavolo.ESTERNO));
        tavoli.add(new Tavolo(4, 4, 6, PosizioneTavolo.ESTERNO));
        tavoli.add(new Tavolo(5, 5, 8, PosizioneTavolo.INTERNO));
    }


    public List<Tavolo> getTavoli() {
        return tavoli;
    }


    public void cambiaPosizioneTavolo(int idTavolo, PosizioneTavolo nuovaPosizione) {

        for (Tavolo tavolo : tavoli) {
            if (tavolo.getIdTavolo() == idTavolo) {         // Confronta l'id del tavolo corrente con quello ricevuto
                tavolo.setPosizione(nuovaPosizione);        // Se uguale: modifica la posizione det tavolo corrente
                break;                                      // Usciamo subito
            }
        }

    }

}