package jUnitTesting;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import taxRateVerifier.TaxRateVerifier;

public class taxRateVerifierTest {

	private TaxRateVerifier test;

	@Before
	public void setup() {
		test = new TaxRateVerifier();	
	}
	
	@Test
	public void setTaxRateShouldNotBeNull() {
		double output = test.setTaxRate("");
		assertNotNull(output);
	}
	
	@Test
	public void shouldDetermineTaxRateForImportDutyAndSalesTax() {
		double output = test.setTaxRate("1 imported bottle of perfume at 47.50");
		assertEquals(0.15, output, 0.00);
	}
	
	@Test
	public void shouldDetermineTaxRateForOnlyImportDuty() {
		double output = test.setTaxRate("1 imported box of chocolates at 10.00");
		assertEquals(0.05, output, 0.00);
	}
	
	@Test
	public void shouldDetermineTaxRateForOnlySalesTax() {
		double output = test.setTaxRate("1 music CD at 14.99");
		assertEquals(0.10, output, 0.00);
	}

	@Test
	public void shouldDetermineTaxRateForTaxExemption() {
		double output = test.setTaxRate("1 book at 12.49");
		assertEquals(0.00, output, 0.00);
	}
	
	@Test
	public void shouldDetermineIfTaxExempt() {
		boolean output = test.isSalesTaxExempt("1 book at 12.49");
		assertEquals(true, output);
	}
	
	@Test
	public void shouldDetermineIfNotTaxExempt() {
		boolean output = test.isSalesTaxExempt("1 music CD at 14.99");
		assertEquals(false, output);
	}
	
	@Test
	public void shouldDetermineIfNotImportDutyExempt() {
		boolean output = test.isSalesTaxExempt("1 music CD at 14.99");
		assertEquals(false, output);
	}
	
	@Test
	public void shouldDetermineIfImportDutyExempt() {
		boolean output = test.isSalesTaxExempt("1 imported box of chocolates at 10.00");
		assertEquals(true, output);
	}

	@After
	public void tearDown() {
		test = null;
	}
}
