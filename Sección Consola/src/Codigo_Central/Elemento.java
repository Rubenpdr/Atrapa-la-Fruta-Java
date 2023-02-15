package Codigo_Central;

public abstract class Elemento {
	
	//ATRIBUTOS
	public int posicionX;
	public int posicionY;
	public int ancho;
	public int alto;
	public float imagen;
	public char simbolo;
	public boolean tipo_elemento;
	
	//M�TODOS
	
//M�todo Constructor
	public Elemento(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = imagen;
		this.simbolo = simbolo;
	}
	
	public abstract void mostrarDatos();

//M�todos Getter
	public char getSimbolo() {
		return simbolo;
	}
	

}

/*Esta clase solo sirve para almacenar caracter�sticas generales de las frutas y los 
 * personajes, as� como para inicializar un m�todo abstracto*/
