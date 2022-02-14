package com.ej3.UD20B_ej3;

import java.awt.EventQueue;

import View.Contador;

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
					Contador frame = new Contador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
