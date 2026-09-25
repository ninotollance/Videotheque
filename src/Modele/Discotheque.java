package Modele;

import Exceptions.AlbumIntrouvableException;
import Exceptions.DiscothequeVideException;
import Exceptions.DoublonException;
import Exceptions.FichierAudioException;
import Modele.Abstract.Album;

import java.util.ArrayList;

public class Discotheque {
    private static ArrayList<Album> discotheque = new ArrayList<>();

    public static ArrayList<Album> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(ArrayList<Album> discotheque) {
        Discotheque.discotheque = discotheque;
    }

    public static void afficherDiscotheque() {
        System.out.println(getDiscotheque());
    }
    public static void viderDiscotheque() {
       getDiscotheque().clear();
        System.out.println("discotheque vidée!");
    }
    public static void ajouterAlbum(Album a) throws DoublonException {
        //TODO vérification si l'album existe déjà dans la discotheque et exception si c'est le cas
        //TODO ajouter album dans discotheque
        try {
            rechercherAlbum(a.getNom());

        } catch (DiscothequeVideException | AlbumIntrouvableException e) {
            discotheque.add(a);
            System.out.println(a + "ajouté avec succès !");
            return;
        }
        throw new DoublonException("Cette album exciste déjà !");
    }

    public static void listerAlbums() throws DiscothequeVideException {
        if (getDiscotheque().isEmpty()) {
            throw new DiscothequeVideException("Discothèque vide !");
        }
        for (Album a : getDiscotheque()) {
            System.out.println(a);
        }
    }

    public static Album rechercherAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException {
        if (getDiscotheque().isEmpty()) {
            throw new DiscothequeVideException("La discothèque est vide.");
        }
        for (Album a : getDiscotheque()) {
            if (a.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Album trouvé: " + a);
                return a;
            }
        }
        throw new AlbumIntrouvableException("Album introuvable: " + nom);
    }

    public static void supprimerAlbum(String nom) throws DiscothequeVideException, AlbumIntrouvableException {
        Album a = rechercherAlbum(nom);
        getDiscotheque().remove(a);
        System.out.println("Album supprimé de la discothèque: " + a);
    }

    public static FichierNumerique ecouterAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException, FichierAudioException {
        Album a = rechercherAlbum(nom);
        if (!(a instanceof FichierNumerique)) {
            throw new FichierAudioException("Ce fichier n'est pas lisible ! ");
        }
        return (FichierNumerique) a;
    }

}
