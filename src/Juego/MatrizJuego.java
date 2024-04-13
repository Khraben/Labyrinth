/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author khrab
 */
public class MatrizJuego {

    int fila = 15;
    int columna = 15;
    final int anchoBloque = 40;
    final int altoBloque = 40;
    int matriz[][];

    public MatrizJuego(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }

}
