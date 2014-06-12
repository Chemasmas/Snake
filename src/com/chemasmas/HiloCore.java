package com.chemasmas;

import com.chemasmas.gui.Ventana;
import com.chemasmas.listener.Teclado;
import com.chemasmas.log.Presa;
import com.chemasmas.log.Snake;
import com.chemasmas.log.Tablero;

public class HiloCore extends Thread {

	private final Snake sn;
	private final Tablero ta;
    static boolean dibujando=true;
	
	public static void Detener()
	{
		dibujando=false;
	}
	
	public void run()
	{
		while(dibujando)
		{
			try {
				Thread.sleep(500);
				avanzar();
				ta.colocarObjetos(Ventana.getSn(),Ventana.getP());
				Ventana.li.repaint();
                estado();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

    private void estado()
    {
        System.out.println("Tablero:\n"+Ventana.getTab());
        System.out.println("Vibora:\n"+ Ventana.getSn());
        System.out.println("Presa:\n"+ Ventana.getP());
        System.out.println("Dibujando:\n"+dibujando);
        System.out.println("Escuchando:\n"+ Teclado.activo);
    }

    private void avanzar() {
		sn.avanzar();
	}
	public HiloCore(Snake s,Presa p,Tablero t)
	{
		ta=t;
		sn=s;
        Presa pre = p;
	}
}

