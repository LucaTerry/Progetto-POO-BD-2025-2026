package model;

import java.util.Date;

public abstract class Persona {

    // 1. CAMPI / ATTRIBUTI
    private int idPersona;
    private String nome;
    private String cognome;
    private Date dataNascita;       //opzionale
    private String telefono;
    private String email;           //opzionale


    // 2. COSTRUTTORE
    public Persona(int idPersona, String nome, String cognome, String telefono){
        this.idPersona = idPersona;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }


    // 3. GETTERS
    public int getIdPersona(){
        return this.idPersona;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public Date getDataNascita(){
        return this.dataNascita;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getEmail(){
        return this.email;
    }


    // 4. SETTERS
    public void setDataNascita(Date dataNascita){
        this.dataNascita = dataNascita;
    }

    public void setEmail(String email){
        if(email.contains("@")){
            this.email = email;
        } else {
            System.out.println("ERRORE: non è un email.");
        }
    }

}
