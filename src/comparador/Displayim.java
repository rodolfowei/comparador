package comparador;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Displayim extends JFrame implements ActionListener {
	
	private Container contenedor;
	JButton exit;
	JLabel labeltitulo;
	JLabel labelImagen1;
	JLabel labelImagen2;
	int Height;
	int Width;
	ImageIcon imagein;
	ImageIcon imageout;
	
	public Displayim(BufferedImage in, BufferedImage out){
		
		iniciarComponentes();
		setTitle("Matching");
		Height = in.getHeight();
		Width = in.getWidth();
		setSize(Width, Height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagein = new ImageIcon(in);
		imageout = new ImageIcon(out);
						
	}
	
	
	private void iniciarComponentes()
	{
		contenedor = getContentPane();
		contenedor.setLayout(null);
		exit = new JButton();
		exit.setBounds(390, 430, 60, 30);
		exit.setIcon(new ImageIcon(getClass().getResource("C:/Users/CARLOS/Desktop/Proyecto lectura etiquetas/salir.png")));
		exit.addActionListener(this);
		
		labelImagen1 = new JLabel();
		labelImagen1.setBounds(50,70,400,330);
		labelImagen1.setIcon(imagein); //Ponemos la imagen de referencia
		labelImagen1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		//Esto ya es añadido y puede que no funcione
		labelImagen2 = new JLabel();
		labelImagen2.setBounds(50,70,400,330);
		labelImagen2.setIcon(imageout); //Ponemos la imagen de referencia
		labelImagen2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	
		labeltitulo = new JLabel();
		labeltitulo.setText("setIcon");
		labeltitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 28));
		labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labeltitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		labeltitulo.setBounds(100, 10, 300, 40);
		
		
		//Agragamos los componentes al contenedor
		contenedor.add(labeltitulo);
		contenedor.add(exit);
		contenedor.add(labelImagen1);
		contenedor.add(labelImagen2);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==exit)
		{
			int respuesta = JOptionPane.showInternalConfirmDialog(this, "Sure to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if(respuesta == JOptionPane.YES_NO_OPTION);
			{
				System.exit(0);
			}
		}
		
	}
	

}
