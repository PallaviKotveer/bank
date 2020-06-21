package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	public Currency CAD, EUR, GBP, HKD, INR;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
		INR = new Currency("INR", 0.013);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		
//		fail("Write test case here");
		assertEquals("CAD", CAD.getName());
		assertEquals("EUR", EUR.getName());
		assertEquals("HKD", HKD.getName());
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
//		fail("Write test case here");
		assertEquals(0.75, CAD.getRate(),0);
		assertEquals(1.14, EUR.getRate(),0);
		assertEquals(0.13, HKD.getRate(),0);
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		assertEquals(0.75, CAD.getRate(),0);
		System.out.println(CAD.getRate());
		CAD.setRate(0.73);
		assertEquals(0.73, CAD.getRate(),0);
		CAD.setRate(0.75);
		
		
		assertEquals(1.14, EUR.getRate(),0);
		System.out.println(EUR.getRate());
		EUR.setRate(0.73);
		assertEquals(0.73, EUR.getRate(),0);
		EUR.setRate(1.14);
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		assertEquals(7.5, CAD.valueInUSD(10),0);
		assertEquals(11.4, EUR.valueInUSD(10),0);
		assertEquals(1.3, HKD.valueInUSD(10),0);
//		assertEquals(1.3, INR.valueInUSD(10),0);
	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		// For this function, you should:
		// 1. Assert the value of the "other" currency
		// 2. Get the value in "this" currency
		// 3. Assert that the value in "this" currency is correct
		// You will end up with 2 assert() statements in this function.
//		fail("Write test case here");
//		asserEquals(23,CAD.)
		assertEquals(0.75, CAD.valueInUSD(1),0);
		System.out.println(EUR.valueInUSD(10));
		assertEquals(6.58, EUR.valueInThisCurrency(10, CAD),0);
		
		assertEquals(0.75, CAD.valueInUSD(1),0);
		System.out.println(HKD.valueInUSD(10));
		assertEquals(57.69, HKD.valueInThisCurrency(10, CAD),0);
		
		
	}

}
