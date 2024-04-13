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
public class Rocas {

    int x;
    int y;
    String imagenRocas;
    Image img;

    public Rocas(String img, int x, int y) {
        this.x = x;
        this.y = y;
        imagenRocas = img;
    }

    public Image imgRoca() {
        img = Toolkit.getDefaultToolkit().getImage(imagenRocas);
        return img;
    }

    public void paint(Graphics g, baseJuego game) {
        this.imgRoca();
        g.drawImage(img, x, y, game);
    }
}
