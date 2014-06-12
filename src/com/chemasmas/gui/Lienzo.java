package com.chemasmas.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import com.chemasmas.listener.Teclado;
import com.chemasmas.log.Tablero;

public class Lienzo extends Canvas {

	private static final Color FONDO = Color.cyan;

	private static final long serialVersionUID = 1L;
	private int ancho;
	private int alto;
	private final int wP;
    private final int hP;
	
	public Lienzo(int f,int c) {
		wP=20;
		hP=20;
		ancho= c*wP;
		alto=f*hP;
		setBounds(0, 0, ancho, alto);
	}

	public void paint(Graphics g) {
		g.setColor(FONDO);
		g.fillRect(0, 0, ancho, alto);
		if(Ventana.getTab()!=null)
		{
			for (int i = 0; i < Tablero.filas; i++) {
				for (int j = 0; j < Tablero.columnas; j++) {
					switch (Tablero.tab[i][j]) {
					case 0:
						g.setColor(FONDO);
						break;
					case 1:
						g.setColor(Color.red);
						break;
					case 2:
						g.setColor(Color.green);
						break;
					case 3:
						g.setColor(Color.blue);
						break;
					case 9: g.setColor(Color.black);
						break;
					}
					g.fillRect(j * wP, i * hP, wP, hP);
				}
			}
		}
		Teclado.activar();
	}
}
