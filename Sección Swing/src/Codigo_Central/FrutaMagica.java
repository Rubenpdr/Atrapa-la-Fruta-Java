package Codigo_Central;

import javax.swing.ImageIcon;

public class FrutaMagica extends Fruta{

	//ATRIBUTOS
	public boolean Desenfocar;							//Efectos de las frutas M�gicas	
	public boolean Correr;
	public boolean Ralentizar;
	
	//M�TODOS
	
//M�todo Constructor
	public FrutaMagica(int posicionX,int posicionY,int ancho,int alto,ImageIcon imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos);
		this.Desenfocar = Desenfocar;
		this.Correr = Correr;
		this.Ralentizar = Ralentizar;
	}
	
//Aplicar efectos
	public void aplicarEfectos(Personaje protagonista) {		//M�todo de control que checkear el efecto que provoca una fruta recogida
			if(Desenfocar==true) {
				desenfocar(protagonista);
			}
			else if(Correr==true) {
				correr(protagonista);
			}
			else if(Ralentizar==true) {
				ralentizar(protagonista);
			}
		
	}
	
//M�todo desenfocar y enfocar
	public void desenfocar(Personaje protagonista){			//Para desenfocar simplemente cambio el ImageIcon del elemento por un fondo invisible			
		protagonista.imagen = new ImageIcon("Imagenes/Invisibilidad");
	}	
	
	
//M�todo desenfocar
	public void correr(Personaje protagonista) {						
		if(protagonista.velocidad<4) {						//Compruebo que la velocidad no sea demasiado elevada de por si,pues puede saturar el nivel
			protagonista.velocidad++;						//Aumento la velocidad del personaje
		}
	}	
	
//M�todo desenfocar
	public void ralentizar(Personaje protagonista) {		
		if(protagonista.velocidad>1) {						//Compruebo que la velocidad no sea nula, porque si no el personaje se para
			protagonista.velocidad--;						//Reduzco la velocidad del personaje
		}
	}	
	
//M�todo mostrar datos sobrescrito
	@Override
	public void mostrarDatos() {
		System.out.println("Datos de la fruta "+nombre_fruta+":\n"
				+ "Posici�n X: "+posicionX+"\nPosici�n Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "S�mbolo: "+simbolo+"\nNombre: "+nombre_fruta+"\nPuntos: "+puntos+"\nDesenfocar: "+Desenfocar+"\nCorrer: "+Correr+"\n"
								+ "Ralentizar: "+Ralentizar+"\n");
	}
	
	
	
	
}