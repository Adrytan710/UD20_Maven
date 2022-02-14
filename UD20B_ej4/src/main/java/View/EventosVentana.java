package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 
 * @author JOAN
 *
 */
public class EventosVentana extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea text;

	public EventosVentana() 
	{
		setTitle("Contador");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel etiqueta = new JLabel("Eventos");
		etiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		text = new JTextArea("Texto inicial");
		text.setEditable(false);
		
		etiqueta.setBounds(10, 123, 69, 20);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(89, 72, 255, 125);
		
		addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Abierta");
			}
			
			public void windowIconified(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Minimizada");
			}
			
			public void windowDeiconified(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Desminimizada");
			}
			
			public void windowDeactivated(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Descativada");
			}
			
			public void windowClosing(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Cerrando");
			}
			
			public void windowClosed(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Cerrada");
			}
			
			public void windowActivated(WindowEvent e) 
			{
				text.setText(text.getText() + "\nVentana Activada");
			}
		});
		
		contentPane.add(etiqueta);
		contentPane.add(text);
	}

}
