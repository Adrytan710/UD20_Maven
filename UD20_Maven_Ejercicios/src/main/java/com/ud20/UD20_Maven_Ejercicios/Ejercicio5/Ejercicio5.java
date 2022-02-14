package com.ud20.UD20_Maven_Ejercicios.Ejercicio5;

import java.awt.event.*;
import javax.swing.*;

public class Ejercicio5 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaTxt;
	 
	public Ejercicio5() {
		JButton boton = new JButton("Limpiar");
		areaTxt = new JTextArea(15,60);
		JPanel panel = new JPanel();
		panel.add(boton);
		panel.add(areaTxt);
		add(panel);
		
		ActionListener accion = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaTxt.setText("");
			}
		};
		
		MouseListener eventos = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				areaTxt.append("\nHas hecho click en ");
				areaTxt.append("\nPosición X: " + e.getX());
				areaTxt.append("\nPosición Y: " + e.getY());
			}
			public void mousePressed(MouseEvent e) {
				if (((e.getModifiers() & InputEvent.BUTTON3_MASK) !=0)) {
					areaTxt.append("\nHas pulsado el botón derecho");
				}
				areaTxt.append("\nSe ha soltado el botón del ratón");
			}
			public void mouseEntered(MouseEvent e) {
				areaTxt.append("\nEl ratón ha entrado dentro de la ventana");
			}
			public void mouseExited(MouseEvent e) {
				areaTxt.append("\nEl ratón ha salido fuera de la ventana");
			}
			public void mouseReleased(MouseEvent e) {
				areaTxt.append("\nSe ha soltado el botón del ratón");
				
			}
		};
		
		boton.addActionListener(accion);
		areaTxt.addMouseListener(eventos);
	}
}