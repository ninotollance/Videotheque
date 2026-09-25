package Modele;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import class Modele.FichierNumerique;

public class main {

    public static void main(String[] args) {

        Auteur test = new Auteur("Daft", "Punk");
        FichierNumerique albumTest = new FichierNumerique(
                "Get lucky",
                test,
                LocalDate.of(2013, 1, 1),
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
