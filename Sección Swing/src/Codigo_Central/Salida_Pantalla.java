package Codigo_Central;

import java.util.Scanner;

//ESTA CLASE CONTIENE TODO LO RELACIONADO CON LA SALIDA POR PANTALLA

//QUIZÁS RENTA MÁS HACER UNA INTERFAZ ANTES QUE UNA CLASE COMO TAL
public class Salida_Pantalla {
	
	Scanner consola = new Scanner(System.in);
//Constructor 
	public Salida_Pantalla() {
	}
	
//################################################################	

	//PRESENTACIÓN DEL JUEGO
	public String presentacion() {
		return("ATRAPA LA FRUTA\n Bienvenido al emocionante juego de 'Atrapa la fruta'. Durante esta breve aventura,"
				+ "tu objetivo será recorrer las diferentes regiones del bosque encantado de Elleria, con el fin de encontrar"
				+ "las frutas que el doctor Loufthy te encomendó recoger.\nCuantas más frutas consigas, tu recompensa"
				+ "será mayor.\n"
				+ "Pero ten cuidado, algunas de estas frutas tienen poderes sobrenaturales, que deberás de registrar para\n"
				+ "ayudar al doctor con sus investigaciones.Mucha suerte\n\n"
				+ "ESCRIBE '5' PARA SELECCIONAR EL NIVEL");

	}
	
//SELECTOR DE ESCENARIO
	public byte selector_esc() {
				
		System.out.println("Escoja el escenario que desea jugar empleando los números 1 a 4:");
					
		System.out.println("Escenario 1");
		System.out.println("Escenario 2");
		System.out.println("Escenario 3");
		System.out.println("Escenario 4");
					
		byte selección = consola.nextByte();
		return selección;
	}
	
		
//Lore del escenario 1
	
//Lore del escenario 2
		
//Lore del escenario 3	
	
//Lore del escenario 4	
	
//Lore del escenario 5	
	
	

	
}



/*Cometario #1: La idea es que se muestre por consola (en un futuro por Interfaz Gráfica) el 
 * título del juego "ATRAPA LA FRUTA" en un tamaño grande de letra, centrada en medio del cuadro
 * o consola, con un tipo de letra y color de letra distinto, y que debajo de este título salga
 * en pequeño: Pulse la tecla bla bla bla para continuar (estilo intro de pokemon).
 * Una vez le des te saldrá otra pantalla donde te contará el Lore del Juego por encima,
 * que básicamente irá de un cazador de bestias que visita la ciudad de Elleria para 
 * comprar medicinas para su moribunda hermana. Sin embargo, son muy caras, y deberá de cazar 
 * bestias por dinero para poder comprarlas. El Lore se irá mostrando en el panel de inicio del 
 * juego, y antes de cada partida en un escenario, (deberás de haber superado el anterior para poder acceder
 * a este),el juego te avanza un poco más de Lore. Recordar el nivel secreto cuando pases los
 * 5 escenario.*/



