package Codigo_Central;

public class Escenario {
	
	//ATRIBUTOS
	public int ancho;
	public int alto;
	public Elemento elementos[];		//Comentario #1
	
	//M�TODOS
	
//M�todo Constructor
	public Escenario(int ancho,int alto,Elemento elementos[]) {
		this.ancho = ancho;
		this.alto = alto;
		this.elementos = elementos;
	}
	
//M�todo constructor vac�o por sobrecarga de m�todos
	public Escenario() {}
	
//M�todo agregar fruta
	public void agregarFruta(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos) {
		elementos[index] = new Fruta(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos);
	}
	
//M�todo sobrecargado para agregar frutas m�gicas
	public void agregarFruta(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		elementos[index] = new FrutaMagica(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos,Desenfocar,Correr,Ralentizar);
	}
	
//M�todo para agregar personaje principal
	public void agregarPersonaje(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,int velocidad) {
		elementos[index]= new Personaje(posicionX,posicionY,ancho,alto,imagen,simbolo,velocidad);	
	}

//M�todos getter
	public Elemento[] getElementos() {
		return elementos;	
	}	
	
	public Elemento[] getFrutas() {
		Elemento frutas[] = new Elemento[10];
		int contador=0;
		for (int i=0 ; i<elementos.length ; i++) {
			if(elementos[i].getSimbolo() =='D' || elementos[i].getSimbolo()=='P' || elementos[i].getSimbolo()=='V' || elementos[i].getSimbolo()=='G' || elementos[i].getSimbolo()=='H') {;	
				frutas[contador] = elementos[i];
				contador++;
			}
		}
		return frutas;
	}
	
	public Personaje getProtagonista() {
		Personaje protagonista = (Personaje) elementos[0];
		return protagonista;
	}
	
//M�todo para seleccionar escenario
	public Ventana seleccionEscenario(byte selecci�n) {
		if(selecci�n == 1) {	
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[3]);
			Ventana ventana = new Ventana(55,55,escenario);	
		
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'D',"Dragon",100);
			escenario.agregarFruta(2,30,1,1,1,777,'P',"Plateada",200);

			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);
			
			return ventana;
		}
		
		else if(selecci�n == 2) {			
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[3]);
			Ventana ventana = new Ventana(55,55,escenario);	
				
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'G',"Dorada",300,false,true,false);
			escenario.agregarFruta(2,29,1,1,1,777,'V',"Venenosa",-100,false,false,true);
			
				
			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);	
			
			return ventana;
		}
				
		else if(selecci�n == 3) {		//L�nea recta, coger las dos frutas				
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[2]);
			Ventana ventana = new Ventana(55,55,escenario);	
				
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'H',"Harry Potter",-50,true,false,false);
			
			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);		
			
			return ventana;
		}
			
		else if(selecci�n == 4) {				
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[3]);
			Ventana ventana = new Ventana(55,55,escenario);	
				
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'D',"Dragon",100);
			escenario.agregarFruta(2,30,2,1,1,777,'P',"Plateada",200);
				
			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);	
			return ventana;
		}
			
		else {
			System.out.println("El escenario introducido no est� disponible");
			System.exit(0);
		}
		
		Ventana ventana=null;
		return ventana;
	}
	
}



//COMENTARIOS

/*Comentario #1: Este vector de objetos de tipo elementos ser� el encargado de almacenar
 * los distintos s�mbolos asociados a cada elemento, ya sea un personaje o una fruta.
 * El objetivo ser� que esta clase Escenario cree y almacene los objetos de tipo Fruta
 * y Personaje que heredan de la clase abstracta Elemento.*/

/*Esta clase me permitir� crear cualquier objeto de tipo personaje o fruta/fruta m�gica 
 * utilizando m�todos c�modos que me informar�n de los argumentos para que se los env�e al
 * constructor de las respectivas clases, permitiendo abstraer el c�digo y tener TODA la informaci�n
 * que necesito de 4 clases en una sola.*/
 
/*Comentario #2: Es importante no hacer "dificultad == "P"", ya que el programa estar�a comparando las referencias a cadenas.
 * Para que sea comprensible, se deber�a de introducir "dificultad.equals("P")", haciendo uso del m�todo equals para 
 * realizar la comparativa con cadenas de caracteres.*/

/*Comentario #3: Las ventanas ser�n de un tama�o ligeramente superior a el escenario, en caso de 
 * que se tengan que colocar botones o cualquier otra cosa en la interfaz gr�fica.
 * Para dibujar el escenario, dado que me da problemas escoger una altura menor que el ancho (
 * seguramente por el orden de los for en el m�todo), los voy a usar del mismo tama�o y menor que
 * la ventana, ya que no causa problemas.
 * Por otro lado, introducir� la informaci�n de forma manual acerca de los personajes y objetos.
 * Al igual que hay distintas frutas, tambi�n habr� personajes buenos y malos que te dar�n frutas
 * o te atacar�n respectivamente.*/
