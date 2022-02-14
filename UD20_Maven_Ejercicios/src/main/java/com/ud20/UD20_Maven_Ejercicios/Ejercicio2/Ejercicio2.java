package com.ud20.UD20_Maven_Ejercicios.Ejercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ejercicio2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta;
	private JButton boton1, boton2;
	private JPanel panel;
	 
	public Ejercicio2() {
		etiqueta = new JLabel("No se ha pulsado ningún botón");
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		panel = new JPanel();
		panel.add(etiqueta);
		panel.add(boton1);
		panel.add(boton2);
		add(panel);
		
		ActionListener accion = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton boton = (JButton) e.getSource();
				etiqueta.setText("Has pulsado: " + boton.getText());
					
			}
		};
		
		boton1.addActionListener(accion);
		boton2.addActionListener(accion);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana con interacción");
		setSize(400, 300);
		setVisible(true);
	}
}
