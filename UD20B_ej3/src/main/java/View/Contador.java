package View;

/**
 * @author JOAN
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int boton1 = 0, boton2 = 0;
	private JLabel etiqueta, etiqueta2; 


	public Contador() 
	{
		
		setTitle("Contador");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		etiqueta = new JLabel("Boton 1: " + boton1 + " veces");
		etiqueta2 = new JLabel("Boton 2: " + boton2 + " veces");
		JButton btn = new JButton("Boton 1");
		JButton btn2 = new JButton("Boton 2");
		
		btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boton1++;
				etiqueta.setText("Boton 1: " + boton1 + " veces");
			}
		});
		
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boton2++;
				etiqueta2.setText("Boton 2: " + boton2 + " veces");
			}
		});
		
		etiqueta.setBounds(10, 26, 162, 20);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta2.setBounds(188, 26, 162, 20);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBounds(42, 57, 89, 23);
		btn2.setBounds(227, 57, 89, 23);
		
		contentPane.add(etiqueta);
		contentPane.add(etiqueta2);
		contentPane.add(btn);
		contentPane.add(btn2);
	}

}
