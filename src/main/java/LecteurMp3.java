package audio;

import Exceptions.FichierAudioException;
import Modele.FichierNumerique;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LecteurMp3 implements Runnable {

    private final FichierNumerique album;
    private volatile Player player;
    private Thread thread;

    public LecteurMp3(FichierNumerique album) throws FichierAudioException {
        if (!album.getFormat().equalsIgnoreCase("MP3")) {
            throw new FichierAudioException("Le format n'est pas un MP3");
        }
        if (!album.getFichier().exists()) {
            throw new FichierAudioException("Fichier introuvable : " + album.getChemin());
        }
        this.album = album;
    }

    public void demarrer() {
        if (thread != null && thread.isAlive()) {
            return;
        }
        thread = new Thread(this);
        thread.setName("Lecteur-" + album.getNom());
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] lecture de " + album.getNom() + " ");
        try (BufferedInputStream flux = new BufferedInputStream(new FileInputStream(album.getFichier()))) {
            player = new Player(flux);
            player.play();
        } catch (IOException | JavaLayerException e) {
            System.out.println("!! Erreur : " + e.getMessage());
        }
        System.out.println("[" + Thread.currentThread().getName() + "] fin de lecture");
    }

    public void stop() {
        if(player != null) {
            player.close();
        }
    }




}
