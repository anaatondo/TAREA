import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Memorama3 extends Frame implements MouseListener,MouseMotionListener{
		
	private boolean arriba[][];
	private final int CX=100;
	private final int CY=100;
	
	private int T;
	
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
	public ImageIcon imagen9;
	public ImageIcon imagen10;
	public ImageIcon imagen11;
	public ImageIcon imagen12;
	public ImageIcon imagen13;
	public ImageIcon imagen14;
	public ImageIcon imagen15;
	public ImageIcon imagen16;
	public ImageIcon imagen17;
	public ImageIcon imagen18;
	
	public String nombre;
	
	public int o;
	public int p;
	
	public int parejas;
			
	
	private Timer timer;
	private int segundos;
	private boolean pausa=false;
			
	  public Memorama3()
	  { 
    	 
        int i,j,k,l;
		addMouseListener(this);  
        addMouseMotionListener(this); 
    	setSize(1024,768);//**********************
    	
    	arriba=new boolean[6][6];
    	for(i=0;i<6;i++)
    		for(j=0;j<6;j++)
    			arriba[i][j]=false;
    	
    	for(k=1;k<=18;k++)
    		for(l=1;l<=2;l++)
    		{
    			do{
    				i=r.nextInt(6);
    				j=r.nextInt(6);
    			}while(tablero.tablero[i][j]!=0);
    			tablero.tablero[i][j]=k;
    		}
    		
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
    	imagen9=new ImageIcon("9.jpg");
    	imagen10=new ImageIcon("10.jpg");
    	imagen11=new ImageIcon("11.jpg");
    	imagen12=new ImageIcon("12.jpg");
    	imagen13=new ImageIcon("13.jpg");
    	imagen14=new ImageIcon("14.jpg");
    	imagen15=new ImageIcon("15.jpg");
    	imagen16=new ImageIcon("16.jpg");
    	imagen17=new ImageIcon("17.jpg");
    	imagen18=new ImageIcon("18.jpg");
    	
    	timer = new Timer();
		segundos = 100;
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
    		case 9:	g.drawImage(imagen9.getImage(),px+4,py+4,90,90,null);
			break;
	        case 10:	g.drawImage(imagen10.getImage(),px+4,py+4,90,90,null);
			break;
	        case 11:	g.drawImage(imagen11.getImage(),px+4,py+4,90,90,null);
			break;
	        case 12:	g.drawImage(imagen12.getImage(),px+4,py+4,90,90,null);
			break;
	        case 13:	g.drawImage(imagen13.getImage(),px+4,py+4,90,90,null);
			break;
	        case 14:	g.drawImage(imagen14.getImage(),px+4,py+4,90,90,null);
			break;
	        case 15:	g.drawImage(imagen15.getImage(),px+4,py+4,90,90,null);
			break;
	        case 16:	g.drawImage(imagen16.getImage(),px+4,py+4,90,90,null);
			break;
	        case 17:	g.drawImage(imagen17.getImage(),px+4,py+4,90,90,null);
			break;
	        case 18:	g.drawImage(imagen18.getImage(),px+4,py+4,90,90,null);
			break;
			
    	}
    }
    public void NOMBRE(String n)
    {
    	nombre=n;
    }
    
      public void paint(Graphics g){
    	g.drawImage(imagenFondo.getImage(),0,0,1024,768,null);
    	g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 22));
		g.setColor(Color.black);
       	int i,j;
    		for(i=0;i<6;i++){
	    		for(j=0;j<6;j++){
	    			if(arriba[i][j])
	    				dibCuadro(g,CX+j*EX,CY+i*EY,tablero.tablero[i][j]);
	    			else
	    				dibCuadro(g,CX+j*EX,CY+i*EY,0);
    			}
    		}
    			
    	g.setColor(Color.red);
    	g.fillRect(700,250,50,30);
    	
    	g.setFont(new Font("Arial", Font.BOLD, 16));
    	g.setColor(Color.white);    				
    	g.drawString("EXIT",700,270);
    		
    	g.setColor(Color.black); 
	    g.drawString("Nombre del Jugador: ",700,600);
	   	g.setColor(Color.black);
	   	g.drawString(""+nombre,700,620);
	   	g.setColor(new Color(45,52,0));
	   	String s="Tiempo: "+new Integer(segundos).toString();
	   	g.drawString(s,700,660);
	   	
    }
    
    public void mouseClicked(MouseEvent me){
    	NC=NC+1;
    	mcx=me.getX();
    	mcy=me.getY();
    	int i,j;
     	if((mcx>=CX)&&(mcy>=CY)&&(mcx<=(CX+6*EX))&&(mcy<=(CY+6*EY))&&!pausa)
    	   {
    		i=(mcy-CY)/EY;
    		j=(mcx-CX)/EX;
    	if(arriba[i][j]!=true&&parejas<=17)
    	{
    		if(!arriba[i][j]){
    			Arriba=Arriba+1;
    			arriba[i][j]=true;
    				if(Arriba==1)
    				{
    				carta1+=tablero.tablero[i][j];
    				o=i;
    				p=j;
    			}
    			if(Arriba==2)
    			    {
    				carta2+=tablero.tablero[i][j];
    				if(carta1==carta2)
    				{
    					JOptionPane.showMessageDialog(null,"Forman una pareja","Memorama en Java", JOptionPane.PLAIN_MESSAGE);
    					Arriba=0;
    					carta1=0;
    					carta2=0;
    				    arriba[i][j]=true;
    					arriba[o][p]=true;
    					parejas=parejas+1;
    					if(parejas==18)
    					     {
    						timer.cancel();
    						JOptionPane.showMessageDialog(null,"Fin del Juego..!!","Memorama en Java", JOptionPane.PLAIN_MESSAGE);	
    						JOptionPane.showMessageDialog(null,"Numero Total de CLICKS: "+NE,"Memorama en Java", JOptionPane.PLAIN_MESSAGE);
    						
    					}
		    		}
		    		else
		    		{
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
    	
    	
    		if(mcx>=700&&mcx<=750&&mcy>=250&&mcy<=280)
    		{
    		System.exit(0);
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
		if(segundos==30){
			JOptionPane.showMessageDialog(null,"Case termina el Juego: "+"\n"+segundos+" Segunos ","Aviso..!!",JOptionPane.PLAIN_MESSAGE);
		}
		if(segundos<=0){
			JOptionPane.showMessageDialog(null,"Fin del Juego"+" ","MEMORAMA",JOptionPane.PLAIN_MESSAGE);
			timer.cancel(); 
			JOptionPane.showMessageDialog(null,"Numero de clicks"+NC);
		}
		segundos--;
	}
}
	
}
