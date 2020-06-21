package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100, HKDDecimal20;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
		HKDDecimal20 = new Money(17.897, HKD);
	}

	@Test
	public void testGetAmount() {
//		 
		assertEquals(200, CAD200.getAmount(),0.01);
		assertEquals(100, CAD100.getAmount(),0.01);
		assertEquals(20, EUR20.getAmount(),0.01);
		assertEquals(0, CAD0.getAmount(),0.01);
		assertEquals(0, EUR0.getAmount(),0.01);
		assertEquals(-100, CADnegative100.getAmount(),0.01);
	}

	@Test
	public void testGetCurrency() {
//	
		assertEquals(CAD, CAD200.getCurrency());
		assertEquals(CAD, CAD100.getCurrency());
		assertEquals(EUR, EUR20.getCurrency());
		assertEquals(CAD, CAD0.getCurrency());
		assertEquals(EUR, EUR0.getCurrency());
		assertEquals(CAD, CADnegative100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("200.0 CAD", CAD200.toString());
		assertEquals("20.0 EUR", EUR20.toString());
		assertEquals("17.897 HKD", HKDDecimal20.toString());
	}

	@Test
	public void testGetUniversalValue() {
		assertEquals(150, CAD200.getUniversalValue(),0.01);
		assertEquals(22.8, EUR20.getUniversalValue(),0.01);
		assertEquals(2.33, HKDDecimal20.getUniversalValue(),0.01);
		assertEquals(-75, CADnegative100.getUniversalValue(),0.01);
	}

	@Test
	public void testEqualsMoney() {
		 
	}

	@Test
	public void testAdd() {
		 
	}

	@Test
	public void testSubtract() {
		 
	}

	@Test
	public void testIsZero() {
		 
	}

	@Test
	public void testNegate() {
		 
	}

	@Test
	public void testCompareTo() {
		 
	}
}
