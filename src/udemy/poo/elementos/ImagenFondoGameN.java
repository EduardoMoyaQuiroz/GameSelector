/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.elementos;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import udemy.poo.interfaz.Actions;

/**
 *
 * @author eduardo
 */
public class ImagenFondoGameN implements Actions {
    
    private Image imagen = null;
    private Image imagenDos = null;
    private Component componente;
    private int x = -20;
    
    private static ImagenFondoGameN objetoUnico;
    private MediaTracker tracker;
    
    public static ImagenFondoGameN imagenFondo() {
        if(objetoUnico == null)
            objetoUnico = new ImagenFondoGameN();
        
        return objetoUnico;
    }
    
    private void ImagenFondo() {}
    
    public void configuracion(Component componente, String archivo, String personaje) {
        this.componente = componente;
        tracker = new MediaTracker(componente);
        Toolkit herram = Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + archivo));
        imagenDos = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + personaje));
        tracker.addImage(imagen, 1);
        tracker.addImage(imagenDos, 2);
        //tracker.addImage(imagenTres, 3);
        
        // Espera a que todas las imagenes sean cargadas
        try {
            tracker.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public void pintar(Graphics2D g2) {
        g2.drawImage(imagen, 0, 0, componente.getWidth(), componente.getHeight(), null);
        g2.drawImage(imagenDos, x + 860, 40, 300, 368, null);
    }

    @Override
    public void teclado(KeyEvent event) {
        
    }

    @Override
    public void raton(MouseEvent event) {
        
    }

    @Override
    public void calculo() {
        /*if(x > componente.getWidth() + 20)
            x =- 20;
        else
            x += 4;
        */
    }
    
}
