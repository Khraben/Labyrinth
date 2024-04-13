package Juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class baseJuego extends JPanel {

    static int matriz[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 9, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 9, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    String tipo;
    int matrizGame[][];
    SeleccionNivel selecNiv = new SeleccionNivel();
    Personaje pj;

    public baseJuego(int[][] matriz, String tipo, int xfin, int yfin, JFrame ventana, int Npj) {
        this.matrizGame = matriz;
        this.tipo = tipo;
        CrearPJ(Npj);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pj.teclaPresionada(e, baseJuego.this, xfin, yfin, ventana);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    public static void iniciar(int[][] matriz, String tipo, int xfin, int yfin, String title, int Npj) {
        JFrame ventana = new JFrame(title);
        baseJuego game = new baseJuego(matriz, tipo, xfin, yfin, ventana, Npj);
        ventana.add(game);
        ventana.setSize(606, 635);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(baseJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ventana.repaint();
                }
            }
        };

        thread.start();
    }

    public static void main(String args[]) {
    }

    @Override
    public void paint(Graphics g) {
        if (tipo == "SIMPLE") {
            Simple entornoGame = new Simple(matrizGame);
            entornoGame.paint(g, this);
            pj.paint(g, this);
        }
        if (tipo == "MILLONARIA") {
            Millonaria entornoGame = new Millonaria(matrizGame);
            entornoGame.paint(g, this);
            pj.paint(g, this);
        }
        if (tipo == "LIBERTADORA") {
            Libertadora entornoGame = new Libertadora(matrizGame);
            entornoGame.paint(g, this);
            pj.paint(g, this);
        }
    }

    public void CrearPJ(int Npj) {
        if (Npj == 1) {
            pj = new Personaje("src\\Imagenes\\pj_1.png");
        }
        if (Npj == 2) {
            pj = new Personaje("src\\Imagenes\\pj_2.png");
        }
        if (Npj == 3) {
            pj = new Personaje("src\\Imagenes\\pj_3.png");
        }
    }
}
