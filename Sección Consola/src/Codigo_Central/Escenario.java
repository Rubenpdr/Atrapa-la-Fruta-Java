package Codigo_Central;

public class Escenario {
	
	//ATRIBUTOS
	public int ancho;
	public int alto;
	public Elemento elementos[];		//Comentario #1
	
	//MÉTODOS
	
//Método Constructor
	public Escenario(int ancho,int alto,Elemento elementos[]) {
		this.ancho = ancho;
		this.alto = alto;
		this.elementos = elementos;
	}
	
//Método constructor vacío por sobrecarga de métodos
	public Escenario() {}
	
//Método agregar fruta
	public void agregarFruta(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos) {
		elementos[index] = new Fruta(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos);
	}
	
//Método sobrecargado para agregar frutas mágicas
	public void agregarFruta(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		elementos[index] = new FrutaMagica(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos,Desenfocar,Correr,Ralentizar);
	}
	
//Método para agregar personaje principal
	public void agregarPersonaje(int index,int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,int velocidad) {
		elementos[index]= new Personaje(posicionX,posicionY,ancho,alto,imagen,simbolo,velocidad);	
	}

//Métodos getter
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
	
//Método para seleccionar escenario
	public Ventana seleccionEscenario(byte selección) {
		if(selección == 1) {	
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[3]);
			Ventana ventana = new Ventana(55,55,escenario);	
		
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'D',"Dragon",100);
			escenario.agregarFruta(2,30,1,1,1,777,'P',"Plateada",200);

			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);
			
			return ventana;
		}
		
		else if(selección == 2) {			
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[3]);
			Ventana ventana = new Ventana(55,55,escenario);	
				
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'G',"Dorada",300,false,true,false);
			escenario.agregarFruta(2,29,1,1,1,777,'V',"Venenosa",-100,false,false,true);
			
				
			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);	
			
			return ventana;
		}
				
		else if(selección == 3) {		//Línea recta, coger las dos frutas				
			Escenario escenario = new Escenario(40,40,elementos=new Elemento[2]);
			Ventana ventana = new Ventana(55,55,escenario);	
				
			//Elementos
			escenario.agregarPersonaje(0,1,1,1,1,777,'O',1);
			escenario.agregarFruta(1,15,1,1,1,777,'H',"Harry Potter",-50,true,false,false);
			
			ventana.dibujarEscenario(elementos,escenario.ancho,escenario.alto);		
			
			return ventana;
		}
			
		else if(selección == 4) {				
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
			System.out.println("El escenario introducido no está disponible");
			System.exit(0);
		}
		
		Ventana ventana=null;
		return ventana;
	}
	
}



//COMENTARIOS

/*Comentario #1: Este vector de objetos de tipo elementos será el encargado de almacenar
 * los distintos símbolos asociados a cada elemento, ya sea un personaje o una fruta.
 * El objetivo será que esta clase Escenario cree y almacene los objetos de tipo Fruta
 * y Personaje que heredan de la clase abstracta Elemento.*/

/*Esta clase me permitirá crear cualquier objeto de tipo personaje o fruta/fruta mágica 
 * utilizando métodos cómodos que me informarán de los argumentos para que se los envíe al
 * constructor de las respectivas clases, permitiendo abstraer el código y tener TODA la información
 * que necesito de 4 clases en una sola.*/
 
/*Comentario #2: Es importante no hacer "dificultad == "P"", ya que el programa estaría comparando las referencias a cadenas.
 * Para que sea comprensible, se debería de introducir "dificultad.equals("P")", haciendo uso del método equals para 
 * realizar la comparativa con cadenas de caracteres.*/

/*Comentario #3: Las ventanas serán de un tamaño ligeramente superior a el escenario, en caso de 
 * que se tengan que colocar botones o cualquier otra cosa en la interfaz gráfica.
 * Para dibujar el escenario, dado que me da problemas escoger una altura menor que el ancho (
 * seguramente por el orden de los for en el método), los voy a usar del mismo tamaño y menor que
 * la ventana, ya que no causa problemas.
 * Por otro lado, introduciré la información de forma manual acerca de los personajes y objetos.
 * Al igual que hay distintas frutas, también habrá personajes buenos y malos que te darán frutas
 * o te atacarán respectivamente.*/
