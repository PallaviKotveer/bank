package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100;
	
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
	}

	@Test
	public void testGetAmount() {
		fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {
		fail("Write test case here");
	}

	@Test
	public void testToString() {
		fail("Write test case here");
	}

	@Test
	public void testGetUniversalValue() {
		fail("Write test case here");
	}

	@Test
	public void testEqualsMoney() {
		fail("Write test case here");
	}

	@Test
	public void testAdd() {
		fail("Write test case here");
	}

	@Test
	public void testSubtract() {
		fail("Write test case here");
	}

	@Test
	public void testIsZero() {
		fail("Write test case here");
	}

	@Test
	public void testNegate() {
		fail("Write test case here");
	}

	@Test
	public void testCompareTo() {
		fail("Write test case here");
	}
}
