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
public class Monedas {

    int x;
    int y;
    String imagenMonedas;
    Image img;

    public Monedas(String img, int x, int y) {
        this.x = x;
        this.y = y;
        imagenMonedas = img;
    }

    public Image imgMoneda() {
        img = Toolkit.getDefaultToolkit().getImage(imagenMonedas);
        return img;
    }

    public void paint(Graphics g, baseJuego game) {
        this.imgMoneda();
        g.drawImage(img, x, y, game);
    }
}
