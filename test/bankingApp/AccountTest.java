package bankingApp;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Account;
import bankingApp.AccountDoesNotExistException;
import bankingApp.Bank;
import bankingApp.Currency;
import bankingApp.Money;

import static org.junit.Assert.*;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		
		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal Bank of Canada", CAD);
		
		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		RBC.deposit("Peter", new Money(500, CAD));
	}

	@Test
	public void testAddWithdraw() {
		// Something to consider - can you withdraw in a different currency?
		fail("Write test case here");
		
	}
	
	@Test
	public void testGetBalance() {
		fail("Write test case here");
	}
}
