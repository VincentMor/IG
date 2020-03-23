package GestinaireFigurant;

import java.util.ArrayList;

/**
 * figurant
 */
public class figurant {

    private String nom;
    private Srtring prenom;
    private Date DateNaissance;
    private String Cp;
    private String Sexe;
    private String CouleurCheveux;
    private String CouleurYeux;
    private ArrayList<String> Figurations;
    private boolean PratiqueTheatre;
    private boolean Pratique IntermittantDuSpectacle;
    private String nip;


    public figurant() {
    }
    

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Srtring getPrenom() {
        return this.prenom;
    }

    public void setPrenom(Srtring prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return this.DateNaissance;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getCp() {
        return this.Cp;
    }

    public void setCp(String Cp) {
        this.Cp = Cp;
    }

    public String getSexe() {
        return this.Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getCouleurCheveux() {
        return this.CouleurCheveux;
    }

    public void setCouleurCheveux(String CouleurCheveux) {
        this.CouleurCheveux = CouleurCheveux;
    }

    public String getCouleurYeux() {
        return this.CouleurYeux;
    }

    public void setCouleurYeux(String CouleurYeux) {
        this.CouleurYeux = CouleurYeux;
    }

    public ArrayList<String> getFigurations() {
        return this.Figurations;
    }

    public void setFigurations(ArrayList<String> Figurations) {
        this.Figurations = Figurations;
    }

    public boolean isPratiqueTheatre() {
        return this.PratiqueTheatre;
    }

    public boolean getPratiqueTheatre() {
        return this.PratiqueTheatre;
    }

    public void setPratiqueTheatre(boolean PratiqueTheatre) {
        this.PratiqueTheatre = PratiqueTheatre;
    }

    public Pratique getIntermittantDuSpectacle() {
        return this.IntermittantDuSpectacle;
    }

    public void setIntermittantDuSpectacle(Pratique IntermittantDuSpectacle) {
        this.IntermittantDuSpectacle = IntermittantDuSpectacle;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.nom+" "+this.prenom;
    }
    
}