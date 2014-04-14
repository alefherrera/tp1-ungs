package juego;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SyE juego = new SyE(80);
		juego.agregarEscalera(20, 42);
		juego.agregarEscalera(4, 22);
		juego.agregarEscalera(5, 13);
		juego.agregarEscalera(10, 11);
		juego.agregarEscalera(12, 51);
		juego.agregarEscalera(17, 25);
		juego.agregarEscalera(54, 75);
		juego.agregarEscalera(58, 79);
		
		juego.agregarSerpiente(3, 41);
		juego.agregarSerpiente(6, 69);
		juego.agregarSerpiente(9, 44);
		juego.agregarSerpiente(24, 61);
		juego.agregarSerpiente(39, 78);
		juego.agregarSerpiente(28, 52);
		juego.agregarSerpiente(29, 71);
		juego.agregarSerpiente(46, 73);
		
		juego.agregarJugador("Ale");
		juego.agregarJugador("Ale2");
		juego.agregarJugador("Ale3");
		juego.jugar();
		System.out.println("GANADOR: " + juego.ganador() + "!");
		System.out.println("VER: "  + juego.ver());
	}
}
