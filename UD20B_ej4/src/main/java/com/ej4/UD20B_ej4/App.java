package com.ej4.UD20B_ej4;

import java.awt.EventQueue;

import View.EventosVentana;

/**
 * 
 * @author JOAN
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventosVentana frame = new EventosVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
