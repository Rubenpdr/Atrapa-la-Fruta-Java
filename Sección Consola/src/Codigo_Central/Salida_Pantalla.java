package Codigo_Central;

import java.util.Scanner;

//ESTA CLASE CONTIENE TODO LO RELACIONADO CON LA SALIDA POR PANTALLA

//QUIZ�S RENTA M�S HACER UNA INTERFAZ ANTES QUE UNA CLASE COMO TAL
public class Salida_Pantalla {
	
	Scanner consola = new Scanner(System.in);

//Constructor vac�o
	public Salida_Pantalla() {}
	
//SELECTOR DE ESCENARIO Y DIFICULTAD DEL JUEGO
	public byte selector_esc() {
				
		System.out.println("Escoja el escenario que desea jugar empleando los n�meros 1 a 4:");
					
		System.out.println("Escenario 1");
		System.out.println("Escenario 2");
		System.out.println("Escenario 3");
		System.out.println("Escenario 4");
					
		byte selecci�n = consola.nextByte();
		return selecci�n;
	}
	
		
//Lore del escenario 1
	
//Lore del escenario 2
		
//Lore del escenario 3	
	
//Lore del escenario 4	
	
//Lore del escenario 5	
	
	

	
}



/*Cometario #1: La idea es que se muestre por consola (en un futuro por Interfaz Gr�fica) el 
 * t�tulo del juego "ATRAPA LA FRUTA" en un tama�o grande de letra, centrada en medio del cuadro
 * o consola, con un tipo de letra y color de letra distinto, y que debajo de este t�tulo salga
 * en peque�o: Pulse la tecla bla bla bla para continuar (estilo intro de pokemon).
 * Una vez le des te saldr� otra pantalla donde te contar� el Lore del Juego por encima,
 * que b�sicamente ir� de un cazador de bestias que visita la ciudad de Elleria para 
 * comprar medicinas para su moribunda hermana. Sin embargo, son muy caras, y deber� de cazar 
 * bestias por dinero para poder comprarlas. El Lore se ir� mostrando en el panel de inicio del 
 * juego, y antes de cada partida en un escenario, (deber�s de haber superado el anterior para poder acceder
 * a este),el juego te avanza un poco m�s de Lore. Recordar el nivel secreto cuando pases los
 * 5 escenario.*/



