/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.interfaz;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author eduardo
 */
public interface Actions {
    
    public void pintar(Graphics2D g2);
    
    public void teclado(KeyEvent event);
    
    public void raton(MouseEvent event);
    
    public void calculo();
        
}
