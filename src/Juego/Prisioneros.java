/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Juego.baseJuego;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author khrab
 */
public class Prisioneros {

    int x;
    int y;
    String imagenPrisioneros;
    Image img;

    public Prisioneros(String img, int x, int y) {
        this.x = x;
        this.y = y;
        imagenPrisioneros = img;
    }

    public Image imgPrisioneros() {
        img = Toolkit.getDefaultToolkit().getImage(imagenPrisioneros);
        return img;
    }

    public void paint(Graphics g, baseJuego game) {
        this.imgPrisioneros();
        g.drawImage(img, x, y, game);
    }
}
