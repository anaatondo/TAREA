import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Memorama extends Frame implements MouseListener,MouseMotionListener
{
	
	private boolean arriba[][];
	private final int CX=100; 
	private final int CY=100;
	
	private int NE=0;
	private int NC=0;
	private int k;
	private int l;
	
	private int Arriba=0;
	private int carta1=0;
	private int carta2=0;
    
	private final int EX=100;
	private final int EY=100;
	
	private int mcy,mcx;
	private int mmx,mmy;
	
	private Random r=new Random();
	
	
	public ImageIcon imagenFondo;
	public ImageIcon imagenOculta;
	public ImageIcon imagen1;
	public ImageIcon imagen2;
	public ImageIcon imagen3;
	public ImageIcon imagen4;
	public ImageIcon imagen5;
	public ImageIcon imagen6;
	public ImageIcon imagen7;
	public ImageIcon imagen8;
	public String nombre;
	public int o;
	public int p;
	public int parejas;
    private Timer timer;
	private int segundos;
	private boolean pausa=false;
			
    public Memorama()
    { 
    	 
        int i,j,k,l;
		addMouseListener(this);  
        addMouseMotionListener(this); 
    	setSize(1024,768);
    	
    	//Inicialización de la matriz arriba
    	arriba=new boolean[4][4];
    	for(i=0;i<4;i++)
    		for(j=0;j<4;j++)
    			arriba[i][j]=false;
    	
    	//Coloca las cartas en forma aleatoria, 
    	for(k=1;k<=8;k++)
    		for(l=1;l<=2;l++){
    			do{
    				i=r.nextInt(4);
    				j=r.nextInt(4);
    			}while(tablero.tablero1[i][j]!=0);
    			tablero.tablero1[i][j]=k;
    		}
    		
    	//cargamos la imagenes
    	imagenOculta=new ImageIcon("oculta2.png");
    	imagenFondo=new ImageIcon("fondo.png");
    	imagen1=new ImageIcon("1.jpg");
    	imagen2=new ImageIcon("2.jpg");
    	imagen3=new ImageIcon("3.jpg");
    	imagen4=new ImageIcon("4.jpg");
    	imagen5=new ImageIcon("5.jpg");
    	imagen6=new ImageIcon("6.jpg");
    	imagen7=new ImageIcon("7.jpg");
    	imagen8=new ImageIcon("8.jpg");
    	
    	timer = new Timer();
		segundos = 120;
		timer.schedule(new again(),0, 1*1000);
		setUndecorated(true);
    	setResizable(false);
		setBackground(new Color(130,158,16));
		setTitle(" MEMORAMA ");
		Dimension Pantalla=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frame=this.getSize();
		setLocation((Pantalla.width/2-(frame.width/2)),Pantalla.height/2-(frame.height/2));
		setVisible(true);
	}
	
    
    public void dibCuadro(Graphics g, int px, int py,int v){
    	switch(v){
    		case 0:	g.drawImage(imagenOculta.getImage(),px,py,98,98,null);
    				break;
    		case 1:	g.drawImage(imagen1.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 2:	g.drawImage(imagen2.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 3:	g.drawImage(imagen3.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 4:	g.drawImage(imagen4.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 5:	g.drawImage(imagen5.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 6:	g.drawImage(imagen6.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 7:	g.drawImage(imagen7.getImage(),px+4,py+4,90,90,null);
    				break;
    		case 8:	g.drawImage(imagen8.getImage(),px+4,py+4,90,90,null);
    				break;		
    	}
    }
   public void NOMBRE(String n)
   {
    	nombre=n;
    }
    
    //METODO DONDE SE DIBUJA EN TABLERO DE JUEGO
    public void paint(Graphics g){
    	g.drawImage(imagenFondo.getImage(),0,0,1024,768,null);
    	g.setColor(Color.black); 
		g.setFont(new Font("Arial", Font.BOLD, 22));
	   	int i,j;
    		for(i=0;i<4;i++){
	    		for(j=0;j<4;j++){
	    			if(arriba[i][j])
	    				dibCuadro(g,CX+j*EX,CY+i*EY,tablero.tablero1[i][j]);
	    			else
	    				dibCuadro(g,CX+j*EX,CY+i*EY,0);
    			}
    		}
    		
    	//salir
    	g.setColor(Color.red);
    	g.fillRect(600,250,150,30);
    	
   
    	g.setFont(new Font("Arial", Font.BOLD, 16));
    	g.setColor(Color.white);    				
    	g.drawString("Salir del Juego",615,270);
     	g.drawString("Nombre del Jugador: ",600,600);
	   	g.setColor(Color.black);
	   	g.drawString(""+nombre,600,620);
	   	g.setColor(new Color(45,52,0));
	   	String s="Tiempo: "+new Integer(segundos).toString();
	   	g.drawString(s,600,660);
	   	
    }
    
      public void mouseClicked(MouseEvent me)
    {
    	NC=NC+1;
    	mcx=me.getX();// x
    	mcy=me.getY();// y
       	int i,j;
       if((mcx>=CX)&&(mcy>=CY)&&(mcx<=(CX+4*EX))&&(mcy<=(CY+4*EY))&&!pausa)
    	{
    		i=(mcy-CY)/EY;
    		j=(mcx-CX)/EX;
     	if(arriba[i][j]!=true&&parejas<=7)
    	{
    		if(!arriba[i][j])
    		{
    			Arriba=Arriba+1;
    			arriba[i][j]=true;
    				if(Arriba==1){
    				carta1+=tablero.tablero1[i][j];
    				o=i;
    				p=j;
    			}
    				if(Arriba==2)
    				{
    				carta2+=tablero.tablero1[i][j];
    				if(carta1==carta2)
    					{
    					JOptionPane.showMessageDialog(null,"Forman una pareja","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
    					Arriba=0;
    					carta1=0;
    					carta2=0;
    					arriba[i][j]=true;
    					arriba[o][p]=true;
    					parejas=parejas+1;
    					if(parejas==8)
    					{
    						timer.cancel();
    						JOptionPane.showMessageDialog(null,"Fin del Juego..!!","Memorama en Java", JOptionPane.PLAIN_MESSAGE);	
    						JOptionPane.showMessageDialog(null,"Numero Total de Clicks: "+NC,"Memorama en Java", JOptionPane.PLAIN_MESSAGE);
    						
    					}
		    		}
		    		else{
		    				NE=NE+1;
		    			JOptionPane.showMessageDialog(null,"No forman pareja..!!","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
    					Arriba=0;
    					carta1=0;
    					carta2=0;
    					arriba[i][j]=false;
    					arriba[o][p]=false;;
	   				}
	   			}
    	  }
    	  else{
    	 	arriba[i][j]=false;
    	  }
    	  }
    	}
    	
    	if(mcx>=600&&mcx<=750&&mcy>=250&&mcy<=280)
    	{
    		Menu Menu= new Menu();
    	}
    	
    	
    }
 	//metodo mouseMoved: no requerido para el programa hasta ahora
 	public void mouseMoved(MouseEvent me){
 	}
 	//metodo mousePressed: no requerido para el programa hasta ahora
 	public void mousePressed(MouseEvent e){
    }
    //metodo mouseReleased: no requerido para el programa hasta ahora
    public void mouseReleased(MouseEvent e){
    }
    //metodo mouseEntered: no requerido para el programa hasta ahora	
	public void mouseEntered(MouseEvent me){
	}
	//metodo mouseExited: no requerido para el programa hasta ahora
	public void mouseExited(MouseEvent me){
	}
 	//metodo mouseDragged: no requerido para el programa hasta ahora
    public void mouseDragged(MouseEvent e){
    }

class again extends TimerTask {
	public void run() {
		repaint();
		if(segundos==30)
		{
			JOptionPane.showMessageDialog(null,"Case termina el Juego: "+"\n"+segundos+" Segunos ","Aviso..!!",JOptionPane.PLAIN_MESSAGE);
		}
		if(segundos<=0)
		{
			JOptionPane.showMessageDialog(null,"Fin del Juego"+" ","MEMORAMA",JOptionPane.PLAIN_MESSAGE);
			timer.cancel(); 
			JOptionPane.showMessageDialog(null,"Numero de clicks");
		}
		if(segundos==0)
		{
			JOptionPane.showMessageDialog(null,"Lo siento perdedor, vuelve a Jugar: "+"\n"+segundos+" Segunos ","Aviso..!!",JOptionPane.PLAIN_MESSAGE);
		}
		segundos--;
	}
}
	
}