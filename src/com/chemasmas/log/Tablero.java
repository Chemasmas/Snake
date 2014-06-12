package com.chemasmas.log;

public class Tablero {

	public static int filas;
	public static int columnas;
	
	public static int tab[][];
	
	public static final int VACIO=0;
	private static final int CABEZA=1;
	private static final int CUERPO=2;
	private static final int COLA=3;
	
	public static final int PRESA=9;
	
	public Tablero(int f,int c)
	{
		tab=new int[f][c];
		filas=f;
		columnas=c;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<filas;i++)
		{
			sb.append("{");
			for(int j=0;j<columnas;j++)
			{
				if(tab[i][j]!=0)
				{
				sb.append("[");
				sb.append(tab[i][j]);
				sb.append("]");
				}
				else
					sb.append("   ");
			}
			sb.append("}\n");
		}
        sb.append("-*-*-*-*-*-*-*-*-*-*-*-*-\n");
		return sb.toString();
	}
	
	public void colocarObjetos(Snake s,Presa pre)
	{
		tab=new int[filas][columnas];
		
		Punto p=pre.ub;
		
		tab[p.y][p.x]=PRESA;
//		p=s.vibora.get(0);
		for(int i=0;i<s.vibora.size();i++)
		{
			p=s.vibora.get(i);
			if(i==0)
			{
				//Colocar la Cabeza
				tab[p.y][p.x]=CABEZA;
			}else if(i==s.vibora.size()-1)
			{
				//Colocar la Cabeza
				tab[p.y][p.x]=COLA;
			}else
			{
				//Colocar la Cabeza
				tab[p.y][p.x]=CUERPO;
			}
		}
//		Teclado.activar();
	}
}
