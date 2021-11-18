/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.pantalla;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import udemy.poo.interfaz.Actions;

/**
 *
 * @author eduardo
 */
public class Pantalla extends JPanel implements KeyListener, MouseListener {
    
    private ArrayList<Actions> componente = new ArrayList<>();
    private Timer tiempo;

    public Pantalla(Timer tiempo) {
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.tiempo = tiempo;
    }

    public ArrayList<Actions> getComponente() {
        return componente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        
        for (Actions action : componente) {
            action.calculo();
            action.pintar(g2);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int codigoTecla = e.getKeyCode();
        
        if(codigoTecla == KeyEvent.VK_P)
            tiempo.stop();
        else if(codigoTecla == KeyEvent.VK_R)
            tiempo.start();
        else if(codigoTecla == KeyEvent.VK_E)
            System.exit(0);
        
        for(Actions action : componente) {
            action.teclado(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Actions action : componente) {
            action.raton(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
