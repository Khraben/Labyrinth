/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author khrab
 */
public class Millonaria extends MatrizJuego {

    public Millonaria(int[][] matriz) {
        super(matriz);
    }

    public void paint(Graphics g, baseJuego game) {
        for (fila = 0; fila < matriz.length; fila++) {
            for (columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == 1) {
                    g.setColor(Color.red);
                    g.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                    g.setColor(Color.black);
                    g.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                } else {
                    g.setColor(Color.lightGray);
                    g.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                    if (matriz[fila][columna] == 2) {//monedas
                        Monedas moneda = new Monedas("src\\Imagenes\\moneda.png", columna * 40, fila * 40);
                        moneda.paint(g, game);
                    }
                    if(matriz[fila][columna] == 9){
                        Rocas roca = new Rocas("src\\Imagenes\\roca.png", columna * 40, fila * 40);
                        roca.paint(g, game);
                    }
                }

            }
        }
    }
}
