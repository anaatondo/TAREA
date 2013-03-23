import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JTextField;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

	JMenuBar menuBar;
	JMenu menuArchivo;
	JMenu menuAbrir;
	JMenuItem menuItem;
 
	   
	public Menu()
	{
		

		ImageIcon imagenFondo = new ImageIcon("fondo.jpg");
		setSize(600,400);
		setUndecorated(true);
		JMenuBar menuBar;
		JMenu menuArchivo;
		JMenuItem menuItem;
		this.setTitle("Prueba de Menu");
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		menuArchivo=new JMenu("NIVELES DE JUEGO");
		menuBar.add(menuArchivo);
		
	       
		       	
		menuArchivo.add(new AbstractAction("BASICO")
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String nombre1="";
	    		nombre1=JOptionPane.showInputDialog(null,"Nombre del Jugador","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
	    		if(nombre1!=null){
	    			Memorama coordenada= new Memorama();
	    	   		coordenada.NOMBRE(nombre1);
	    		}
			}			
		});
		menuArchivo.add(new AbstractAction("INTERMEDIO")
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String nombre1="";
	    		nombre1=JOptionPane.showInputDialog(null,"Nombre del Jugador","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
	    		if(nombre1!=null)
	    		{
	    			Memorama2 coordenada= new Memorama2();
	    	   		coordenada.NOMBRE(nombre1);
	    		}
				
				
			}			
		});
		menuArchivo.add(new AbstractAction("AVANZADO")
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String nombre1="";
	    		nombre1=JOptionPane.showInputDialog(null,"Nombre del Jugador","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
	    		if(nombre1!=null)
	    		{
	    			Memorama3 coordenada= new Memorama3();
	    	   		coordenada.NOMBRE(nombre1);
	    		}
				
				
			}			
		});
		menuArchivo.add(new AbstractAction("EXIT")
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}			
		});
        
		
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Usuario");
	
        }
	
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	

}
