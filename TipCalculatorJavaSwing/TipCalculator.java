/*
 * Name: Khair Ahmed
 * Student ID: 040946481
 * Course & Section: CST8312 310
 * Assignment: Lab 8
 * Date: April 7 2019
 */


/******************************************************************************/


import java.awt.EventQueue;

public class TipCalculator {
	/*** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipCalculatorFrame frame = new TipCalculatorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
