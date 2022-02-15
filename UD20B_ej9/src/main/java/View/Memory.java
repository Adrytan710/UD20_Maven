package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class Memory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] array = new JButton[4][4];
	
	ImageIcon img1 = new ImageIcon(new ImageIcon("../España.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img2 = new ImageIcon(new ImageIcon("../alemania.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img3 = new ImageIcon(new ImageIcon("../argentina.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img4 = new ImageIcon(new ImageIcon("../brasil.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img5 = new ImageIcon(new ImageIcon("../francia.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img6 = new ImageIcon(new ImageIcon("../inglaterra.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img7 = new ImageIcon(new ImageIcon("../italia.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	ImageIcon img8 = new ImageIcon(new ImageIcon("../portugal.png").getImage().getScaledInstance(75, 50, Image.SCALE_SMOOTH));
	
	private ImageIcon[][] imagenes = {{img1,img1,img2,img2},
									  {img3,img3,img4,img4},
									  {img5,img5,img6,img6},
									  {img7,img7,img8,img8}};
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
				
				array[i][j].addMouseListener(new MouseListener() {
					
					public void mouseReleased(MouseEvent e) 
					{
						
						JButton btn = (JButton)e.getSource();

						if(cont == 0)
						{
							comprobarBoton = btn;
							cont++;
						}
						else
						{
							if(comprobarBoton.getIcon().equals(btn.getIcon()) && comprobarBoton != btn)
							{
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								comprobarBoton.setBackground(new Color(255,255,255));
								comprobarBoton.setIcon(null);
								comprobarBoton.setBorderPainted(false);
								btn.setBackground(new Color(255,255,255));
								btn.setIcon(null);
								btn.setBorderPainted(false);
								parejas--;
							}
							else if(comprobarBoton != btn)
							{
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								comprobarBoton.setEnabled(true);
								comprobarBoton.setIcon(null);
								comprobarBoton.setBackground(new Color(200,200,200));
								btn.setEnabled(true);
								btn.setIcon(null);
								btn.setBackground(new Color(200,200,200));
								cont = 0;
								intentos++;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Seleccione otra casilla.");
							}
						}	
						
						if(parejas == 0)
						{
							JOptionPane.showMessageDialog(null, "Enhorabuena has finalizado el memory con " + intentos + " intentos.");
						}
						
					}
					
					public void mousePressed(MouseEvent e) 
					{
						
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

						btn.setIcon(imagenes[x][y]);
						btn.setMargin(new Insets(0, 0, 0, 0));
						btn.setEnabled(false);
						
					}
					
					public void mouseExited(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseClicked(MouseEvent e) {}
				});
			}
		}
	}
		
	public void shuffleArray()
	{
		for(int i = imagenes.length - 1; i > 0; i--) 
		{
			for (int j = imagenes.length - 1; j > 0; j--) 
			{
				int shuffled_index = (int)Math.floor(Math.random() * (i + 1));
				int shuffled_index2 = (int)Math.floor(Math.random() * (j + 1));

				ImageIcon tmp = imagenes[i][j];

				imagenes[i][j] = imagenes[shuffled_index][shuffled_index2];

				imagenes[shuffled_index][shuffled_index2] = tmp;
			}
	    }
	}
}
