package Modele;

import Modele.Abstract.Album;

import java.time.LocalDate;

public class FichierNumerique extends Album {

    private String format;
    private double taille;
    private int duree;

    public FichierNumerique(String nom, Auteur auteur, LocalDate annee, int quantite, String format, double taille, int duree) {
        super(nom, auteur, annee, quantite);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSupport() {
        return "Fichier Numérique";
    }

    @Override
    public String toString() {
        return  this.getSupport() + " " + this.getFormat() + " " + this.getTaille() + " Mo " + this.getDuree() + " min " + super.toString();
        /**return "Album{" +
         "nom='" + nom + '\'' +
         ", auteur=" + auteur +
         ", annee=" + annee +
         ", quantite=" + quantite +
         '}';*/
    }
}
