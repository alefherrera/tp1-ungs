package juego;

import code.ListaTuplas;
import code.Tupla;

public class SyE {

	private ListaTuplas<String, Integer> jugadores;
	private Integer tamanio;
	private Elementos elementos;
	private Dado dado;
	private String g;

	public SyE(int n) throws Exception {// tamaño del tablero, donde n > 1
		if (n < 1)
			throw new Exception("el valor debe ser mayor a 1");
		tamanio = n;
		elementos = new Elementos();
		jugadores = new ListaTuplas<String, Integer>();
		dado = new Dado(6);
	}

	public String ganador() {// devuelve el nro de jugador ganador o 0 si no hay
		return g;
	}

	public void agregarSerpiente(int i, int j) throws Exception {// caigo de j a
																	// i, donde
																	// 1 < i < j
																	// < n
		if (i < 1 || j < 1 || i > j || i > tamanio || j > tamanio) {
			throw new Exception("valores incorrectos");
		}
		elementos.agregar(j, i);
	}

	public void agregarEscalera(int i, int j) throws Exception {// subo de i a
																// j, donde 1 <
																// i < j < n
		if (i < 1 || j < 1 || i > j || i > tamanio || j > tamanio) {
			throw new Exception("valores incorrectos");
		}
		elementos.agregar(i, j);
	}

	public void agregarJugador(String nombre) {
		jugadores.agregar(new Tupla<String, Integer>(nombre, 0));
	}

	public void jugar() {// tira los dos dados
		Integer avanza, posicionactual;
		Tupla<String, Integer> jugador;
		boolean hayganador = false;
		//mientras nadie haya ganado, va a seguir jugando
		while (!hayganador) {
			for (int i = 0; i < jugadores.tamaño(); i++) {
				avanza = dado.tirar_dado();
				jugador = jugadores.iesimo(i);
				posicionactual = jugador.getE2();
				// seteo la nueva posicion, si hay escalera o serpiente se mueve
				// a donde lo lleven, en el caso que no, avanza normalmente
				jugador.setE2(elementos.moverse(avanza + posicionactual));
				System.out.println("Jugador: " + jugador.getE1() + " Dado: "
						+ avanza + " PosicionActual: " + posicionactual
						+ " NuevaPosicion: " + jugador.getE2());
				hayganador = jugador.getE2() >= tamanio;
				if (hayganador) {
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
