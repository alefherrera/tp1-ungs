package code;

import java.util.ArrayList;

public class ListaTuplas<E1, E2> {

	private ArrayList<Tupla<E1, E2>> lTuplas;

	public ListaTuplas() {
		lTuplas = new ArrayList<Tupla<E1, E2>>();
	}

	public void agregar(Tupla<E1, E2> tupla) {
		lTuplas.add(tupla);
	}

	public E2 buscar(E1 elem1) {

		E2 ret = null;
		for (int i = 0; i < lTuplas.size(); i++)
			if (lTuplas.get(i).getE1().equals(elem1))
				ret = lTuplas.get(i).getE2();
		return ret;

	}

	public int tamaño() {
		return lTuplas.size();
	}

	public Tupla<E1, E2> iesimo(int i) {
		return lTuplas.get(i);

	}

	public ListaTuplas<E1, E2> concat(ListaTuplas<E1, E2>... listas) {
		for (ListaTuplas<E1, E2> arg : listas) {
			for (int i = 0; i < arg.tamaño(); i++) {
				lTuplas.add(arg.iesimo(i));
			}
		}
		return this;
	}

	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < lTuplas.size(); i++)
			ret = ret + lTuplas.get(i).toString() + "\n";
		return ret;
	}

}
