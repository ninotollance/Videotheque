import Modele.Auteur;
import Modele.FichierNumerique;
import audio.LecteurMp3;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Auteur auteurTest = new Auteur("Punk", "Daft");
        FichierNumerique albumTest = new FichierNumerique(
                "Test",
                auteurTest,
                LocalDate.of(2013, 5, 17),
                1,
                "MP3",
                85.4,
                74,
                "src/audio/prettyjohn1.mp3"
        );

        LecteurMp3 lecteur = new LecteurMp3(albumTest);
        lecteur.demarrer();
        Thread.sleep(3000);
        int positionEnMillisecondes = lecteur.getPosition();
        System.out.println("En cours ? " + lecteur.enCours());
        lecteur.arreter();
        System.out.println("Arrêté à " + positionEnMillisecondes / 1000 + " s");
    }
}