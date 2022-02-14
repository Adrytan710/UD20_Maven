package com.ej8.UD20B_ej8;

import java.awt.EventQueue;

import View.CambioMoneda;

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
					CambioMoneda frame = new CambioMoneda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
