import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;
	private JTextField txtDisplay;
	String v1 = "0"; //Used as part of updating the display.
	String v2 = "0"; //Used to store an existing number so that v1 can update the display.
	String state = " ";
	/* This variable keeps track of what state the program is in, which determines what operation it uses 
	 * when the =btn is pushed.
	 * + = addition
	 * - = subtraction
	 * * = multiplication
	 * / = division
	 * Anything else = stateless, and does nothing.
	 */
	int displaySizeLimit = 14; //The number of digits that the display can hold.
	double displayMaximum = 99999999999999d;
	/* Two parts for the above.
	 * 1. This is the largest number that the display can show. Any larger and the program will have to show
	 * an error message.
	 * 2. The small d at the end is so that the compiler will parse the number as double rather than an int.
	 * You would need to put an l at the end to get it to compile as a long, etc.
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 220, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		txtDisplay = new JTextField();
		txtDisplay.setText("0");
		txtDisplay.setEditable(false);
		// going to try commenting this out. txtDisplay.setToolTipText("");
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Lao UI", Font.PLAIN, 25));
		txtDisplay.setBounds(10, 11, 192, 50);
		frame.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		//*****
		// Buttons 0-9
		//*****
		
		// Appends 0 to the display
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("0");
			}
		});
		btn0.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn0.setBounds(10, 210, 42, 35);
		frame.getContentPane().add(btn0);
		
		// Appends 1 to the display
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				append("1");
			}
		});
		btn1.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn1.setBounds(10, 72, 42, 35);
		frame.getContentPane().add(btn1);
		
		// Appends 2 to the display
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				append("2");
			}
		});
		btn2.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn2.setBounds(60, 72, 42, 35);
		frame.getContentPane().add(btn2);
		
		// Appends 3 to the display
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("3");
			}
		});
		btn3.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn3.setBounds(110, 72, 42, 35);
		frame.getContentPane().add(btn3);

		// Appends 4 to the display
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("4");
			}
		});
		btn4.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn4.setBounds(10, 118, 42, 35);
		frame.getContentPane().add(btn4);
		
		// Appends 5 to the display
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("5");
			}
		});
		btn5.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn5.setBounds(60, 118, 42, 35);
		frame.getContentPane().add(btn5);
		
		// Appends 6 to the display
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("6");
			}
		});
		btn6.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn6.setBounds(110, 118, 42, 35);
		frame.getContentPane().add(btn6);
		
		// Appends 7 to the display
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("7");
			}
		});
		btn7.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn7.setBounds(10, 164, 42, 35);
		frame.getContentPane().add(btn7);
		
		// Appends 8 to the display
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("8");
			}
		});
		btn8.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn8.setBounds(60, 164, 42, 35);
		frame.getContentPane().add(btn8);
		
		// Appends 9 to the display
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				append("9");
			}
		});
		btn9.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btn9.setBounds(110, 164, 42, 35);
		frame.getContentPane().add(btn9);
		
		//*****
		//Function Buttons
		//*****
		
		// multiply button
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = "*";
				if (v2.equals("0")) {
					prep();
				}
				else {
					equalFunction();
				}
			}
		});
		btnMultiply.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnMultiply.setBounds(160, 118, 42, 35);
		frame.getContentPane().add(btnMultiply);
		
		//divide button
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = "/";
				if (v2.equals("0")) {
					prep();
				}
				else {
					equalFunction();
				}
			}
		});
		btnDivide.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnDivide.setBounds(160, 72, 42, 35);
		frame.getContentPane().add(btnDivide);
		
		//subtract button
		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = "-";
				if (v2.equals("0")) {
					prep();
				}
				else {
					equalFunction();
				}
			}
		});
		btnSubtract.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnSubtract.setBounds(160, 164, 42, 35);
		frame.getContentPane().add(btnSubtract);
		
		//add button
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = "+";
				if (v2.equals("0")) {
					prep();
				}
				else {
					equalFunction();
				}
			}
		});
		btnAdd.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnAdd.setBounds(160, 210, 44, 35);
		frame.getContentPane().add(btnAdd);
		
		//equal button
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equalFunction();
				v1 = "0";
				v2 = "0";
				state = " ";
			}
		});
		btnEqual.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnEqual.setBounds(110, 210, 44, 35);
		frame.getContentPane().add(btnEqual);
		
		//clear button
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v1 = "0";
				updateDisplay(v1);
			}
		});
		btnC.setFont(new Font("Lao UI", Font.PLAIN, 15));
		btnC.setBounds(62, 210, 44, 35);
		frame.getContentPane().add(btnC);
	}
	
	
	//*****
	//Misc. Methods
	//*****

	/* append
	 * This method determines whether to append numbers to the end of the current display or to replace the
	 * display with a new number.
	 */
	public void append(String numeral) {
		if (v1.length() > displaySizeLimit) {
			v1 = "0";
			updateDisplay("Error");
		}
		else {
			if (v1 == "0") {
				v1 = numeral;
			}
			else {
				v1 = v1+numeral;
			}
			updateDisplay(v1);
		}
	}

	
	/* updateDisplay
	 * This method updates the display with whatever String is passed to it.
	 */
	public void updateDisplay(String display) {
		txtDisplay.setText(display);
	}
	
	/* prep 
	 * This method stores v1 in v2 and resets v1. This lets the append method continue to affect v1 while v2 can be stored for equations.
	 */
	public void prep() {
		v2 = v1;
		v1 = "0";
		updateDisplay(v1);
	}
	
	
	/* add
	 * This method runs the addition operation on the two numbers passed to it.
	 */
	public String add(String v1, String v2) {
		Double var1 = convert(v1);
		Double var2 = convert(v2);
		Double answer = var2 + var1;
		String a = trim(answer);
		return a;
	}
	/* subtract
	 * This method runs the subtraction operation on the two numbers passed to it.
	 */
	public String subtract(String v1, String v2) {
		Double var1 = convert(v1);
		Double var2 = convert(v2);
		Double answer = var2 - var1;
		String a = trim(answer);
		return a;
	}
	
	/* multiply
	 * This method runs the multiplication operation on the two numbers passed to it.
	 */
	public String multiply(String v1, String v2) {
		Double var1 = convert(v1);
		Double var2 = convert(v2);
		Double answer = var1 * var2;
		String a = trim(answer);
		return a;
	}
	
	/* divide
	 * This method runs the division operation on the two numbers passed to it. It will return an answer of 0
	 * if the user either tries to divide or divide by 0. This appears to be standard among the calculators 
	 * I used as a reference for this project.
	 */
	public String divide(String v1, String v2) {
		if (v1 == "0") {
			return "0";
		}
		else {
			Double var1 = convert(v1);
			Double var2 = convert(v2);
			Double answer = var2/var1;
			String a = trim(answer);
			return a;
		}
	}
	
	
	/* convert
	 * This method converts the strings sent over by the uib into Doubles so that operations may be performed
	 * on them.
	 */
	public Double convert(String v1) {
		Double var = Double.parseDouble(v1); // checks out
		return var;
	}
	
	/* trim
	 * This method trims up the number passed to it so it can be displayed. It rounds to the DisplayLimit 
	 * size if the number would have more digits than the display can show.
	 * 
	 * This calculator cannot handle numbers with more digits the the displaySizeLimit and will not round
	 * numbers that big. Most calculators get around this by using scientific notation, which is outside the
	 * scope of this project. Instead when the number is too big this calculator will return "Error".
	 */
	public String trim(Double var1) {
		int stringSize;
		if (var1 > displayMaximum || var1 < (displayMaximum * -1)) {
		return "Error";
		}
		else {
			DecimalFormat df = new DecimalFormat("#.###########"); 
			/* Only has room for 11 digits after the 0. This is because the display only has room for 14 and
			 * the negative sign, 0, and decimal point all take up room on the display.
			 */
			df.setRoundingMode(RoundingMode.CEILING);
			df.format(var1);
			String v = Double.toString(var1);
			stringSize = v.length();
			if (stringSize > displaySizeLimit) {
				v = "Error"; 
			}
			return v;
		}
	}
	
	/* equalFunction
	 * This method runs the equal function based on the state variable. It will either add, subtract, 
	 * multiply, or divide v1 and v2, and then display the results.
	 */
	public void equalFunction() {
		switch (state) {
		case "+": v2 = add(v1, v2); 
			cleanUp();
			break;
		case "-": v2 = subtract(v1, v2);
			cleanUp();
			break;
		case "*": v2 = multiply(v1, v2);
			cleanUp();
			break;
		case "/": v2 = divide(v1, v2);
			cleanUp();
			break;
		default: break;
		}
	}
	
	/* cleanUp
	 * This method is called to clean up after the equalFunction is called. It updates display to show v2
	 * and sets  v1 to 0 so that the append method works properly. 
	 */
	public void cleanUp() {
		updateDisplay(v2);
		if (v2 == "Error") {
			v2 = "0";
		}
		v1 = "0";
	}
}
