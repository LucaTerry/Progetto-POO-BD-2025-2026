package controller;

import model.*;         // Importa le classi del nostro dominio

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    // 1. STATO: Liste che fungono da database centrale
    private List<Tavolo> listaTavoli;
    private List<Dipendente> listaDipendenti;

    public Controller(){
        this.listaTavoli = new ArrayList<>();
        this.listaDipendenti = new ArrayList<>();
    }


    // 2. METODI SCRITTURA: La GUI passa parametri semplici (numeri), il Controller crea l'oggetto.

    public String aggiungiTavolo(int idTavolo, int numeroTavolo, int capienza, PosizioneTavolo posizione){

        // Controllo logico: Esiste già un tavolo (nella lista) con questo numero?
        for (Tavolo t : this.listaTavoli){
            if (t.getNumeroTavolo() == numeroTavolo){       // Controlla ogni numeroTavolo presente nella lista
                return "ERRORE: il tavolo esiste già.";     // Errore
            }
        }

        // Se NON esiste, creo l'oggetto (del model) e lo salvo nella lista
        Tavolo nuovoTavolo = new Tavolo(idTavolo, numeroTavolo, capienza, posizione);
        this.listaTavoli.add(nuovoTavolo);                  // Aggiungiamo il nuovo tavolo (appena creato) alla lista
        return "Tavolo aggiunto con successo!";             // Successo
    }

    public String aggiungiDipendente(int idPersona, String nome, String cognome, String telefono, String matricolaAziendale, Date dataAssunzione, RuoloDipendente ruolo){

        // Controllo logico: Esiste già un dipendente (nella lista) con lo stesso id?
        for (Dipendente dipendente : this.listaDipendenti){
            if (dipendente.getIdPersona() == idPersona){        // Controlla ogni dipendente presente nella lista
                return "ERRORE: Questo dipendente esiste già."; // Errore
            }
        }

        Dipendente nuovoDipendente = new Dipendente(idPersona, nome, cognome, telefono, matricolaAziendale, dataAssunzione, ruolo);
        this.listaDipendenti.add(nuovoDipendente);              // Aggiungiamo il nuovo dipendente (appena creato) alla lista
        return "Dipendente aggiunto con successo!";             // Successo
    }

    // Un metodo di prova per vedere se la GUI riesce a chiamare questa classe
    public void testConnessione() {
        System.out.println("CONTROLLER: Ricevuto! La comunicazione con la GUI funziona perfettamente.");
    }


    // 3. METODI LETTURA: la GUI chiede i dati per mostrarli su schermo

    public List<Tavolo> getListaTavoli(){
        return this.listaTavoli;
    }

    public List<Dipendente> getListaDipendenti(){
        return this.listaDipendenti;
    }


}
