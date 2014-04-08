package code;

public class Promocion {

	ListaTuplas<String,String> listaMateriales;
	ListaTuplas<String,Integer> listaPrecios;

	public Promocion(ListaTuplas<String,String> listaMateriales, ListaTuplas<String,Integer> listaPrecios){
		this.listaMateriales = listaMateriales;
		this.listaPrecios = listaPrecios;
	}

	ListaTuplas<String,String> resolver_ej1(){
		//implementar
		//Se debe pisar listaMateriales.
		return listaMateriales;
	}
	
	ListaTuplas<String,String> resolver_ej3(){
		//implementar
		//Se debe pisar listaMateriales.
		return listaMateriales;
	}
	
	
	@Override
	public String toString()
	{
		String ret = "";
		Integer precioM1=0;
		Integer precioM2=0;
		
		for (int i=0; i<listaMateriales.tamaño(); i++){
			precioM1 = listaPrecios.buscar(listaMateriales.iesimo(i).getE1());
			precioM2 = listaPrecios.buscar(listaMateriales.iesimo(i).getE2());
		
			if (precioM1 > precioM2){
				ret = ret + listaMateriales.iesimo(i).getE1().toString() +" "+ precioM1 + "\n";
			}else{
				ret = ret + listaMateriales.iesimo(i).getE2().toString() +" "+ precioM2 + "\n";				
			}
			//ret = ret + listaMateriales.iesimo(i).toString() + "\n";

		}
		return ret;
	}
	
}
