package model;

public class Bevanda extends Prodotto{

    // 1. CAMPI / ATTRIBUTI
    private double gradazioneAlcolica;
    private double volume_cl;


    // 2. COSTRUTTORE
    public Bevanda (int idProdotto, String nome, double prezzo, String descrizione,
                    double gradazioneAlcolica, double volume_cl){
        super(idProdotto, nome, prezzo, descrizione);

        this.gradazioneAlcolica = gradazioneAlcolica;
        this.volume_cl = volume_cl;
    }


    // 3. GETTERS
    public double getGradazioneAlcolica(){
        return this.gradazioneAlcolica;
    }

    public double getVolume_cl(){
        return this.volume_cl;
    }

    // Nessun setter

}
