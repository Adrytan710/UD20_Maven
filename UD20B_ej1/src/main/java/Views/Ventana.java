package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author JOAN
 *
 */

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ventana() 
	{
		setTitle("Ventana");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel etiqueta = new JLabel("Hello World!");
		
		etiqueta.setBounds(60, 45, 265, 20);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPane.add(etiqueta);
	}

}
