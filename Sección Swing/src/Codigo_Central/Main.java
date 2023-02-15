package Codigo_Central;

//Imports
import javax.swing.*;												//Clase gráfica swing

public class Main extends JFrame{									//Heredo de JFrame para poder utilizar interfaces gráficas de Swing								
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("ATRAPA LA FRUTA");				//Creamos el contenedor de alto nivel JFrame con el que vamos a trabajar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Indicamos que este JFrame es capaz de ser cerrado con la opción "EXIT ON CLOSE"
		
		JTabbedPane tabbed = new JTabbedPane();						//Creamos un JTabbedPane(Comentario #1)
		Ventana ventana = new Ventana(tabbed);						//Creo la ventana y le paso como argumento el JTabbedPanel para almacenarlo
		tabbed.addTab("Pantalla de Juego", ventana);				//Fijamos una de sus pestañas como un JPanel de la clase Ventana (hereda de JPanel)
		
		frame.getContentPane().add(tabbed);							//Introduzco el JTabbedPane en el panel de contención
		frame.pack();												//Empaqueto el frame de forma definitiva
		frame.setVisible(true);										//Permito su visibilidad para que todo empiece a funcionar.
		
		JOptionPane.showMessageDialog(null, ventana.getEscenario().toStringLore());				//Muestro la presentación del juego por pantalla
	}
}

//COMENTARIOS

/*Comentario #1: La idea es crear un contenedor de alto nivel (JFrame en nuestro caso), que dentro de su paño de contención (paño encargado de
 * almacenar componenetes y contenedores de menor nivel), almacenará un contenedor de nivel intermedio tipo JTabbedPane.
 * Este panel tiene la peculiaridad de que puede almacenar distintos JPanel's, que se verán diferenciados por pestañas en la zona superior.
 * En este caso introducimos un único JPanel, con el nombre de ventana (ya que la clase Ventana hereda de JPanel y se convierte en una 
 * contenedora de nivel intermedio, que podremos seleccionar mediante las pestañas del JTabbedPane).*/
