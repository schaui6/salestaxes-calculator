import java.io.*;
import basketParser.BasketParser;
import receipt.Receipt;

public class MainProgram {
	public static double totalSalesTaxes = 0; 
	public static double totalCost = 0; 

	public static void main(String[] args) throws FileNotFoundException {
		BasketParser.parseBasket();
		Receipt.printTransactionLines();
		Receipt.displayTotals();
	}
}
	