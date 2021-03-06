/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.sonido;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author eduardo
 */
public class EfectosDeMusica implements Runnable {
    
    private BufferedInputStream buffer = null;
    private FileInputStream archivo;
    private Player player = null;

    public EfectosDeMusica(String archivo) {
        try {
            this.archivo = new FileInputStream(this.getClass().getResource("/udemy/poo/musica/" + archivo).toURI().getPath());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try {
            buffer = new BufferedInputStream(archivo);
            player = new Player(archivo);
            player.play();
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        }
    }
        
}
