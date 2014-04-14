package juego;

import code.ListaTuplas;
import code.Tupla;

public class Elementos {
	private ListaTuplas<Integer,Integer> grupo;
	
	public Elementos()
	{
		grupo = new ListaTuplas<Integer,Integer>();
	}
	
	public void agregar(Integer i,Integer j)
	{
		grupo.agregar(new Tupla<Integer,Integer>(i,j));
	}
	
	public Integer moverse(Integer i)
	{
		Integer aux = grupo.buscar(i);
		return aux == null ? i : aux;
	}	
}
