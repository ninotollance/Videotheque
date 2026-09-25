import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Musique implements Runnable{
    @Override
    public void run() {
        try {
            FileInputStream fichier = new FileInputStream("src/main/resources/paintItBlack.mp3");
            Player player = new Player(fichier);
            player.play();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }
}
