import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;


public class ClaseComponentes extends Ventana{

	private JButton btnPrueba;

	public ClaseComponentes() {
	
		btnPrueba = new JButton("Boton de prueba");
		this.add(btnPrueba);
		//FlowLayout fl = new FlowLayout();
		//BorderLayout bl = new BorderLayout();
		//GridLayout gl = new GridLayout(3, 4, 50, 50);
		Box izq = Box.createVerticalBox();
		ButtonGroup grupoRadio = new ButtonGroup();
		JRadioButton rbutton;
		
		grupoRadio.add(rbutton = new JRadioButton("Rojo"));
		izq.add(rbutton);
		
		grupoRadio.add(rbutton = new JRadioButton("Azul"));
		izq.add(rbutton);
		
		grupoRadio.add(rbutton = new JRadioButton("Amarillo"));
		izq.add(rbutton);
		
		grupoRadio.add(rbutton = new JRadioButton("Verde"));
		izq.add(rbutton);
		
		Box der = Box.createVerticalBox();
		der.add(new JCheckBox("Hola"));
		der.add(new JCheckBox("Buenas tardes"));
		der.add(new JCheckBox("Buenas noches"));
		
		Box arriba = Box.createHorizontalBox();
		arriba.add(izq);
		arriba.add(der);
		
		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(arriba);
		
		//for(int x = 0; x < 10; x++ ){
			//content.add(new JButton("Boton"+x));
		//}
		//for(int i = 0; i<10; i++){
			//content.add(new JButton("BOTON"+i));
		//}
		this.pack();
		//content.add(new JButton("ESTE"),BorderLayout.EAST);
		//content.add(new JButton("Oeste"),BorderLayout.WEST);
		//content.add(new JButton("Center"),BorderLayout.CENTER);
	}
	
}
