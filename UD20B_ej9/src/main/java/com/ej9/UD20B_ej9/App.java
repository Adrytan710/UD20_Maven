package com.ej9.UD20B_ej9;

import java.awt.EventQueue;

import View.Memory;

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
					Memory frame = new Memory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
