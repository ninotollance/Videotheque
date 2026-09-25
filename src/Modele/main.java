package Modele;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class main {

    public static void main(String[] args) throws InterruptedException, JavaLayerException {

        Auteur test = new Auteur("Daft", "Punk");
        FichierNumerique albumTest = new FichierNumerique(
                "Random Access Memories",
                test,
                LocalDate.of(2013, 5, 17),
                1,
                "MP3",
                85.4,
                74,
                "src/audio/xx.mp3"
        );

        Player lecteur = new Player(albumTest);
        lecteur.play();
    }
}
