package comparador;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayApp extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String ruta,nombre;

	private JFrame frame;
	private JTextField text_browse;
	
	private JLabel label_in_image;
	private JLabel label_out_image;
	private JButton buton_browse;
	private JButton buton_search;


	
	public DisplayApp() {
		initialize();
	}

	
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 492, 318);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		label_in_image = new JLabel("IN PROD");
		label_in_image.setHorizontalAlignment(SwingConstants.CENTER);
		label_in_image.setBounds(41, 138, 115, 115);
		getFrame().getContentPane().add(label_in_image);
		
		label_out_image = new JLabel("FIND_PROD");
		label_out_image.setHorizontalAlignment(SwingConstants.CENTER);
		label_out_image.setBounds(189, 138, 115, 115);
		getFrame().getContentPane().add(label_out_image);
		
		text_browse = new JTextField();
		text_browse.setBounds(41, 35, 263, 20);
		getFrame().getContentPane().add(text_browse);
		text_browse.setColumns(10);
		
		buton_browse = new JButton("Browse");
		buton_browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BotonbrowseActionPerformed(evt);
			}
		});
		buton_browse.setBounds(345, 34, 100, 23);
		getFrame().getContentPane().add(buton_browse);
		
		buton_search = new JButton("Search at DB");
		buton_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BotonsearchDBActionPerformed(evt);
			}
		});
		buton_search.setBounds(345, 79, 100, 23);
		getFrame().getContentPane().add(buton_search);
	}
	
	private void BotonbrowseActionPerformed(ActionEvent evt){
		final JFileChooser elegirImagen = new JFileChooser();
		elegirImagen.setMultiSelectionEnabled(false);
		int o = elegirImagen.showOpenDialog(elegirImagen); 
		
		if (o == JFileChooser.APPROVE_OPTION ) {
			ruta = elegirImagen.getSelectedFile().getAbsolutePath();
			nombre = elegirImagen.getSelectedFile().getName();
			text_browse.setText(ruta);
			Image preview = Toolkit.getDefaultToolkit().getImage(ruta);
			if (preview != null) {
				label_in_image.setText("");
				ImageIcon icon = new ImageIcon(preview.getScaledInstance(label_in_image.getWidth(),label_in_image.getHeight(), Image.SCALE_DEFAULT));
				label_in_image.setIcon(icon);
				
				
			}
		}
		
	}
	
	private void BotonsearchDBActionPerformed(ActionEvent evt){
		
		if(!ruta.equals("")){
			
			String in_imagePath = ruta;
			Matcomparison comparador = new Matcomparison();
			Producto encontrado = comparador.obtainbestmatch(in_imagePath);
			
			 
			String imagenfind  = encontrado.path;
			nombre = encontrado.productname;
			Image find_prod = Toolkit.getDefaultToolkit().getImage(imagenfind);
			if(find_prod != null){
				label_out_image.setText("");
				ImageIcon icon = new ImageIcon(find_prod.getScaledInstance(label_out_image.getWidth(), label_out_image.getHeight(), Image.SCALE_DEFAULT));
				label_out_image.setIcon(icon);
			}
		}
	

	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
		
		
	
}
