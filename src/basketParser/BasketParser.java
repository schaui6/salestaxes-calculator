package basketParser;

import java.io.*;
import java.util.Scanner;
import item.Item;
import taxRateVerifier.TaxRateVerifier;
import receipt.Receipt;

public class BasketParser {
	private static Scanner fileName;
	public static double totalSalesTaxes = 0; 
	public static double totalCost = 0;
	public static String[] lineData = new String[20];
	public static int counter = 0;
	
	// receives the input file and parses through it
	public static void parseBasket() throws FileNotFoundException{
		// prompt user to enter an input file
		System.out.println("Please enter the filename of input (input1.txt ,input2.txt or input3.txt)");
		
		// stores user's input
		fileName = new Scanner(System.in);
		String input = fileName.nextLine();
		
		// receives the input file
		File textFile = new File(input);
		Scanner in = new Scanner(textFile);

		// iterates through file line by line
		while (in.hasNextLine()){

			// parse through each line and assign variables for easy access
			String records  = in.nextLine();
			String[] fields = records.split(" at ");
			double price = Double.parseDouble(fields[1]);
			double rate = TaxRateVerifier.setTaxRate(records);
			String[] itemQty = fields[0].split(" ");
			double quantity = Double.parseDouble(itemQty[0]);

			// instantiates an item object
			Item product = new Item(price, rate, quantity);
			
			// instantiates a receipt object
			Receipt basket = new Receipt(records, fields, quantity, price, product);

			// stores transaction details
			lineData[counter] = basket.createLine(fields, quantity, price, product);
			counter++;
	
			// stores receipt totals
			totalSalesTaxes += ( Math.round( (quantity * price * rate * 100.0 ) ) / 100.0 );
			totalCost += ( Math.round( (quantity * price + product.calculateTotalTax() ) * 100.0 ) / 100.0 );
		}
	// exits the file	
	in.close();
	}
}


