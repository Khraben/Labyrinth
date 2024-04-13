/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author khrab
 */
public class Personaje {

    int monedas = 0;
    int prisioneros = 0;
    int x = 40;
    int y = 40;
    String imagenPersonaje;
    Image img;

    public Personaje(String img) {
        imagenPersonaje = img;
    }

    public Image imgPersonaje() {
        img = Toolkit.getDefaultToolkit().getImage(imagenPersonaje);
        return img;
    }

    public void paint(Graphics g, baseJuego game) {
        this.imgPersonaje();
        g.drawImage(img, x, y, game);
    }

    public void teclaPresionada(KeyEvent e, baseJuego game, int xfin, int yfin, JFrame frame) {
        int[][] matriz = game.matrizGame;
        if (e.getKeyCode() == 37) {//izquierda
            if (matriz[y / 40][(x / 40) - 1] == 2) {
                matriz[y / 40][(x / 40) - 1] = 0;
                this.monedas += 1;
            }
            if (matriz[y / 40][(x / 40) - 1] == 3) {
                matriz[y / 40][(x / 40) - 1] = 0;
                this.prisioneros += 1;
            }

            if ((matriz[y / 40][(x / 40) - 1] == 9) & (matriz[y / 40][(x / 40) - 2] == 0)) {
                matriz[y / 40][(x / 40) - 1] = 0;
                matriz[y / 40][(x / 40) - 2] = 9;
            } else {
                if ((matriz[y / 40][(x / 40) - 1] != 1) & (matriz[y / 40][(x / 40) - 1] != 9)) {
                    x -= 40;
                }
            }
        }
        if (e.getKeyCode() == 39) {//derecha            
            if (matriz[y / 40][(x / 40) + 1] == 2) {
                matriz[y / 40][(x / 40) + 1] = 0;
                this.monedas += 1;
            }
            if (matriz[y / 40][(x / 40) + 1] == 3) {
                matriz[y / 40][(x / 40) + 1] = 0;
                this.prisioneros += 1;
            }

            if ((matriz[y / 40][(x / 40) + 1] == 9) & (matriz[y / 40][(x / 40) + 2] == 0)) {
                matriz[y / 40][(x / 40) + 1] = 0;
                matriz[y / 40][(x / 40) + 2] = 9;
            } else {
                if ((matriz[y / 40][(x / 40) + 1] != 1) & (matriz[y / 40][(x / 40) + 1] != 9)) {
                    x += 40;
                }
            }
        }
        if (e.getKeyCode() == 40) {//abajo
            if (matriz[(y / 40) + 1][x / 40] == 2) {
                matriz[(y / 40) + 1][x / 40] = 0;
                this.monedas += 1;
            }
            if (matriz[(y / 40) + 1][x / 40] == 3) {
                matriz[(y / 40) + 1][x / 40] = 0;
                this.prisioneros += 1;
            }

            if ((matriz[(y / 40) + 1][x / 40] == 9) & (matriz[(y / 40) + 2][x / 40] == 0)) {
                matriz[(y / 40) + 1][x / 40] = 0;
                matriz[(y / 40) + 2][x / 40] = 9;
            } else {
                if ((matriz[(y / 40) + 1][x / 40] != 1) & (matriz[(y / 40) + 1][x / 40] != 9)) {
                    y += 40;
                }
            }
        }
        if (e.getKeyCode() == 38) {//arriba
            if (matriz[(y / 40) - 1][x / 40] == 2) {
                matriz[(y / 40) - 1][x / 40] = 0;
                this.monedas += 1;
            }
            if (matriz[(y / 40) - 1][x / 40] == 3) {
                matriz[(y / 40) - 1][x / 40] = 0;
                this.prisioneros += 1;
            }
            if ((matriz[(y / 40) - 1][x / 40] == 9) & (matriz[(y / 40) - 2][x / 40] == 0)) {
                matriz[(y / 40) - 1][x / 40] = 0;
                matriz[(y / 40) - 2][x / 40] = 9;
            } else {
                if ((matriz[(y / 40) - 1][x / 40] != 1) & (matriz[(y / 40) - 1][x / 40] != 9)) {
                    y -= 40;
                }
            }
        }
        if (x == xfin && y == yfin) {
            if (game.tipo == "MILLONARIA") {
                JOptionPane.showMessageDialog(game, "Nivel Completado, has recogido " + game.pj.monedas + " monedas.");
                frame.dispose();
            }
            if (game.tipo == "LIBERTADORA") {
                JOptionPane.showMessageDialog(game, "Nivel Completado, has liberado " + game.pj.prisioneros + " prisioneros.");
                frame.dispose();
            }
            if (game.tipo == "SIMPLE") {
                JOptionPane.showMessageDialog(game, "Nivel Completado");
                frame.dispose();
            }

        }
    }
}
