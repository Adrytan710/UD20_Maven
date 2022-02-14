package com.ej1.UD20B_ej1;

import java.awt.EventQueue;

import Views.Ventana;

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
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
