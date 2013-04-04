import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


public class DemoMenu extends Ventana implements ActionListener{
	
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, colorMenu;
	private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
	
	private JRadioButtonMenuItem lineItem, rectangleItem, circleItem, curveItem, textItem;
	private JCheckBoxMenuItem redItem, yellowItem, greenItem, blueItem;
	
	public DemoMenu(int w,int h, String t) {
		super(w, h, t);
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		fileMenu = new JMenu("Archivo");
		newItem = fileMenu.add("nuevo");
		newItem.addActionListener(this);
		
		openItem = fileMenu.add("Abrir");
		openItem.addActionListener(this);
		closeItem = fileMenu.add("cerrar");
		closeItem.addActionListener(this);
		fileMenu.addSeparator();
		
		saveItem = fileMenu.add("Guardar");
		saveItem.addActionListener(this);
		saveAsItem = fileMenu.add("Guardar como");
		saveAsItem.addActionListener(this);
		
		fileMenu.addSeparator();
		printItem = fileMenu.add("Imprimir");
		printItem.addActionListener(this);
		
		fileMenu.setMnemonic('A');
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		
		editMenu = new JMenu("Editar");
		editMenu.add(lineItem = new JRadioButtonMenuItem("Line",true));
		editMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangulo",false));
		editMenu.add(circleItem = new JRadioButtonMenuItem("Circulo",false));
		editMenu.add(curveItem = new JRadioButtonMenuItem("Curva",false));
		ButtonGroup types = new ButtonGroup();
		types.add(lineItem);
		types.add(rectangleItem);
		types.add(circleItem);
		types.add(curveItem);
		
		editMenu.addSeparator();
		
		colorMenu = new JMenu("Color");
		editMenu.add(colorMenu);
		
		colorMenu.add(redItem = new JCheckBoxMenuItem("Rojo",false));
		colorMenu.add(yellowItem = new JCheckBoxMenuItem("amarillo",false));
		colorMenu.add(greenItem = new JCheckBoxMenuItem("Verde",false));
		colorMenu.add(blueItem = new JCheckBoxMenuItem("Azul",false));
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
	}
	
}

