package receipt;

import item.Item;
import basketParser.BasketParser;

public class Receipt {
	
	
	public Receipt(String records, String[] fields, double quantity, double price, Item product) {
	}
    
	// creates transaction details to be stored
	public String createLine(String[] fields, double quantity, double price, Item product) {
		String lineHeader = fields[0] + ": ";
		String linePrice = String.format( "%.2f", ( Math.round( (quantity * price + product.calculateTotalTax( ) ) * 100.0 ) / 100.0 ) );
		return lineHeader + linePrice ;
	}
	
	// prints transaction details
	public static void printTransactionLines(){
		int index = 0;
		while (index < BasketParser.counter) { 
			System.out.println(BasketParser.lineData[index]);
			index++;
		}
	}
	
	public static void displayTotals(){
		System.out.println("Sales Taxes: " + String.format( "%.2f", BasketParser.totalSalesTaxes ) );
		System.out.println("Total: " + String.format( "%.2f", BasketParser.totalCost ) );
	}
}
