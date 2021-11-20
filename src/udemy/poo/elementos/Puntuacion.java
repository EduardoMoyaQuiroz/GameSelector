/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.elementos;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JPanel;
import udemy.poo.interfaz.Actions;
import udemy.poo.modelo.Burbuja;

/**
 *
 * @author eduardo
 */
public class Puntuacion implements Actions {
    
    private JPanel panel;
    private int nave = 0;
    private int orbe = 0;

    public Puntuacion(JPanel panel) {
        this.panel = panel;
    }
        
    
    @Override
    public void pintar(Graphics2D g2) {
        g2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g2.drawString("Nave: " + nave, 0, 20);
        g2.drawString("Orbe: " + orbe, 600, 20);
    }

    @Override
    public void teclado(KeyEvent event) {
        
    }

    @Override
    public void raton(MouseEvent event) {
        
    }

    @Override
    public void calculo() {
        Burbujas burbujas = Burbujas.getBurbujas();
        
        if(burbujas.getElementos().size() > 1) {
            for(Burbuja elemento : burbujas.getElementos()) {
                if(elemento.getWhoDeleted().equals("nave")) {
                    nave += 1;
                }
                else if(elemento.getWhoDeleted().equals("orbe")) {
                    orbe += 1;
                }
            }
            
            Iterator iterador = burbujas.getElementos().iterator();
            
            while(iterador.hasNext()) {
                Burbuja objeto = (Burbuja) iterador.next();
                if (objeto.isEliminar()) {
                    iterador.remove();
                }
            }
        }
        else {
            burbujas.configurar(this.panel, "orbe.png");
        }
    }
    
}
