package passgen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class Window implements ActionListener {

	public String name = "Password Generator";
	public String version = "0.0.1";

	public static final int width = 500;
	public static final int height = 300;

	JFrame frame = new JFrame(name);
	JLabel passlengthlabel = new JLabel("Password Length (number)");
	JLabel generateLetterslabel = new JLabel("e.g. a, t, s, r, l...");
	JLabel generateBigLetterslabel = new JLabel("e.g. A, T, S, R, L... ");
	JLabel generateNumberslabel = new JLabel("e.g. 1, 5, 6, 9, 2...");
	JLabel generateSymbolslabel = new JLabel("e.g. !,  %,  @,  £,  =...");
	JLabel generateSpecialCharlabel = new JLabel("e.g. ¤,  /,   _,  ; ,   :...");

	JTextField passlength = new JTextField("max recomended 9999");
	JRadioButton generateLetters = new JRadioButton("Generate letters?");
	JRadioButton generateBigLetters = new JRadioButton("Generate capital letters?");
	JRadioButton generateNumbers = new JRadioButton("Generate numbers?");
	JRadioButton generateSymbols = new JRadioButton("Generate symbols?");
	JRadioButton generateSpecialChar = new JRadioButton("Generate special chararacters?");

	JButton generatePassword = new JButton("Generate Password");
	JButton copyPassword = new JButton("Copy Password");
	static JTextField generatedPassword = new JTextField();

	public Window() {

		//
		// x how far from left // (padding)
		// y how far from the top // (padding)
		// z width // (175 good width)
		// w height
		//

		passlengthlabel.setBounds(10, 25, 175, 25);
		generateLetterslabel.setBounds(10, 50, 175, 25);
		generateBigLetterslabel.setBounds(10, 75, 175, 25);
		generateNumberslabel.setBounds(10, 100, 175, 25);
		generateSymbolslabel.setBounds(10, 125, 175, 25);
		generateSpecialCharlabel.setBounds(10, 150, 175, 25);

		int paddingLeft = 200;
		passlength.setBounds(paddingLeft, 25, 175, 20);
		generateLetters.setBounds(paddingLeft, 50, 175, 25);
		generateBigLetters.setBounds(paddingLeft, 75, 175, 25);
		generateNumbers.setBounds(paddingLeft, 100, 175, 25);
		generateSymbols.setBounds(paddingLeft, 125, 175, 25);
		generateSpecialChar.setBounds(paddingLeft, 150, 225, 25);

		
		copyPassword.setBounds(10, 175, 175, 30);
		generatePassword.setBounds(paddingLeft, 175, 175, 30);
		generatedPassword.setBounds(10, 225, width-30, 30);

		generateLetters.addActionListener(this);
		passlength.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	 passlength.setEditable(true);
	             } else {
	            	 passlength.setEditable(false);
	            	 
	            	 passlength.setText("");
	             }
	          }
	       });

		frame.add(passlengthlabel);
		frame.add(generateLetterslabel);
		frame.add(generateBigLetterslabel);
		frame.add(generateNumberslabel);
		frame.add(generateSymbolslabel);
		frame.add(generateSpecialCharlabel);

		frame.add(passlength);
		frame.add(generateLetters);
		frame.add(generateBigLetters);
		frame.add(generateNumbers);
		frame.add(generateSymbols);
		frame.add(generateSpecialChar);

		frame.add(copyPassword);
		frame.add(generatePassword);
		frame.add(generatedPassword);

		generatePassword.setFocusable(false);
		copyPassword.setFocusable(false);
		generatePassword.addActionListener(this);
		copyPassword.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generatePassword) {

			String s = passlength.getText();
			
			if (s.contains(" ") || s.isBlank()) { 
				System.out.println("error");
				return;
			}
			int is = Integer.valueOf(s);
			
			
			
			if (!generateLetters.isSelected())
				PassGen.generateLetters = false;
			if (generateLetters.isSelected())
				PassGen.generateLetters = true;
			
			if (!generateBigLetters.isSelected())
				PassGen.generateBigLetters = false;
			if (generateBigLetters.isSelected())
				PassGen.generateBigLetters = true;
			
			if (!generateNumbers.isSelected())
				PassGen.generateNumbers = false;
			if (generateNumbers.isSelected())
				PassGen.generateNumbers = true;
			
			if (!generateSymbols.isSelected())
				PassGen.generateSymbols = false;
			if (generateSymbols.isSelected())
				PassGen.generateSymbols = true;
			
			if (!generateSpecialChar.isSelected())
				PassGen.generateSpecialChar = false;
			if (generateSpecialChar.isSelected())
				PassGen.generateSpecialChar = true;

			generatedPassword.setText("");
			for (int i = 0; i < is; i++) {
				PassGen.gen();
			}
			return;
		}
		if (e.getSource() == copyPassword) { 
			String pass = generatedPassword.getText();
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(pass), null);
		}
	}
}
