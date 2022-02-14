package com.ej6.UD20B_ej6;

import java.awt.EventQueue;

import View.IMC;

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
					IMC frame = new IMC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
