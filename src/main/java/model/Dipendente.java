package model;

import model.enums.RuoloDipendente;

import java.util.Date;


public class Dipendente extends Persona{
    private String matricolaAziendale;
    private Date dataAssunzione;
    private RuoloDipendente ruolo;      // enum (Da impostare nel costruttore)

    // Dipendente (1) --- gestisce --- (0..*) Ordine
    // private List<Ordine> ordini = new ArrayList<>();

    public Dipendente (int idPersona, String nome, String cognome, String telefono,
                String matricolaAziendale, Date dataAssunzione, RuoloDipendente ruolo){
        super(idPersona, nome, cognome, telefono);

        this.matricolaAziendale = matricolaAziendale;
        this.dataAssunzione = dataAssunzione;
        this.ruolo = ruolo;
    }


}
