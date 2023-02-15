package Codigo_Central;

import java.awt.Rectangle;						//Clase Rectangle que me permite crear cajas de colisi�n

import javax.swing.ImageIcon;

public class Escenario {
	
	//ATRIBUTOS
	public int ancho;							//Ancho del escenario en p�xeles
	public int alto;							//Alto del escenario en p�xeles
	public Elemento elementos[];				//Comentario #1
	
	//M�TODOS
	
//M�todo Constructor
	public Escenario(int ancho,int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

//######################################### (Estos m�todos me permiten agregrar elementos mediante sus constructores e indicando el �ndice de la posici�n que quiero que ocupen en el vector de elementos)

//M�todo agregar fruta 
	public void agregarFruta(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,String nombre,int puntos) {
		elementos[index] = new Fruta(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,nombre,puntos);
	}
	
//M�todo sobrecargado para agregar frutas m�gicas
	public void agregarFruta(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		elementos[index] = new FrutaMagica(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,nombre,puntos,Desenfocar,Correr,Ralentizar);
	}
	
//M�todo para agregar personaje principal
	public void agregarPersonaje(int index,int posicionX,int posicionY,ImageIcon imagen,char simbolo,int velocidad) {
		elementos[index]= new Personaje(posicionX,posicionY,(int)imagen.getIconWidth(),(int)imagen.getIconHeight(),imagen,simbolo,velocidad);	
	}

//#########################################	
	
//M�todos getter
	public Elemento[] getElementos() {
		return elementos;	
	}	
	
	public Elemento[] getFrutas() {
		Elemento frutas[] = new Elemento[10];			//Doy un tama�o por defecto al vector de frutas
		int contador=0;
		for (int i=0 ; i<elementos.length ; i++) {		//Recorro todos los elementos y, si el s�mbolo de estos corresponde con el de una fruta,almaceno la fruta en el vector
			if(elementos[i].getSimbolo() =='D' || elementos[i].getSimbolo()=='P' || elementos[i].getSimbolo()=='V' || elementos[i].getSimbolo()=='G' || elementos[i].getSimbolo()=='H') {;	
				frutas[contador] = elementos[i];
				contador++;
			}
		}
		return frutas;
	}
	
	public Personaje getProtagonista() {
		Personaje protagonista = (Personaje) elementos[0];		//Dado que siempre almaceno el protagonista en la posici�n "0", este m�todo me devuelve el protagonista
		return protagonista;
	}
	
//M�todo getter para el rect�ngulo que rodea los elementos
	public Rectangle getCajaColision(Elemento elemento) {			//Comentario #2
		return new Rectangle(elemento.getPosicionX(),elemento.getPosicionY(),elemento.getAncho()-30,elemento.getAlto()-5);
	}	

	
//M�todo para seleccionar escenario
	public void seleccionEscenario(int selecci�n) {			//En base a el tipo de escenario y haciendo uso de los m�todos para agregar elementos, creo todos los elementos del escenario.
		if(selecci�n == 1) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,5,305,new ImageIcon("Imagenes/Protagonista.png"),'O',1);			
			agregarFruta(1,300,450,new ImageIcon("Imagenes/FrutaDrag�n.png"),'D',"Dragon",100);
			agregarFruta(2,720,320,new ImageIcon("Imagenes/FrutaPlateada.png"),'P',"Plateada",200);
		}
		
		else if(selecci�n == 2) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,240,420,new ImageIcon("Imagenes/FrutaDorada.png"),'G',"Dorada",300,false,true,false);
			agregarFruta(2,799,430,new ImageIcon("Imagenes/FrutaVenenosa.png"),'V',"Venenosa",-100,false,false,true);
		}
				
		else if(selecci�n == 3) {
			elementos = new Elemento[2];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,200,460,new ImageIcon("Imagenes/FrutaHarryPotter.png"),'H',"Harry Potter",-50,true,false,false);
		}
			
		else if(selecci�n == 4) {	
			elementos = new Elemento[3];
			agregarPersonaje(0,10,295,new ImageIcon("Imagenes/Protagonista.png"),'O',1);
			agregarFruta(1,240,430,new ImageIcon("Imagenes/FrutaDrag�n.png"),'D',"Dragon",100);
			agregarFruta(2,560,50,new ImageIcon("Imagenes/FrutaPlateada.png"),'P',"Plateada",200);
		}
			
		else {}
	}

//M�todo para vaciar el escenario
	public void limpiarEscenario() {
		for(int t=0 ; t<elementos.length ; t++) {
			elementos[t].imagen = null;						//Dejamos la imagen de la fruta como nula, puesto que es objeto ImageIcon
		}
	}
	
//M�todo para devolver el Lore del comienzo
	public String toStringLore() {							//Este m�todo me devuelve en formato String el Lore que se muestra previamente a la selecci�n de escenarios
		return("ATRAPA LA FRUTA\n\"Bienvenido al emocionante juego de 'Atrapa la fruta'. Durante esta breve aventura,\r\n"
				+ "tu objetivo ser� recorrer las diferentes regiones del bosque de Elleria, con el fin de encontrar\r\n"
				+ "las frutas que el doctor Loufthy te encomend� recoger. Cuantas m�s frutas consigas, tu recompensa\r\n"
				+ "ser� mayor.\r\n"
				+ "Pero ten cuidado, algunas de estas frutas tienen poderes sobrenaturales, que deber�s de registrar para\r\n"
				+ "ayudar al doctor con sus investigaciones.\r\n"
				+ "Mucha suerte");	
	}
}



//COMENTARIOS

/*Comentario #1: Este vector de objetos de tipo elementos ser� el encargado de almacenar
 * los distintos s�mbolos asociados a cada elemento, ya sea un personaje o una fruta.
 * El objetivo ser� que esta clase Escenario cree y almacene los objetos de tipo Fruta
 * y Personaje que heredan de la clase abstracta Elemento.*/

/*Comentario #2: Todos los elmentos del juego tendr�n una caja de colisi�n donde se encuentran encerrados. Esta caja se va a crear empleando 
 * la clase Rectangle, donde, indicando la posici�n X e Y, el ancho y el alto(que son los atributos del elemento al que asociamos la caja),
 * podemos realizar comparativas para ver si ha existido colisi�n entre cajas, permitiendo esto la interacci�n entre elementos.*/

 

