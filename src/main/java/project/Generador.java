package project;

public class Generador{
	private static int lotActual=0;
	private static int producteActual = 0;
	private static int clientActual = 0;
	private static int proveidorActual = 0;
	private static int comandaActual = 0;
	
	public static int getNextLot() {
		return ++lotActual;
	}
	
	public static int getNextProducte() {
		return ++producteActual;
	}
	
	public static int getNextClient() {
		return ++clientActual;
	}

	public static int getNextComanda() {
		return ++comandaActual;
	}
	public static int getNextProveidor() {
		return ++proveidorActual;
	}
}
