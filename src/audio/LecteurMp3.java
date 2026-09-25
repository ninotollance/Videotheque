package audio;

import Exceptions.FichierAudioException;
import Modele.FichierNumerique;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LecteurMp3 implements Runnable {

    private FichierNumerique album;
    private volatile Player player;
    private Thread thread;

    @Override
    public void run() {
        try {

            FileInputStream fichier = new FileInputStream("");
            Player player = new Player(fichier);
            player.play;
        } catch (FichierAudioException e) {
            throw new RuntimeException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        System.out.println("");
    }
}
