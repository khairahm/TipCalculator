/*
 * Name: Khair Ahmed
 * Student ID: 040946481
 * Course & Section: CST8312 310
 * Assignment: Lab 8
 * Date: April 7 2019
 */


/******************************************************************************/


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.text.DecimalFormat;

public class TipCalculatorFrame extends JFrame {
	private JLabel amountLabel;
	private JLabel tipPercentageLabel;
	private JLabel tipLabel;
	private JLabel totalLabel;
	private JTextField amountTextField;
	private JSlider tipPercentageSlider;
	private JTextField tipTextField;
	private JTextField totalTextField;
	private JButton calculatorButton;
	private GridBagLayout grid;
	private GridBagConstraints position;
	private DecimalFormat df;

	
	public TipCalculatorFrame() {
		super("Tip Calculator");
		df = new DecimalFormat("# ### ### ### ##0.00");
		grid = new GridBagLayout();
		position = new GridBagConstraints();
		position.gridx =0;
		position.gridy =0;
		setLayout(grid);
		setSize(300,200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Row 1
		//Create the label and place it
		amountLabel = new JLabel("Amount: ");
		add((amountLabel),position);
		// change the position of the grid so next object can be placed

		position.gridx++;
		
		// Create the Textfield and place it
		amountTextField = new JTextField(20);
		amountTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();// Each time user types of something add it to the input
				if ((input <'0'||input >'9')&& input!= '\b'&& input!= '.') {
					//If use type something that isnt a 0-9, isnt backspace, or isnt a peroid, we block it from being entered in the textfield
					e.consume();
				}
			}
		});
		add((amountTextField),position);
		// change the position of the grid so next object can be placed

		position.gridx =0;
		position.gridy++;
		
		//Row 2
		//Create the JLabel and place it in the gridbag and then move the position over one
		tipPercentageLabel = new JLabel("15%");
		//move position over
		add((tipPercentageLabel),position);
		position.gridx++;
		
		// Create the JSlider and place it in the grid bag and the move the position over
		tipPercentageSlider = new JSlider(JSlider.HORIZONTAL, 1, 30, 15);
		tipPercentageSlider.addChangeListener(new ChangeListener() {

			
			public void stateChanged(ChangeEvent e) {
				//call setTipPercentage method which takes the value of the slider 
				setTipPercentage(tipPercentageSlider.getValue());
			}
			
		});
		add((tipPercentageSlider),position);
		// change the position of the grid so next object can be placed

		position.gridx =0;
		position.gridy++;
		
		//Row 3
		// Create a tip label and place it
		tipLabel = new JLabel("Tip: ");
		add((tipLabel),position);
		// change the position of the grid so next object can be placed
		position.gridx++;
		
		// Create tipText field and place it 
		tipTextField = new JTextField(20);
		tipTextField.setEditable(false);
		add((tipTextField), position);
		//Change position of grid so next object can be placed
		position.gridx =0;
		position.gridy++;
		
		//Row Four
		//Create totalLabel and place it
		totalLabel = new JLabel ("Total: ");
		add((totalLabel), position);
		//Change position of grid so next object can be placed
		position.gridx++;
		
		totalTextField = new JTextField(20); 
		totalTextField.setEditable(false);
		add((totalTextField),position);
		//Change position of grid so next object can be placed
		position.gridy++;
		
		calculatorButton = new JButton("Calculate");
		calculatorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				calculateResults();
			}
			
		});
		add((calculatorButton),position);
			

	}
	//Method that sets the tipPercentage label to whatever the the value of the slider is
	public void setTipPercentage(int value) {
		tipPercentageLabel.setText(value +"% ");
	}
	
	public void calculateResults() {
	double tipPercentage = (tipPercentageSlider.getValue()/100.0);
	double amount=0;
	double tipAmount;
	double total = 0 ;
	
	try {
	amount = Double.valueOf(amountTextField.getText());
	}catch(Exception e)	{
		totalTextField.setText("Invalid: Too many periods");
	}
	
	tipAmount = amount*tipPercentage;
	tipTextField.setText(df.format(tipAmount));
	
	total = amount*(1+tipPercentage);
	totalTextField.setText(df.format(total));
	
	}
}
