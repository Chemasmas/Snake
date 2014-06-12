package com.chemasmas.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.chemasmas.log.Snake;

public class Teclado implements KeyListener {

	public static  boolean activo = true;
	
	public static void activar()
	{
		activo=true;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (activo)
		{
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
				//Asrriba
				Snake.Arriba();
				break;
			case KeyEvent.VK_DOWN:
				//Abajo
				Snake.Abajo();
				break;
			case KeyEvent.VK_LEFT:
				//Izquierda
				Snake.Izquierda();
				break;
			case KeyEvent.VK_RIGHT:
				//Derecha
				Snake.Derecha();
				break;
			case KeyEvent.VK_A:
				//IA
				break;
			case KeyEvent.VK_P:
				//Pausa
				break;
			}
			activo=false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
