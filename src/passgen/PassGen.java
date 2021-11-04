package passgen;

import java.util.Random;

public class PassGen {

	private static final String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	private static final String[] numbers     = { "1", "2" , "3", "4", "5", "6", "7", "8", "9", "0" };
	private static final String[] symbols     = { "!", "@" , "#", "£", "%", "&", "$", "€", "=", "?" };
	private static final String[] specialChar = {"\\", "\"", "¤", "(", ")", "/", ":", ";", "_"      };

	static int passLength = 16;

	static boolean generateLetters = true;
	public static boolean generateBigLetters = true;
	public static boolean generateNumbers = true;
	public static boolean generateSymbols = true;
	public static boolean generateSpecialChar = true;	

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Window window = new Window();
	}

	public static void gen() {
		
		if (generateLetters == false && generateBigLetters == false && generateNumbers == false && generateSymbols == false && generateSpecialChar == false) {
			System.out.println("error");
			return;
		} 
		else {
			
			int r = new Random().nextInt(5);
			
			if (r == 0) {
				if (generateLetters) {
					String s = Window.generatedPassword.getText();
					Window.generatedPassword.setText(s+getRandom(alphabet, false));
				} else {
					gen();
				}
			}

			if (r == 1) {
				if (generateBigLetters) {
					//System.out.print(getRandom(alphabet, true));
					String s = Window.generatedPassword.getText();
					Window.generatedPassword.setText(s+getRandom(alphabet, true));
				} else {
					gen();
				}
			}

			if (r == 2) {
				if (generateNumbers) {
					//System.out.print(getRandom(numbers, false));
					String s = Window.generatedPassword.getText();
					Window.generatedPassword.setText(s+getRandom(numbers, false));
				} else {
					gen();
				}
			}

			if (r == 3) {
				if (generateSymbols) {
					//System.out.print(getRandom(symbols, false));
					String s = Window.generatedPassword.getText();
					Window.generatedPassword.setText(s+getRandom(symbols, false));
				} else {
					gen();
				}
			}

			if (r == 4) {
				if (generateSpecialChar) {
					//System.out.print(getRandom(specialChar, false));
					String s = Window.generatedPassword.getText();
					Window.generatedPassword.setText(s+getRandom(specialChar, false));
				} else {
					gen();
				}
			}
		}
	}

	public static String getRandom(String[] array, boolean uppercase) {
		int rnd = new Random().nextInt(array.length);
		if (uppercase)
			return array[rnd].toUpperCase();
		return array[rnd];
	}

}
