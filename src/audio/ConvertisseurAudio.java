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


        if (!album.getFormat().equalsIgnoreCase("MP3")) {
            throw new FichierAudioException("Cet album n'est pas au format MP3.");
        }


        File fichierEntree = album.getFichier();
        String cheminSortie = album.getChemin().replace(".mp3", ".aac");
        File fichierSortie = new File(cheminSortie);


        List<String> optionsFfmpeg = new ArrayList<>();
        optionsFfmpeg.add("-vn");
        optionsFfmpeg.add("-c:a");
        optionsFfmpeg.add("aac");
        optionsFfmpeg.add("-b:a");
        optionsFfmpeg.add("192k");

        int retourffmpeg = 1;
        try {
            retourffmpeg = Ffmpeg.convertir(fichierEntree, fichierSortie, optionsFfmpeg);
        } catch (IOException | InterruptedException e) {
            throw new FichierAudioException("La conversion n'a pas pu être lancée.");
        }

        if (retourffmpeg != 0) {
            throw new FichierAudioException("La conversion a échoué.");
        }

        album.setFormat("AAC");
        album.setChemin(cheminSortie);
        album.setTaille(fichierSortie.length() / (1024.0 * 1024.0));
    }
}
