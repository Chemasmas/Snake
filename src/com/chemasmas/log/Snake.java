package com.chemasmas.log;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.chemasmas.HiloCore;
import com.chemasmas.gui.Ventana;

public class Snake {
	// Defino a la vibora como una coleccion de Puntos
	public List<Punto> vibora;
	private static int direccion;

	private static final int ARRIBA = 1;
	private static final int ABAJO = 2;
	private static final int IZQUIERDA = 3;
	private static final int DERECHA = 4;

	public Snake(int f, int c) {
		// No me dan un punto de inicio, asi que empezare a la mitad del tablero
		Punto cabeza = new Punto();
		cabeza.y = f / 2;
		System.out.println(f + " " + cabeza.y);
		cabeza.x = c / 2;
		System.out.println(c + " " + cabeza.x);

		Punto cuerpo = new Punto();
		cuerpo.y = cabeza.y;
		cuerpo.x = cabeza.x - 1;

		Punto cola = new Punto();
		cola.y = cuerpo.y;
		cola.x = cuerpo.x - 1;

		// Esto es solo la primera vez
		vibora = new ArrayList<Punto>();
		vibora.add(cabeza);
		vibora.add(cuerpo);
		vibora.add(cola);
		// Esta viendo a la derecha
		direccion = DERECHA;
	}

	public void avanzar() {
		switch (direccion) {
		case ARRIBA:
			ArribaM();
			break;
		case ABAJO:
			AbajoM();
			break;
		case IZQUIERDA:
			IzquierdaM();
			break;
		case DERECHA:
			DerechaM();
			break;
		}
	}

	private boolean esVibora(Punto p) {
        return Tablero.tab[p.y][p.x] != Tablero.PRESA && Tablero.tab[p.y][p.x] != 0;
	}

	private boolean esComida(Punto p) {
        return Tablero.tab[p.y][p.x] == Tablero.PRESA;
	}

	private boolean validacion(Punto p) {
		return !(p.x < 0 || p.y < 0 || p.x > Tablero.columnas - 1 || p.y > Tablero.filas - 1 || esVibora(p));
	}

	private void FinDelJuego() {
		HiloCore.Detener();// Dejar de Avanzar
		JOptionPane.showMessageDialog(null, "Fin del Juego", "Fallaste!",
				JOptionPane.ERROR_MESSAGE);
	}

	private void ArribaM() {
		//Arriba
		Punto temp = vibora.get(0);// La antigua Cabeza
		Punto p = new Punto();
		p.x = temp.x;
		p.y = temp.y - 1;

		if (validacion(p)) {
			List<Punto> nueva = new ArrayList<Punto>();
			nueva.add(p);
			nueva.addAll(vibora);
			if (!esComida(p))
				nueva.remove(nueva.size() - 1);

			else {
				// Creamos una nueva Presa
				Ventana.setP(new Presa(Tablero.filas, Tablero.columnas));
			}

			vibora = nueva;
		} else {
			FinDelJuego();
		}
	}

	private void AbajoM() {
		//Abajo
		Punto temp = vibora.get(0);// La antigua Cabeza
		Punto p = new Punto();
		p.x = temp.x;
		p.y = temp.y + 1;

		if (validacion(p)) {
			List<Punto> nueva = new ArrayList<Punto>();
			nueva.add(p);
			nueva.addAll(vibora);

			if (!esComida(p))
				nueva.remove(nueva.size() - 1);

			else {
				// Creamos una nueva Presa
				Ventana.setP(new Presa(Tablero.filas, Tablero.columnas));
			}

			vibora = nueva;
		} else {
			FinDelJuego();
		}
	}

	private void DerechaM() {
		//Derecha
		Punto temp = vibora.get(0);// La antigua Cabeza
		Punto p = new Punto();
		p.x = temp.x + 1;
		p.y = temp.y;

		if (validacion(p)) {
			List<Punto> nueva = new ArrayList<Punto>();
			nueva.add(p);
			nueva.addAll(vibora);

			if (!esComida(p))
				nueva.remove(nueva.size() - 1);

			else {
				// Creamos una nueva Presa
				Ventana.setP(new Presa(Tablero.filas, Tablero.columnas));
			}

			vibora = nueva;
		} else {
			FinDelJuego();
		}
	}

	private void IzquierdaM() {
		//Izquierda
		Punto temp = vibora.get(0);// La antigua Cabeza
		Punto p = new Punto();
		p.x = temp.x - 1;
		p.y = temp.y;

		if (validacion(p)) {
			List<Punto> nueva = new ArrayList<Punto>();
			nueva.add(p);
			nueva.addAll(vibora);

			if (!esComida(p))
				nueva.remove(nueva.size() - 1);

			else {
				// Creamos una nueva Presa
				Ventana.setP(new Presa(Tablero.filas, Tablero.columnas));
			}

			vibora = nueva;
		} else {
			FinDelJuego();
		}
	}

	public static void Arriba() {
		if (direccion != ABAJO)
			direccion = ARRIBA;
	}

	public static void Abajo() {
		if (direccion != ARRIBA)
			direccion = ABAJO;
	}

	public static void Izquierda() {
		if (direccion != DERECHA)
			direccion = IZQUIERDA;
	}

	public static void Derecha() {
		if (direccion != IZQUIERDA)
			direccion = DERECHA;
	}

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Tamanio: ");
        sb.append(vibora.size());
        for(Punto p:vibora)
        {
            sb.append(p);
        }
        return sb.toString();
    }
}
