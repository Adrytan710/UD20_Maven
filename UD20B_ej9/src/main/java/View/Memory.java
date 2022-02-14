package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class Memory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] array = new JButton[4][4];
	private Color[][] colores = {{new Color(250,4,4),new Color(250,4,4),new Color(250,164,4),new Color(250,164,4)},
								{new Color(4,11,250),new Color(4,11,250),new Color(138,4,250),new Color(138,4,250)},
								{new Color(4,250,4),new Color(4,250,4),new Color(235,250,4),new Color(235,250,4)},
								{new Color(250,4,235),new Color(250,4,235),new Color(3,251,195),new Color(3,251,195)}};
	private GridBagLayout gbl_contentPane;
	private int cont = 0, intentos = 0, parejas = 8;
	private JButton comprobarBoton;

	public Memory() 
	{
		setTitle("Memory");
		setBounds(400, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		shuffleArray();
		inicializarArray();
	}
	
	
	public void inicializarArray()
	{
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				array[i][j] = new JButton();
				GridBagConstraints gbc_btn = new GridBagConstraints();
				gbc_btn.fill = GridBagConstraints.BOTH;
				gbc_btn.gridx = i;
				gbc_btn.gridy = j;
				contentPane.add(array[i][j], gbc_btn);
				array[i][j].setBackground(new Color(200,200,200));
				
				array[i][j].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						JButton btn = (JButton)e.getSource();
						
						int x = 0, y = 0;
						
						for (int i = 0; i < 4; i++) 
						{
							for (int j = 0; j < 4; j++) 
							{
								if(array[i][j] == (btn))
								{
									x = i;
									y = j;
								}
							}
						}
						
						btn.setBackground(colores[x][y]);
						btn.setEnabled(false);

						if(cont == 0)
						{
							comprobarBoton = btn;
							cont++;
						}
						else
						{
							if(comprobarBoton.getBackground().equals(btn.getBackground()))
							{
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								comprobarBoton.setBackground(new Color(255,255,255));
								comprobarBoton.setBorderPainted(false);
								btn.setBackground(new Color(255,255,255));
								btn.setBorderPainted(false);
								parejas--;
							}
							else
							{
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								comprobarBoton.setEnabled(true);
								comprobarBoton.setBackground(new Color(200,200,200));
								btn.setEnabled(true);
								btn.setBackground(new Color(200,200,200));
							}
							cont = 0;
							intentos++;
						}	
						
						if(parejas == 0)
						{
							JOptionPane.showMessageDialog(null, "Enhorabuena has finalizado el memory con " + intentos + " intentos.");
						}
						
					}
				});
			}
		}
	}
		
	public void shuffleArray()
	{
		for(int i = colores.length - 1; i > 0; i--) 
		{
			for (int j = colores.length - 1; j > 0; j--) 
			{
				int shuffled_index = (int)Math.floor(Math.random() * (i + 1));
				int shuffled_index2 = (int)Math.floor(Math.random() * (j + 1));

				Color tmp = colores[i][j];

				colores[i][j] = colores[shuffled_index][shuffled_index2];

				colores[shuffled_index][shuffled_index2] = tmp;
			}
	    }
	}
}
