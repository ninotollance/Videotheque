package main.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //TODO recuperer un fichier mp3

        Musique m = new Musique();
        Thread a = new Thread(m);
        a.start();
        //a.join(1000); // 1 seconde
        System.out.println("comment ça va ?");
    }
}
