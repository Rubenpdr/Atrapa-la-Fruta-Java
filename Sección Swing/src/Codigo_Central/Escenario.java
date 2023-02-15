package Codigo_Central;

import java.awt.Rectangle;						//Clase Rectangle que me permite crear cajas de colisión

import javax.swing.ImageIcon;

public class Escenario {
	
	//ATRIBUTOS
	public int ancho;							//Ancho del escenario en píxeles
	public int alto;							//Alto del escenario en píxeles
	public Elemento elementos[];				//Comentario #1
	
	//MÉTODOS
	
//Método Constructor
	public Escenario(int ancho,int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

//######################################### (Estos métodos me permiten agregrar elementos mediante sus constructores e indicando el índice de la posición que quiero que ocupen en el vector de elementos)

//Método agregar fruta 
	public void agregarFruta(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,String nombre,int puntos) {
		elementos[index] = new Fruta(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,nombre,puntos);
	}
	
//Método sobrecargado para agregar frutas mágicas
	public void agregarFruta(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		elementos[index] = new FrutaMagica(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,nombre,puntos,Desenfocar,Correr,Ralentizar);
	}
	
//Método para agregar personaje principal
	public void agregarPersonaje(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,int velocidad) {
		elementos[index]= new Personaje(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,velocidad);	
	}

//#########################################	
	
//Métodos getter
	public Elemento[] getElementos() {
		return elementos;	
	}	
	
	public Elemento[] getFrutas() {
		Elemento frutas[] = new Elemento[10];			//Doy un tamaño por defecto al vector de frutas
		int contador=0;
		for (int i=0 ; i<elementos.length ; i++) {		//Recorro todos los elementos y, si el símbolo de estos corresponde con el de una fruta,almaceno la fruta en el vector
			if(elementos[i].getSimbolo() =='D' || elementos[i].getSimbolo()=='P' || elementos[i].getSimbolo()=='V' || elementos[i].getSimbolo()=='G' || elementos[i].getSimbolo()=='H') {;	
				frutas[contador] = elementos[i];
				contador++;
			}
		}
		return frutas;
	}
	
	public Personaje getProtagonista() {
		Personaje protagonista = (Personaje) elementos[0];		//Dado que siempre almaceno el protagonista en la posición "0", este método me devuelve el protagonista
		return protagonista;
	}
	
//Método getter para el rectángulo que rodea los elementos
	public Rectangle getCajaColision(Elemento elemento) {			//Comentario #2
		return new Rectangle(elemento.getPosicionX(),elemento.getPosicionY(),elemento.getAncho()-30,elemento.getAlto()-5);
	}	

	
//Método para seleccionar escenario
	public void seleccionEscenario(int selección) {			//En base a el tipo de escenario y haciendo uso de los métodos para agregar elementos, creo todos los elementos del escenario.
		if(selección == 1) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,5,305,new ImageIcon("Imagenes/Protagonista.png"),'O',1);			
			agregarFruta(1,300,450,new ImageIcon("Imagenes/FrutaDragón.png"),'D',"Dragon",100);
			agregarFruta(2,720,320,new ImageIcon("Imagenes/FrutaPlateada.png"),'P',"Plateada",200);
		}
		
		else if(selección == 2) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,240,420,new ImageIcon("Imagenes/FrutaDorada.png"),'G',"Dorada",300,false,true,false);
			agregarFruta(2,799,430,new ImageIcon("Imagenes/FrutaVenenosa.png"),'V',"Venenosa",-100,false,false,true);
		}
				
		else if(selección == 3) {
			elementos = new Elemento[2];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,200,460,new ImageIcon("Imagenes/FrutaHarryPotter.png"),'H',"Harry Potter",-50,true,false,false);
		}
			
		else if(selección == 4) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,240,430,new ImageIcon("Imagenes/FrutaDragón.png"),'D',"Dragon",100);
			agregarFruta(2,560,50,new ImageIcon("Imagenes/FrutaPlateada.png"),'P',"Plateada",200);
		}
			
		else {}
	}

//Método para vaciar el escenario
	public void limpiarEscenario() {
		for(int t=0 ; t<elementos.length ; t++) {
			elementos[t].imagen = null;						//Dejamos la imagen de la fruta como nula, puesto que es objeto ImageIcon
		}
	}
	
//Método para devolver el Lore del comienzo
	public String toStringLore() {							//Este método me devuelve en formato String el Lore que se muestra previamente a la selección de escenarios
		return("ATRAPA LA FRUTA\n\"Bienvenido al emocionante juego de 'Atrapa la fruta'. Durante esta breve aventura,\r\n"
				+ "tu objetivo será recorrer las diferentes regiones del bosque de Elleria, con el fin de encontrar\r\n"
				+ "las frutas que el doctor Loufthy te encomendó recoger. Cuantas más frutas consigas, tu recompensa\r\n"
				+ "será mayor.\r\n"
				+ "Pero ten cuidado, algunas de estas frutas tienen poderes sobrenaturales, que deberás de registrar para\r\n"
				+ "ayudar al doctor con sus investigaciones.\r\n"
				+ "Mucha suerte");	
	}
}



//COMENTARIOS

/*Comentario #1: Este vector de objetos de tipo elementos será el encargado de almacenar
 * los distintos símbolos asociados a cada elemento, ya sea un personaje o una fruta.
 * El objetivo será que esta clase Escenario cree y almacene los objetos de tipo Fruta
 * y Personaje que heredan de la clase abstracta Elemento.*/

/*Comentario #2: Todos los elmentos del juego tendrán una caja de colisión donde se encuentran encerrados. Esta caja se va a crear empleando 
 * la clase Rectangle, donde, indicando la posición X e Y, el ancho y el alto(que son los atributos del elemento al que asociamos la caja),
 * podemos realizar comparativas para ver si ha existido colisión entre cajas, permitiendo esto la interacción entre elementos.*/

 

