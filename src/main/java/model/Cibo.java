package model;

public class Cibo extends Prodotto{

    // 1. CAMPI / ATTRIBUTI
    private String allergeni;
    private boolean isVegano;


    // 2. COSTRUTTORE
    public Cibo (int idProdotto, String nome, double prezzo, String descrizione,
                String allergeni, boolean isVegano){
        super(idProdotto, nome, prezzo, descrizione);

        this.allergeni = allergeni;
        this.isVegano = isVegano;
    }


    // 3. GETTERS
    public String getAllergeni(){
        return this.allergeni;
    }

    public boolean isVegano(){
        return this.isVegano;
    }


    // 4. SETTERS
    public void setAllergeni(String allergeni){
        this.allergeni = allergeni;
    }

    public void setVegano(boolean isVegano){
        this.isVegano = isVegano;
    }

}
