package juego;

import java.util.Random;

public class Dado {

	private Random r;
	private int maximo;
	
	public Dado(int n)
	{
		maximo = n;
		r = new Random();
	}
	
	public int tirar_dado() {		
		return r.nextInt(maximo) + 1;
	}
}
