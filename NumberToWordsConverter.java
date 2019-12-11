import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Code supprts intigers in range from -2,147,483,647 to 2,147,483,647
 * 
 * Code can be run via eclipse or using standard java commands from command prompt
 * 
 * Code validates the inputs for numbers positive and negative in Java integer range.
 * 
 * Valid numbers are converted into equivalent numeric word format 
 */


public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { "", // 0
			"", // 1
			"Twenty", // 2
	
			"Thirty", // 3
			"Forty", // 4
			"Fifty", // 5
			"Sixty", // 6
			"Seventy", // 7
			"Eighty", // 8
			"Ninety" // 9
	};

	public static String convert(final int n) {
		if (n < 0) {

			return "Minus " + convert(-n);

		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "")
					+ convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand"
					+ ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh"
					+ ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore"
				+ ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	private static int getUserInput() {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number to convert into word format in range from -2,147,483,647 to 2,147,483,647");
		n = s.nextInt();
		return n;
	}

	public static void main(final String[] args) {

		int intToConvert;
		try {
			intToConvert = getUserInput();
			System.out.println(intToConvert + "='" + convert(intToConvert)
					+ "'");

		} catch (InputMismatchException e) {

			System.out.println("Enter Valid Integer in range from -2,147,483,647 to 2,147,483,647");

			intToConvert = getUserInput();
			System.out.println(NumberFormat.getInstance().format(intToConvert)
					+ "='" + convert(intToConvert) + "'");
		}
		
		/*
		 * Occurs wehn user inputs -2,147,483,648 
		 */
		catch(StackOverflowError ex){
			System.out.println("Enter Valid Integer in range from -2,147,483,647 to 2,147,483,647");

			intToConvert = getUserInput();
			System.out.println(NumberFormat.getInstance().format(intToConvert)
					+ "='" + convert(intToConvert) + "'");

			
		}
		
	}
}
