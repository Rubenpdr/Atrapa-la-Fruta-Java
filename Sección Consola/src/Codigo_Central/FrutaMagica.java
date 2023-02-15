package Codigo_Central;

public class FrutaMagica extends Fruta{

	//ATRIBUTOS
	public boolean Desenfocar;
	public boolean Correr;
	public boolean Ralentizar;
	
	//MÉTODOS
	
//Método Constructor
	public FrutaMagica(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos,boolean Desenfocar,boolean Correr,boolean Ralentizar) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo,nombre,puntos);
		this.Desenfocar = Desenfocar;
		this.Correr = Correr;
		this.Ralentizar = Ralentizar;
	}
	
//Aplicar efectos
	public void aplicarEfectos(Personaje protagonista, FrutaMagica frutaMagica) {
			if(frutaMagica.Desenfocar==true) {
				frutaMagica.desenfocar(protagonista);
			}
			else if(frutaMagica.Correr==true) {
				frutaMagica.correr(protagonista);
			}
			else if(frutaMagica.Ralentizar==true) {
				frutaMagica.ralentizar(protagonista);
			}
		
	}
	
//Método desenfocar y enfocar
	public void desenfocar(Personaje protagonista){					
		protagonista.simbolo =' ';
	}	
	
	
//Método desenfocar
	public void correr(Personaje protagonista) {						
		if(protagonista.velocidad<3) {
			protagonista.velocidad++;						//Demasiada velocidad puede saturar el nivel
		}
	}	
	
//Método desenfocar
	public void ralentizar(Personaje protagonista) {
		if(protagonista.velocidad>1) {
			protagonista.velocidad--;						//No puedo reducir velocidad hasta que se pare, tengo que comprobar
		}
	}	
	
//Método mostrar datos sobrescrito
	@Override
	public void mostrarDatos() {
		System.out.println("Datos de la fruta "+nombre+":\n"
				+ "Posición X: "+posicionX+"\nPosición Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "Símbolo: "+simbolo+"\nNombre: "+nombre+"\nPuntos: "+puntos+"\nDesenfocar: "+Desenfocar+"\nCorrer: "+Correr+"\n"
								+ "Ralentizar: "+Ralentizar+"\n");
	}
	
	
	
	
}