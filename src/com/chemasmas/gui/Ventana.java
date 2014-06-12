package com.chemasmas.gui;

import javax.swing.*;

import com.chemasmas.listener.Teclado;
import com.chemasmas.log.Presa;
import com.chemasmas.log.Snake;
import com.chemasmas.log.Tablero;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static Tablero tab;
	private static Snake sn;
	private static Presa p;
    public static Lienzo li;
	
	public Ventana(int f, int c)
	{
		//Unicamente es un Listener Para la Ventana
		super();
		setVisible(true);
        Teclado kb = new Teclado();
        this.addKeyListener(kb);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		this.setSize(60, 60);
		
		
		setTitle("ChemaSNAKE");
		
		setTab(new Tablero(f, c));
		setP(new Presa(f, c));
		setSn(new Snake(f, c));
		li=new Lienzo(f,c);
		
		add(li);
		li.addKeyListener(kb);
		getTab().colocarObjetos(getSn(),getP());
		
		pack();
	}

	public static Snake getSn() {
		return sn;
	}

	public static void setSn(Snake sn) {
		Ventana.sn = sn;
	}

	public static Presa getP() {
		return p;
	}

	public static void setP(Presa p) {
		Ventana.p = p;
	}

	public static Tablero getTab() {
		return tab;
	}

	public static void setTab(Tablero tab) {
		Ventana.tab = tab;
	}
}
