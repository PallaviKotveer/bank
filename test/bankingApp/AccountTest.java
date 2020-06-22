package bankingApp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	protected Account testAccount1;


	@Before
	public void setUp() throws Exception {
		
		// Setup test currencies
		CAD = new Currency("CAD", 0.75);
		HKD= new Currency("HKD", 0.13);
		RBC = new Bank("Royal Bank of Canada", CAD);
		HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		TD = new Bank("Toronto-Dominion Bank",CAD);
		// Setup test accounts
		RBC.openAccount("Peter");
		HSBC.openAccount("Pallavi");
		TD.openAccount("Garvit");
		// setup an initial deposit
		RBC.deposit("Peter", new Money(1100, CAD));
		TD.deposit("Garvit",new Money(560, CAD));
		HSBC.deposit("Pallavi", new Money(1400, HKD));
	}

	@Test
	public void testAddWithdraw() throws AccountDoesNotExistException {
		//Withdrawing using different currency
		RBC.withdraw("Peter", new Money(100, HKD));
		assertEquals(1000, RBC.getBalance("Peter"),.01);
		
		//Withdrawing using different currency
		TD.withdraw("Garvit", new Money(53.5, CAD));
		assertEquals(506.5, TD.getBalance("Garvit"),.01);
				
		//Withdrawing using different currency
		HSBC.withdraw("Pallavi", new Money(33.2, CAD));
		assertEquals(1366.8, HSBC.getBalance("Pallavi"),.01);
		
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(1100, RBC.getBalance("Peter"),.01);
		assertEquals(560, TD.getBalance("Garvit"),.01);
		assertEquals(1400.0, HSBC.getBalance("Pallavi"),.01);
		
	}
}
