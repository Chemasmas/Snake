package com.chemasmas;

import com.chemasmas.gui.Ventana;

class Principal {

	public static void main(String []args)
	{
		Ventana v=new Ventana(10,20);
		HiloCore hc=new HiloCore(Ventana.getSn(),Ventana.getP(),Ventana.getTab());
		
		hc.start();
	}
}
