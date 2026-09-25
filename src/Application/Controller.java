package Application;

import Exceptions.*;
import Modele.*;
import Modele.Abstract.Album;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {

    public static Scanner scan = new Scanner(System.in);

    //TODO affichage du menu
    // Affiche le menu principal
    public void afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHEQUE =====");
        System.out.println("1. Ajouter un album");
        System.out.println("2. Lister tout les albums");
        System.out.println("3. Rechercher un album");
        System.out.println("4. Supprimer un album");
        System.out.println("4. Ecouter un album");
        System.out.println("4. Arrêter un album");
        System.out.println("4. Convertire un album");
        System.out.println("0. Quitter");
    }

    public Auteur saisieAuteur() throws SaisieInvalideException {
        Auteur a;
        scan.nextLine();

        System.out.print("saisissez le nom de l'auteur:");
        String nom = scan.nextLine();
        System.out.print("saisissez le prénom de l'auteur:");
        String prenom = scan.nextLine();

        if (nom.isEmpty()) {
            throw new SaisieInvalideException("Il faut remplir le champ nom");
        } else {
            a = new Auteur(nom, prenom);
        }
        return a;
    }

    public String saisieNomDisque() throws SaisieInvalideException {
        System.out.print("saisissez le nom de l'album:");
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new SaisieInvalideException("nom  de l'album  non saisi");
        }
        return nom;
    }

    public String saisieNumero() throws SaisieInvalideException {
        System.out.print("saisissez le numéro de série de l'album:");
        String numero = scan.nextLine();
        if (numero.isEmpty()) {
            throw new SaisieInvalideException("numéro de série de l'album  non saisi");
        }
        return numero;
    }

    public String saisieType() throws SaisieInvalideException {
        System.out.print("saisissez le type du CD (Simple ou Double):");
        String type = scan.nextLine();
        if (type.isEmpty()) {
            throw new SaisieInvalideException("type du CD  non saisi");
        }
        if (!type.equalsIgnoreCase("Simple") && !type.equalsIgnoreCase("Double")) {
            throw new SaisieInvalideException("Type du CD non valide, doit être Simple ou Double");
        }
        return type;
    }


    public int saisieTailleVinyle() throws SaisieInvalideException {
        System.out.print("saisissez la taille du vinyle (17, 25 ou 30):");

        int taille = scan.nextInt();
        scan.nextLine();
        if (taille != 17 && taille != 25 && taille != 30) {
            throw new SaisieInvalideException("Taille du vinyle non valide, doit être 17, 25 ou 30");
        }
        return taille;
    }

    public String saisieFormat() throws SaisieInvalideException {
        System.out.print("saisissez le format du fichier (mp3, flac, wav):");
        String format = scan.nextLine();
        if (format.isEmpty()) {
            throw new SaisieInvalideException("format de fichier non saisi");
        }
        if (!format.equalsIgnoreCase("mp3") && !format.equalsIgnoreCase("flac") && !format.equalsIgnoreCase("wav")) {
            throw new SaisieInvalideException("Format de fichier non valide, doit être mp3, flac ou wav");
        }
        return format;
    }

    public double saisieTailleFichier() throws SaisieInvalideException {
        System.out.print("saisissez la taille du fichier (en MO):");
        double taille = scan.nextDouble();
        scan.nextLine();
        if (taille <= 0) {
            throw new SaisieInvalideException("taille du fichier  non saisi");
        }
        return taille;
    }

    public int saisieDuree() throws SaisieInvalideException {
        System.out.print("saisissez la durée du fichier (en min):");
        int duree = scan.nextInt();
        scan.nextLine();
        if (duree < 0) {
            throw new SaisieInvalideException("durée du fichier non saisi");
        }
        return duree;
    }

    public int saisieQuantite() throws SaisieInvalideException {
        System.out.print("saisissez le nombre de disques/fichiers de l'album:");
        int duree = scan.nextInt();
        scan.nextLine();
        if (duree <= 0) {
            throw new SaisieInvalideException("L'album ne peut pas avoir une quantité nulle ou négative");
        }
        return duree;
    }

    public LocalDate saisieDate() throws DateFormatException {
        System.out.println("Saisissez la date de publication au format dd/mm/yyyy");
        String date = scan.nextLine();
        if(!date.matches("^\\d{2}/\\d{2}/\\d{4}$")){
            throw new DateFormatException("La date n'est pas au format dd/mm/yyyy");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public String saisieChemin() throws FichierAudioException {
        return
    }

    public CompactDisque creerCD () throws SaisieInvalideException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String numero = saisieNumero();
        String type = saisieType();


        CompactDisque cd = new CompactDisque(nom, a, date, quantite, numero, type );
        return cd;
    }

    public FichierNumerique creerFichierNumerique () throws SaisieInvalideException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String format = saisieFormat();
        double taille = saisieTailleFichier();
        int duree = saisieDuree();
        String chemin = saisieChemin();


        FichierNumerique fichierNumerique = new FichierNumerique(nom, a, date, quantite, format, taille, duree, chemin );
        return fichierNumerique;
    }

    public DisqueVinyle creerDisqueVinyle () throws SaisieInvalideException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        int taille = saisieTailleVinyle();
        String numero = saisieNumero();


        DisqueVinyle disqueVinyle = new DisqueVinyle(nom, a, date, quantite, numero, taille);
        return disqueVinyle;
    }

    public void ajouterAlbum() throws SaisieInvalideException, DoublonException {
        System.out.println("Type d'album (1 = CD, 2 = Vinyle, 3 = Fichier numérique) : ");
        int choix = scan.nextInt();

        Album created = null;
        switch (choix) {
            case 1:
                created = creerCD();
                break;
            case 2:
                created = creerDisqueVinyle();
                break;
            case 3:
                created = creerFichierNumerique();
                break;
            default:
                //message erreur
        }


        Discotheque.ajouterAlbum(created);
    }

    //TODO lister album
    public void listerAlbums() throws DiscothequeVideException {
        Discotheque.listerAlbums();
    }

    //TODO suppression album
    public void supprimerAlbumParNom() throws AlbumIntrouvableException, DiscothequeVideException, SaisieInvalideException {
        scan.nextLine();
        String n= saisieNomDisque();

    Discotheque.supprimerAlbum(n);
    }



    public void rechercherAlbum() throws DiscothequeVideException, AlbumIntrouvableException, SaisieInvalideException {
        scan.nextLine();
        String n= saisieNomDisque();

        Discotheque.rechercherAlbum(n);
    }
}
