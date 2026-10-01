import Modele.Auteur;
import Modele.FichierNumerique;
import audio.ConvertisseurAudio;

import java.time.LocalDate;

public class Testconversion {
    public static void main(String[] args) {

        Auteur auteurTest = new Auteur("Punk", "Daft");
        FichierNumerique albumTest = new FichierNumerique(
                "Test",
                auteurTest,
                LocalDate.of(2013, 5, 17),
                1,
                "MP3",
                5.0,
                4,
                "src/audio/prettyjohn1.mp3"
        );

        System.out.println("Avant : " + albumTest);
        ConvertisseurAudio.mp3VersAac(albumTest);
        System.out.println("Après : " + albumTest);
    }
}
