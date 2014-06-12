package com.chemasmas.log;

public class Presa {

	final Punto ub;

	public Presa(int f, int c) {
		ub = new Punto();
		ub.y = (int) (f * Math.random());
		ub.x = (int) (c * Math.random());
		//Solo debe de caer en celdas Vacias
		while (Tablero.tab[ub.y][ub.x] != 0) {
			// Me aseguro que no me desborden
			while (ub.y == f)
				ub.y = (int) (f * Math.random());
			while (ub.x == c)
				ub.x = (int) (c * Math.random());
		}
	}

    @Override
    public String toString() {
        return ub.toString();
    }
}
