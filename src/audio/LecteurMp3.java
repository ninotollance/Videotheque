import Exceptions.AlbumIntrouvableException;
import Exceptions.FichierAudioException;
import Modele.FichierNumerique;
import javazoom.jl.player.Player;

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
        thread.start();

    }

    @Override
    public void run() {
        try {
            java.io.FileInputStream fichier =
        }
    }
}
