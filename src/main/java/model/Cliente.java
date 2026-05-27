package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente extends Persona{

    // 1. CAMPI / ATTRIBUTI
    private String notaAllegie;

    // Cliente (1) -- effettua -- (0..*) Prenotazione
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    // Cliente (0..1) --- effettua --- (0..*) Ordine
    // private List<Ordine> ordini = new ArrayList<>();


    // 2. COSTRUTTORE
    public Cliente(int idPersona, String nome, String cognome, String telefono, String notaAllegie){
                    super(idPersona, nome, cognome, telefono);

        this.notaAllegie = notaAllegie;
    }


    // 3. GETTERS
    public String getNotaAllegie(){
        return this.notaAllegie;
    }

    // Getter (solo lettura) per ottenere la lista delle prenotazioni
    public List<Prenotazione> getPrenotazioni() {
        return Collections.unmodifiableList(this.prenotazioni);
    }

    // 4. SETTERS
    public void setNotaAllegie(){
        this.notaAllegie = notaAllegie;
    }


    // 5. ALTRI METODI

    // Metodo per aggiungere una prenotazione (Sincronizzato con classe Cliente)
    public void addPrenotazione(Prenotazione nuovaPrenotazione){
        // Controlla se la prenotazione che passiamo NON è vuota && Controlla se la prenotazione NON esiste già
        if(nuovaPrenotazione != null && !this.prenotazioni.contains(nuovaPrenotazione)){
            this.prenotazioni.add(nuovaPrenotazione);       // 1. Aggiungo la nuova prenotazione alla lista (lato Cliente)
            nuovaPrenotazione.setCliente(this);             // 2. Sincronizzo aggiungendo il cliente alla prenotazione (lato Prenotazione)
        }
    }

    // Metodo per rimuovere una prenotazione (Sincronizzato con classe Cliente)
    public void rimuoviPrenotazione(Prenotazione prenotazione){
        // Controlla se la prenotazione che passiamo NON è vuota && Controlla se la prenotazione ESISTE
        if(prenotazione != null && this.prenotazioni.contains(prenotazione)){
            this.prenotazioni.remove(prenotazione);         // 1. Rimuovo la prenotazione dalla lista (lato Cliente)
            prenotazione.setCliente(null);                  // 2. Sincronizzo rimuovendo il cliente dalla prenotazione (lato Prenotazione)
        }
    }

}
