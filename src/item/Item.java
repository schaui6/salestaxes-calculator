package item;


public class Item {
	private double itemPrice;
	private double netTax;
	private double taxRate;
	private double itemQuantity;
	
	public Item(double price, double rate, double quantity) {
		itemPrice = price;
		taxRate = rate;
		itemQuantity = quantity;
	}
	
	public double calculateTotalTax() {
		netTax = itemQuantity * itemPrice * taxRate;
		return netTax; 
	}
	
}