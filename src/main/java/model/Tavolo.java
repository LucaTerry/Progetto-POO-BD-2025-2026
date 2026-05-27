package model;

import java.util.ArrayList;
import java.util.List;

public class Tavolo {
    private int idTavolo;
    private int numeroTavolo;
    private int capienzaMassima;
    private PosizioneTavolo posizione;  // enum (da impostare nel costruttore)

    // Prenotazione (0..*) -- riferito a -- (1) Tavolo
    // private List<Prenotazione> prenotazioni = new ArrayList<>();

    // Ordine (0..*) -- riferito a -- (1) Tavolo
    private List<Ordine> ordini = new ArrayList<>();

    public Tavolo(int idTavolo, int numeroTavolo, int capienzaMassima, PosizioneTavolo posizione){
        this.idTavolo = idTavolo;
        this.numeroTavolo = numeroTavolo;
        this.capienzaMassima = capienzaMassima;
        this.posizione = posizione;
    }

    // 3. GETTERS
    public int getIdTavolo(){
        return this.idTavolo;
    }

    public int getNumeroTavolo(){
        return this.numeroTavolo;
    }

    public int getCapienzaMassima(){
        return this.capienzaMassima;
    }

    public PosizioneTavolo getPosizione(){
        return this.posizione;
    }

    // 4. SETTERS
    public void setPosizione(PosizioneTavolo nuovaPosizione){
        this.posizione = nuovaPosizione;
    }

}
