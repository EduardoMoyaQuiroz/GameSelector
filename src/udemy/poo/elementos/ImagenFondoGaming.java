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
public class ImagenFondoGaming implements Actions {
    
    private Image imagen = null;
    private Component componente;
    private int x = -20;
    
    private static ImagenFondoGaming objetoUnico;
    private MediaTracker tracker;
    
    public static ImagenFondoGaming imagenFondo() {
        if(objetoUnico == null)
            objetoUnico = new ImagenFondoGaming();
        
        return objetoUnico;
    }
    
    private void ImagenFondo() {}
    
    public void configuracion(Component componente, String archivo) {
        this.componente = componente;
        tracker = new MediaTracker(componente);
        Toolkit herram = Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + archivo));
        tracker.addImage(imagen, 1);
        
        
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
