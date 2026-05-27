package model;

public class DettaglioOrdine {

    // 1. CAMPI / ATTRIBUTI
    private int idDettaglio;
    private int quantita;
    private double prezzoUnitario;
    private String notePreparazione;

    // Ordine (1 composizione) --- Contiene --- (1..*) DettaglioOrdine
    private Ordine ordine;

    // DettaglioOrdine (0..*) --- indica --- (1) Prodotto
    private Prodotto prodotto;      // Inserire nel Costruttore


    // 2. COSTRUTTORE
    public DettaglioOrdine(int idDettaglio, int quantita, double prezzoUnitario, String notePreparazione, Ordine ordine, Prodotto prodotto){
        this.idDettaglio = idDettaglio;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.notePreparazione = notePreparazione;

        this.ordine = ordine;
        this.prodotto = prodotto;
    }


    // 3. GETTERS
    public int getIdDettaglio(){
        return this.idDettaglio;
    }

    public int getQuantita(){
        return this.quantita;
    }

    public double getPrezzoUnitario(){
        return this.prezzoUnitario;
    }

    public String getNotePreparazione(){
        return this.notePreparazione;
    }

    public Ordine getOrdine(){
        return this.ordine;
    }

    public Prodotto getProdotto(){
        return this.prodotto;
    }

    // 4. SETTERS

    /*
    public void setOrdine(Ordine ordine){
        this.ordine = ordine;
    }
     */

    public void setQuantita(int nuovaQuantita){
        if(nuovaQuantita > 0){
            this.quantita = nuovaQuantita;
        }
    }

    public void setNotePreparazione(String notePreparazione){
        this.notePreparazione = notePreparazione;
    }

    // 5. Metodi
    public double getSubTotale(){
        return this.quantita * this.prezzoUnitario;   // Calcoliamo il prezzo sul momento
    }

}
