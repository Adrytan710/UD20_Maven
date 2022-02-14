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

public class IMC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField altura, peso, imc;
	
	public IMC() 
	{
		setTitle("Indice de Masa Corporal");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel etiqueta = new JLabel("Altura (Metros)");
		JLabel etiqueta2 = new JLabel("Peso (Kg)");
		JLabel etiqueta3 = new JLabel("IMC");
		altura = new JTextField();
		peso = new JTextField();
		imc = new JTextField();
		JButton btn = new JButton("Calcular IMC");
		
		btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					imc.setText("" + (double)Math.round((Double.parseDouble(peso.getText()) / Math.pow(Double.parseDouble(altura.getText()), 2))*100)/100);
				} 
				catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Introduzca correctamente los datos");
				}
			}
		});
		
		etiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta.setBounds(10, 11, 98, 20);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta2.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta2.setBounds(196, 11, 69, 20);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta3.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiqueta3.setBounds(171, 42, 69, 20);
		etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBounds(38, 42, 112, 20);
		altura.setBounds(114, 11, 69, 20);
		peso.setBounds(275, 11, 69, 20);
		imc.setBounds(235, 42, 69, 20);
		imc.setEditable(false);
		
		contentPane.add(etiqueta);
		contentPane.add(etiqueta2);
		contentPane.add(etiqueta3);
		contentPane.add(btn);
		contentPane.add(altura);
		contentPane.add(peso);
		contentPane.add(imc);
	}

}
