package Codigo_Central;

//Imports
import javax.swing.*;												//Clase gr�fica swing

public class Main extends JFrame{									//Heredo de JFrame para poder utilizar interfaces gr�ficas de Swing								
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("ATRAPA LA FRUTA");				//Creamos el contenedor de alto nivel JFrame con el que vamos a trabajar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Indicamos que este JFrame es capaz de ser cerrado con la opci�n "EXIT ON CLOSE"
		
		JTabbedPane tabbed = new JTabbedPane();						//Creamos un JTabbedPane(Comentario #1)
		Ventana ventana = new Ventana(tabbed);						//Creo la ventana y le paso como argumento el JTabbedPanel para almacenarlo
		tabbed.addTab("Pantalla de Juego", ventana);				//Fijamos una de sus pesta�as como un JPanel de la clase Ventana (hereda de JPanel)
		
		frame.getContentPane().add(tabbed);							//Introduzco el JTabbedPane en el panel de contenci�n
		frame.pack();												//Empaqueto el frame de forma definitiva
		frame.setVisible(true);										//Permito su visibilidad para que todo empiece a funcionar.
		
		JOptionPane.showMessageDialog(null, ventana.getEscenario().toStringLore());				//Muestro la presentaci�n del juego por pantalla
	}
}

//COMENTARIOS

/*Comentario #1: La idea es crear un contenedor de alto nivel (JFrame en nuestro caso), que dentro de su pa�o de contenci�n (pa�o encargado de
 * almacenar componenetes y contenedores de menor nivel), almacenar� un contenedor de nivel intermedio tipo JTabbedPane.
 * Este panel tiene la peculiaridad de que puede almacenar distintos JPanel's, que se ver�n diferenciados por pesta�as en la zona superior.
 * En este caso introducimos un �nico JPanel, con el nombre de ventana (ya que la clase Ventana hereda de JPanel y se convierte en una 
 * contenedora de nivel intermedio, que podremos seleccionar mediante las pesta�as del JTabbedPane).*/
