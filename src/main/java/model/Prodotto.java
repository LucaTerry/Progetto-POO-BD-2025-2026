package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Prodotto {

    // 1. CAMPI / ATTRIBUTI
    private int idProdotto;
    private String nome;
    private double prezzo;
    private String descrizione;

    // DettaglioOrdine (0..*) --- indica --- (1) Prodotto
    // private List<DettaglioOrdine> dettagliOrdini = new ArrayList<>();


    // 2. COSTRUTTORE
    public Prodotto(int idProdotto, String nome, double prezzo, String descrizione){
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }


    // 3. GETTERS
    public int getIdProdotto(){
        return this.idProdotto;
    }

    public String getNome(){
        return this.nome;
    }

    public double getPrezzo(){
        return this.prezzo;
    }

    public String getDescrizione(){
        return this.descrizione;
    }

    // 4. SETTERS
    public void setPrezzo(double nuovoPrezzo){
        if (nuovoPrezzo >= 0){
            this.prezzo = nuovoPrezzo;
        } else {
            System.out.println("ERRORE: Il prezzo non può essere negativo.");
        }
    }

    public void setDescrizione(String nuovaDescrizione){
        this.descrizione = nuovaDescrizione;
    }

}
