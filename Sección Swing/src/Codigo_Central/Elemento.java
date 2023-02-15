package Codigo_Central;

import javax.swing.ImageIcon;						

public abstract class Elemento {			//Comentario #1
	
	//ATRIBUTOS
	public int posicionX;							//Indica la posición en el eje de abcisas del objeto (en términos de píxeles)
	public int posicionY;							//Indica la posición en el eje de ordenadas del objeto (en términos de píxeles)
	public int ancho;								//Indica el ancho en píxeles del ImageIcon asociado al objeto
	public int alto;								//Indica el alto en píxeles del ImageIcon asociado al objeto
	public ImageIcon imagen;						//Imagen asociada al objeto
	public char simbolo;							//Indica el símbolo del objeto
	
	//MÉTODOS
	
//Método Constructor
	public Elemento(int posicionX,int posicionY,int ancho,int alto,ImageIcon imagen,char simbolo) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = imagen;
		this.simbolo = simbolo;

	}
	
//Método abstracto para mostrar datos
	public abstract void mostrarDatos();			//Método que muestran los atributos del objeto que lo invoca
	
//Métodos Getter
	public char getSimbolo() {
		return simbolo;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	

}

//COMENTARIOS
/*Comentario #1-> Esta clase es una superclase abstracta, de forma que las clases "Personaje" y "Fruta" heredaran de esta. Estas 
 * también deben de implementar el método abstracto */


