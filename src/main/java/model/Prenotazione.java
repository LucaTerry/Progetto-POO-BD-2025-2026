package model;

import java.time.LocalDateTime;

public class Prenotazione {

    // 1. CAMPI / ATTRIBUTI
    private int idPrenotazione;
    private LocalDateTime dataOra;
    private int numeroPersone;
    private StatoPrenotazione stato = StatoPrenotazione.IN_ATTESA;    // enum (IN_ATTESA di default)

    // Cliente (1) -- effettua -- (0..*) Prenotazione       Relazione BIDIREZIONALE
    private Cliente cliente;    // Inserire nel costruttore

    // Prenotazione (0..*) -- riferito a -- (1) Tavolo
    private Tavolo tavolo;      // Inserire nel costruttore


    // 2. COSTRUTTORE
    public Prenotazione(int idPrenotazione, LocalDateTime dataOra, int numeroPersone, Cliente cliente, Tavolo tavolo){
        this.idPrenotazione = idPrenotazione;
        this.dataOra = dataOra;
        this.numeroPersone = numeroPersone;

        this.cliente = cliente;
        this.tavolo = tavolo;
    }


    // 3. GETTERS
    public int getIdPrenotazione(){
        return this.idPrenotazione;
    }

    public LocalDateTime getDataOra() {
        return this.dataOra;
    }

    public int getNumeroPersone() {
        return this.numeroPersone;
    }

    public StatoPrenotazione getStato() {
        return this.stato;
    }

    // Non serve Collections.unmodifiableList perché non è una lista
    public Cliente getCliente() {
        return this.cliente;
    }

    public Tavolo getTavolo(){
        return this.tavolo;
    }


    // 4 SETTERS
    public void setDataOra(LocalDateTime nuovaDataOra){
        this.dataOra = nuovaDataOra;
    }

    public void setNumeroPersone(int nuovoNumeroPersone){
        // Controllo
        if (nuovoNumeroPersone > 0){
            this.numeroPersone = nuovoNumeroPersone;
        } else {
            System.out.println("ERRORE: Il numero di persone deve essere maggiore di 0.");
        }
    }

    public void setStato(StatoPrenotazione nuovoStato){
        this.stato = nuovoStato;
    }

    public void setCliente(Cliente nuovoCliente){
        this.cliente = nuovoCliente;
    }

    public void setTavolo(Tavolo nuovoTavolo){
        this.tavolo = nuovoTavolo;
    }



}
