package model;

import model.enums.StatoPagamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordine {

    // 1. CAMPI / ATTRIBUTI
    private int idOrdine;
    // private double totaleConto; // RIMOSSO: attributo derivato
    private StatoPagamento stato = StatoPagamento.DA_PAGARE;   // enum (DA_PAGARE di default)

    // Cliente (0..1) --- effettua --- (0..*) Ordine
    private Cliente cliente;        // Opzionale (Potremmo utilizzare un setter)

    // Dipendente (1) --- gestisce --- (0..*) Ordine
    private Dipendente dipendente;  // Da inserire nel costruttore

    // Ordine (0..*) -- riferito a -- (1) Tavolo
    private Tavolo tavolo;          // Da inserire nel costruttore

    // Ordine (1 composizione) -- contiene -- (1..*) DettaglioOrdine
    private List<DettaglioOrdine> dettagliOrdini = new ArrayList<>();


    // 2. COSTRUTTORE
    public Ordine(int idOrdine, Dipendente dipendente, Tavolo tavolo, DettaglioOrdine dettaglio){
        this.idOrdine = idOrdine;

        this.dipendente = dipendente;
        this.tavolo = tavolo;

        // Rispettiamo l' 1..*
        this.dettagliOrdini.add(dettaglio);
    }


    // 3. GETTERS
    public int getIdOrdine(){
        return this.idOrdine;
    }

    public double getTotaleConto() {
        double totale = 0;
        for (DettaglioOrdine d : this.dettagliOrdini) {
            totale += d.getSubTotale(); // Chiama il metodo in DettaglioOrdine
        }
        return totale;
    }

    // Ottieni la lista dei dettagli (solo lettura)
    public List<DettaglioOrdine> getDettagliOrdini() {
        return Collections.unmodifiableList(this.dettagliOrdini);
    }


    // 4. SETTERS
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    // Metodo per aggiungere un dettaglio ordine
    public void addDettaglioOrdine(DettaglioOrdine dettaglio){
        // Controllo se il dettaglio esiste e se non è già nella lista
        if(dettaglio != null && !this.dettagliOrdini.contains(dettaglio)){
            if (dettaglio.getOrdine() == this){
                this.dettagliOrdini.add(dettaglio);
            }
            else {
                System.out.println("ERRORE: Non puoi aggiungere un dettaglio che appartiene a un altro taovolo.");
            }
        }
    }

    public void rimuoviDettaglioOrdine(DettaglioOrdine dettaglio){
        // Controllo se il dettaglio che passiamo NON sia vuoto && Controllo se la lista contiene quel dettaglio
        if (dettaglio != null){
            this.dettagliOrdini.remove(dettaglio);  // Rimuovi il dettaglio dalla lista
        }
    }
}
