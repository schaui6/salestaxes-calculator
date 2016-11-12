package jUnitTesting;



import static org.junit.Assert.*;

import org.junit.*;

import item.Item;

public class ItemTaxAmountTest {
	
	private Item test;

	@Before
	public void setup() {
		test = new Item(14.99, 0.10, 1.00);	
	}
	
	@Test
	public void shouldReturnValidTaxAmountBeforeRounding() {
		double output = test.calculateTotalTax();
		assertEquals(1.499, output, 0.00);
	}
	
	@Test
	public void taxAmountShouldNotReturnNull() {
		double output = test.calculateTotalTax();
		assertNotNull(output);
	}
	
	@After
	public void tearDown() {
		test = null;
	}
}
