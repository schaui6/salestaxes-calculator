package mainProgram;

import java.io.*;
import basketParser.BasketParser;
import receipt.Receipt;

public class MainProgram {
	public static void main(String[] args) throws FileNotFoundException {
		BasketParser.parseBasket();
		Receipt.displayTotals();
	}
}
	