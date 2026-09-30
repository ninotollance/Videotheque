package audio;

import Exceptions.FichierAudioException;
import Modele.FichierNumerique;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileNotFoundException;

public class LecteurMp3 implements Runnable {

    private FichierNumerique album;
    private volatile Player lecteurmp3;
    private Thread thread;

    public LecteurMp3(FichierNumerique album) {

        if (!album.getFormat().equalsIgnoreCase("MP3")) {
            throw new FichierAudioException("Le fichier n'est pas au bon format!");
        }
        if (!album.getFichier().exists()) {
            throw new FichierAudioException("Le fichier audio est introuvable");
        }

        this.album = album;

    }

    public void demarrer() {

        thread = new Thread(this);
        thread.setName("Lecteur-" + album.getNom());
        thread.setDaemon(true);
        thread.start();

    }

    @Override
    public void run() {

        try {
            java.io.FileInputStream fichier = new java.io.FileInputStream(album.getFichier());
            lecteurmp3 = new Player(fichier);
            lecteurmp3.play();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable!");
        } catch (JavaLayerException e) {
            System.out.println("Impossible de lire le fichier!");
        }

    }

    public void arreter() {

        if (lecteurmp3 != null) {
            lecteurmp3.close();
        }
    }

    public boolean enCours() {

        return thread != null && thread.isAlive();
    }

    public int getPosition() {

        if (lecteurmp3 == null) {
            return 0;
        }
        return lecteurmp3.getPosition();
    }
}
