package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100, HKDDecimal20;
	protected Money CAD10, EUR6;

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
		CAD10 = new Money(10, CAD);
		EUR6 = new Money(6.58, EUR);
	}

	@Test
	public void testGetAmount() {
//		 
		assertEquals(200, CAD200.getAmount(), 0.01);
		assertEquals(100, CAD100.getAmount(), 0.01);
		assertEquals(20, EUR20.getAmount(), 0.01);
		assertEquals(0, CAD0.getAmount(), 0.01);
		assertEquals(0, EUR0.getAmount(), 0.01);
		assertEquals(-100, CADnegative100.getAmount(), 0.01);
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
		assertEquals(150, CAD200.getUniversalValue(), 0.01);
		assertEquals(22.8, EUR20.getUniversalValue(), 0.01);
		assertEquals(2.33, HKDDecimal20.getUniversalValue(), 0.01);
		assertEquals(-75, CADnegative100.getUniversalValue(), 0.01);
	}

	@Test
	public void testEqualsMoney() {
		assertFalse(CAD100.equals(EUR20));
		assertTrue(CAD10.equals(EUR6));
	}

	@Test
	public void testAdd() {
//		Money newMoney = new Money()
		assertEquals(230.4, CAD200.add(EUR20).getAmount(),0.01);
		assertEquals(-65.79, EUR0.add(CADnegative100).getAmount(),0.01);
		assertEquals(660, CADnegative100.add(new Money(500, EUR)).getAmount(),0.01);
		assertEquals(73.33, CADnegative100.add(new Money(1000, HKD)).getAmount(),0.01);

		

	}

	@Test
	public void testSubtract() {
		assertEquals(180.0, CAD200.subtract(EUR20).getAmount(),0.01);
//		CAD200.subtract(EUR10).getAmount(),0.01);
		assertEquals(10.0, EUR10.subtract(EUR0).getAmount(),0.01);
		assertEquals(-110.0, CADnegative100.subtract(EUR10).getAmount(),0.01);
		assertEquals(-300.0, CAD200.subtract(new Money(500, HKD)).getAmount(),0.01);
		assertEquals(15.0, EUR20.subtract(new Money(5, EUR)).getAmount(),0.01);

	}

	@Test
	public void testIsZero() {
		assertTrue(CAD0.isZero());
		assertTrue(EUR0.isZero());
		assertFalse(EUR10.isZero());
		assertFalse(EUR20.isZero());
		assertFalse(CAD200.isZero());
		assertFalse(CADnegative100.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(-10.0, EUR10.negate().getAmount(), 0.01);
		assertEquals(-20.0, EUR20.negate().getAmount(), 0.01);
		assertEquals(-200, CAD200.negate().getAmount(), 0.01);
		assertEquals(-0.0, CAD0.negate().getAmount(), 0.01);
		assertEquals(-0.0, EUR0.negate().getAmount(), 0.01);
		assertEquals(100, CADnegative100.negate().getAmount(), 0.01);

	}

	@Test
	public void testCompareTo() {
		assertEquals(0, CAD0.compareTo(EUR0));
		assertEquals(1, CAD200.compareTo(EUR20));
		assertEquals(1, EUR20.compareTo(EUR10));
		assertEquals(-1, CAD0.compareTo(EUR20));
		assertEquals(-1, EUR10.compareTo(CAD200));
		assertEquals(1, CAD200.compareTo(CADnegative100));
	}
}
