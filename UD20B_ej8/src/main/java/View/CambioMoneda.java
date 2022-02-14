package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author JOAN
 *
 */
public class CambioMoneda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField moneda, conversion;
	private boolean ptas_euros = false;
	private JButton btn;

	public CambioMoneda() 
	{
		setTitle("Calculadora cambio de monedas");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel etiqueta = new JLabel("Cantidad a convertir");
		JLabel etiqueta2 = new JLabel("Resultado");
		moneda = new JTextField();
		conversion = new JTextField();
		btn = new JButton("Euros a ptas");
		JButton btn2 = new JButton("Cambiar");
		JButton btn3 = new JButton("Borrar");
		
		btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ptas_euros)
				{
					btn.setText("Euros a ptas");
				}
				else
				{
					btn.setText("Ptas a euros");
				}
				
				ptas_euros = !ptas_euros;
			}
		});
		
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					if(ptas_euros)
					{
						conversion.setText("" + (double)Math.round((Double.parseDouble(moneda.getText())/166.386) * 100) / 100);
					}
					else
					{
						conversion.setText("" + (double)Math.round((Double.parseDouble(moneda.getText())*166.386) * 100) / 100);
					}
				} 
				catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Introduzca correctamente los datos");
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				moneda.setText("");
				conversion.setText("");
			}
		});
		
		etiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta.setBounds(10, 11, 127, 20);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta2.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta2.setBounds(218, 11, 69, 20);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBounds(38, 42, 112, 20);
		btn2.setBounds(160, 42, 97, 20);
		btn3.setBounds(267, 42, 89, 20);
		moneda.setBounds(139, 11, 69, 20);
		conversion.setBounds(287, 11, 69, 20);
		conversion.setEditable(false);
		
		contentPane.add(etiqueta);
		contentPane.add(etiqueta2);
		contentPane.add(btn);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(moneda);
		contentPane.add(conversion);
	}

}
