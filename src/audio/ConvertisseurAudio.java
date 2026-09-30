package audio;

import Exceptions.FichierAudioException;
import Modele.FichierNumerique;
import outils.Ffmpeg;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertisseurAudio {

    public static void mp3VersAac(FichierNumerique album) {

        // Étape 1 : on vérifie que l'album est bien un MP3
        if (!album.getFormat().equalsIgnoreCase("MP3")) {
            throw new FichierAudioException("Cet album n'est pas au format MP3.");
        }

        // Étape 2 : on prépare le fichier d'entrée et le fichier de sortie
        File fichierEntree = album.getFichier();
        String cheminSortie = album.getChemin().replace(".mp3", ".aac");
        File fichierSortie = new File(cheminSortie);

        // Étape 3 : on prépare les réglages de ffmpeg
        List<String> optionsFfmpeg = new ArrayList<>();
        optionsFfmpeg.add("-vn");
        optionsFfmpeg.add("-c:a");
        optionsFfmpeg.add("aac");
        optionsFfmpeg.add("-b:a");
        optionsFfmpeg.add("192k");

        // Étape 4 : on lance la conversion
        int retourffmpeg = 1;
        try {
            retourffmpeg = Ffmpeg.convertir(fichierEntree, fichierSortie, optionsFfmpeg);
        } catch (IOException | InterruptedException e) {
            throw new FichierAudioException("La conversion n'a pas pu être lancée.");
        }

        // Étape 5 : on vérifie que tout s'est bien passé (0 = succès)
        if (retourffmpeg != 0) {
            throw new FichierAudioException("La conversion a échoué.");
        }

        // Étape 6 : on met à jour l'album
        album.setFormat("AAC");
        album.setChemin(cheminSortie);
        album.setTaille(fichierSortie.length() / (1024.0 * 1024.0));
    }
}
