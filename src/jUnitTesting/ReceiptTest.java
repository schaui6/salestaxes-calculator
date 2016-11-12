package jUnitTesting;


import static org.junit.Assert.*;
import org.junit.*;


import item.Item;
import receipt.Receipt;

public class ReceiptTest {

	@Test
	public void shouldNotTransactionLineDetailsAsNull() {
		String[] testArray = {"1 book","1 music CD","1 box of perfume","1 chocolate bar"};
		Item testItem = new Item(12.49, 0.00, 1.00);
		Receipt test = new Receipt("1 book at 12.49", testArray, 1.0, 12.49, testItem);
		String output = test.createLine(testArray, 1.0, 12.49, testItem);
		assertNotNull(output);
	}
	@Test
	public void shouldReturnValidTransactionLineDetails() {
		String[] testArray = {"1 book","1 music CD","1 box of perfume","1 chocolate bar"};
		Item testItem = new Item(12.49, 0.00, 1.00);
		Receipt test = new Receipt("1 book at 12.49", testArray, 1.0, 12.49, testItem);
		String output = test.createLine(testArray, 1.0, 12.49, testItem);
		assertEquals("1 book: 12.49", output);
	}
}
