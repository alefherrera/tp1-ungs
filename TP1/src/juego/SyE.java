package juego;

import code.ListaTuplas;
import code.Tupla;

public class SyE {

	public ListaTuplas<String, Integer> jugadores;
	private Integer tamanio;
	private Elementos elementos;
	private Dado dado;
	private String g;

	public SyE(int n) {// tamaño del tablero, donde n > 1
		tamanio = n;
		elementos = new Elementos();
		jugadores = new ListaTuplas<String, Integer>();
		dado = new Dado(6);
	}

	public String ganador() {// devuelve el nro de jugador ganador o 0 si no hay
		return g;
	}

	public void agregarSerpiente(int i, int j) {// caigo de j a i, donde 1 < i <
												// j < n
		elementos.agregar(i, j);
	}

	public void agregarEscalera(int i, int j) {// subo de i a j, donde 1 < i < j
												// < n
		elementos.agregar(i, j);
	}

	public void agregarJugador(String nombre) {
		jugadores.agregar(new Tupla<String,Integer>(nombre,0));
	}

	public void jugar() {// tira los dos dados
		Integer avanza, posicionactual;
		Tupla<String,Integer> jugador;
		boolean hayganador = false;
		
		while (!hayganador)
		{		
			for (int i = 0; i < jugadores.tamaño(); i++) {
				avanza = dado.tirar_dado();
				jugador = jugadores.iesimo(i);
				posicionactual = jugador.getE2();
				jugador.setE2(elementos.moverse(avanza + posicionactual));
				System.out.println("Jugador: " + jugador.getE1() + " Dado: " + avanza 
						+ " PosicionActual: " + posicionactual + " NuevaPosicion: " + jugador.getE2());
				hayganador = jugador.getE2() >= tamanio;
				if (hayganador)
				{
					g = jugador.getE1();
					return;
				}
			}
		}
		
		
	}

	public String ver() {// muestra el estado del tablero y los jugadores
		StringBuilder str = new StringBuilder();
		Tupla<String, Integer> aux;
		for (int i = 0; i < jugadores.tamaño(); i++) {
			aux = jugadores.iesimo(i);
			str.append(aux.getE1() + ": " + aux.getE2() + "\n");
		}
		return str.toString();
	}

}
