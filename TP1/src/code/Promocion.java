package code;

public class Promocion {

	ListaTuplas<String, String> listaMateriales;
	ListaTuplas<String, Integer> listaPrecios;

	public Promocion(ListaTuplas<String, String> listaMateriales,
			ListaTuplas<String, Integer> listaPrecios) {
		this.listaMateriales = listaMateriales;
		this.listaPrecios = listaPrecios;
	}

	// INSERTION SORT
	ListaTuplas<String, String> resolver_ej1() {
		// implementar
		// Se debe pisar listaMateriales.
		String nombretmp;
		Integer preciotmp;
		for (int i = 1; i < listaPrecios.tamaño(); i++) {

			nombretmp = listaPrecios.iesimo(i).getE1();
			preciotmp = listaPrecios.iesimo(i).getE2();

			for (int j = i; j > 0; j--) {
				if (listaPrecios.iesimo(j).getE2() < listaPrecios.iesimo(j - 1)
						.getE2()) {
					break;
				}
				listaPrecios.iesimo(j)
						.setE1(listaPrecios.iesimo(j - 1).getE1());
				listaPrecios.iesimo(j)
						.setE2(listaPrecios.iesimo(j - 1).getE2());

				listaPrecios.iesimo(j - 1).setE1(nombretmp);
				listaPrecios.iesimo(j - 1).setE2(preciotmp);

			}
		}

		listaMateriales = new ListaTuplas<String, String>();
		for (int i = 0; i < listaPrecios.tamaño(); i += 2) {
			listaMateriales.agregar(new Tupla<String, String>(listaPrecios
					.iesimo(i).getE1(), listaPrecios.iesimo(i + 1).getE1()));
		}

		return listaMateriales;
	}

	// BUBBLE SORT
	ListaTuplas<String, String> resolver_ej3() {
		String nombretmp;
		Integer preciotmp;
		for (int i = 1; i < listaPrecios.tamaño(); i++) {
			// Si no se hacen cambios en la vuelta, esta ordenado y corto el for
			Boolean ordenado = true;
			for (int j = 1; j < listaPrecios.tamaño(); j++) {
				if (listaPrecios.iesimo(j).getE2() > listaPrecios.iesimo(j - 1)
						.getE2()) {
					nombretmp = listaPrecios.iesimo(j).getE1();
					preciotmp = listaPrecios.iesimo(j).getE2();

					listaPrecios.iesimo(j).setE1(
							listaPrecios.iesimo(j - 1).getE1());
					listaPrecios.iesimo(j).setE2(
							listaPrecios.iesimo(j - 1).getE2());

					listaPrecios.iesimo(j - 1).setE1(nombretmp);
					listaPrecios.iesimo(j - 1).setE2(preciotmp);
					ordenado = false;
				}
			}
			if (ordenado) {
				break;
			}
		}

		listaMateriales = new ListaTuplas<String, String>();
		for (int i = 0; i < listaPrecios.tamaño(); i += 2) {
			listaMateriales.agregar(new Tupla<String, String>(listaPrecios
					.iesimo(i).getE1(), listaPrecios.iesimo(i + 1).getE1()));
		}

		return listaMateriales;
	}

	//QUICK SORT
	ListaTuplas<String, String> resolver_ej1v2() {

		listaPrecios = quicksort(listaPrecios);

		System.out.print(listaPrecios.toString());

		listaMateriales = new ListaTuplas<String, String>();
		for (int i = 0; i < listaPrecios.tamaño(); i += 2) {
			listaMateriales.agregar(new Tupla<String, String>(listaPrecios
					.iesimo(i).getE1(), listaPrecios.iesimo(i + 1).getE1()));
		}

		return listaMateriales;
	}

	ListaTuplas<String, Integer> quicksort(ListaTuplas<String, Integer> lista) {
		System.out.print(lista.tamaño());
		if (lista.tamaño() <= 1) {
			return lista;
		}

		Integer ipivot = (lista.tamaño() - 1) / 2;

		ListaTuplas<String, Integer> menor = new ListaTuplas<String, Integer>();
		ListaTuplas<String, Integer> mayor = new ListaTuplas<String, Integer>();
		ListaTuplas<String, Integer> pivot = new ListaTuplas<String, Integer>();

		pivot.agregar(lista.iesimo(ipivot));

		for (int i = 0; i < lista.tamaño(); i++) {
			if (lista.iesimo(i).getE2() < lista.iesimo(ipivot).getE2()) {
				menor.agregar(lista.iesimo(i));
			} else if (lista.iesimo(i).getE2() > lista.iesimo(ipivot).getE2()) {
				mayor.agregar(lista.iesimo(i));
			}
		}
		ListaTuplas<String, Integer> concat = new ListaTuplas<String, Integer>();

		return concat.concat(quicksort(menor), pivot, quicksort(mayor));
	}

	@Override
	public String toString() {
		String ret = "";
		Integer precioM1 = 0;
		Integer precioM2 = 0;

		for (int i = 0; i < listaMateriales.tamaño(); i++) {
			precioM1 = listaPrecios.buscar(listaMateriales.iesimo(i).getE1());
			precioM2 = listaPrecios.buscar(listaMateriales.iesimo(i).getE2());

			if (precioM1 > precioM2) {
				ret = ret + listaMateriales.iesimo(i).getE1().toString() + " "
						+ precioM1 + "\n";
			} else {
				ret = ret + listaMateriales.iesimo(i).getE2().toString() + " "
						+ precioM2 + "\n";
			}
			// ret = ret + listaMateriales.iesimo(i).toString() + "\n";

		}
		return ret;
	}

}
