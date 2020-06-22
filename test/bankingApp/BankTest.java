package bankingApp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;

	@Before
	public void setUp() throws Exception {

		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);

		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("Toronto-Dominion Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);

		// Opening accounts per each Bank:
		this.TD.openAccount("Garvit");
		this.HSBC.openAccount("Pallavi");
		this.RBC.openAccount("Sachin");
		this.HSBC.openAccount("Niranjan");

		// setup an initial deposit
		TD.deposit("Garvit", new Money(1100, CAD));
		HSBC.deposit("Pallavi", new Money(1555, HKD));
		RBC.deposit("Sachin", new Money(550, CAD));
		HSBC.deposit("Niranjan", new Money(1000, HKD));
	}

	@Test
	public void testGetName() {
		assertEquals("Toronto-Dominion Bank", TD.getName());
		assertEquals("Royal Bank of Canada", RBC.getName());
		assertEquals("Hong Kong Shanghai Banking Corporation", HSBC.getName());
	}

	@Test
	public void testGetCurrency() {

		assertEquals(CAD, RBC.getCurrency());
		assertEquals("CAD", RBC.getCurrency().getName());
		assertEquals(CAD, TD.getCurrency());
		assertEquals("CAD", TD.getCurrency().getName());
		assertEquals(HKD, HSBC.getCurrency());
		assertEquals("HKD", HSBC.getCurrency().getName());

	}

	@Test
	public void testOpenAccount() throws AccountDoesNotExistException, AccountExistsException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		// See the example in class notes for testing exceptions.

		// Testing exception (Accounts already exist)
		assertThrows(AccountExistsException.class, () -> this.RBC.openAccount("Sachin"));
		assertThrows(AccountExistsException.class, () -> this.TD.openAccount("Garvit"));
		assertThrows(AccountExistsException.class, () -> this.HSBC.openAccount("Pallavi"));
		assertThrows(AccountExistsException.class, () -> this.HSBC.openAccount("Niranjan"));
//		this.HSBC.openAccount("abc");

//		assertEquals(null, this.HSBC.openAccount("abc"));
		this.HSBC.openAccount("xyz");
		assertEquals("add 1 account from list", 3, HSBC.getAccountList().size());

	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		// See the example in class notes for testing exceptions.

		// Testing deposit using the same currency
		RBC.deposit("Sachin", new Money(158.56, CAD));
		TD.deposit("Garvit", new Money(1556.441, CAD));
		HSBC.deposit("Pallavi", new Money(389.7929, HKD));
		assertEquals(708.56, RBC.getBalance("Sachin"), 0.01);
		assertEquals(2656.44, TD.getBalance("Garvit"), .01);
		assertEquals(1944.79, HSBC.getBalance("Pallavi"), .01);

		// Testing deposit from different currency
		HSBC.deposit("Niranjan", new Money(50.281, CAD));
		assertEquals(1290.08, HSBC.getBalance("Niranjan"), .01);

		// Testing exception (Accounts do not exist)
		assertThrows(AccountDoesNotExistException.class, () -> this.RBC.deposit("Eddi", new Money(1200.231, CAD)));
		assertThrows(AccountDoesNotExistException.class, () -> this.TD.deposit("Sara", new Money(110.231, CAD)));
		assertThrows(AccountDoesNotExistException.class, () -> this.HSBC.deposit("David", new Money(190.231, HKD)));

	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		// See the example in class notes for testing exceptions.

		// Testing withdraw using the same currency
		RBC.withdraw("Sachin", new Money(93.00, CAD));
		TD.withdraw("Garvit", new Money(56.44, CAD));
		HSBC.withdraw("Pallavi", new Money(70.4419, HKD));
		assertEquals(457, RBC.getBalance("Sachin"), .01);
		assertEquals(1043.56, TD.getBalance("Garvit"), .01);
		assertEquals(1484.56, HSBC.getBalance("Pallavi"), .01);

		// Testing withdraw from different currency
		HSBC.withdraw("Niranjan", new Money(14.781, CAD));
		assertEquals(985.219, HSBC.getBalance("Niranjan"), .01);

		// Testing exception (Accounts do not exist)
		assertThrows(AccountDoesNotExistException.class, () -> this.RBC.withdraw("Eddi", new Money(1200.231, CAD)));
		assertThrows(AccountDoesNotExistException.class, () -> this.TD.withdraw("Sara", new Money(110.231, CAD)));
		assertThrows(AccountDoesNotExistException.class, () -> this.HSBC.withdraw("David", new Money(190.231, HKD)));

	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.

		// See the example in class notes for testing exceptions.

		assertEquals(550, RBC.getBalance("Sachin"), 0.01);
		assertEquals(1100.0, TD.getBalance("Garvit"), 0.01);
		assertEquals(1555.0, HSBC.getBalance("Pallavi"), 0.01);
		assertEquals(1000.0, HSBC.getBalance("Niranjan"), 0.01);

		// Testing exception (Accounts do not exist)
		assertThrows(AccountDoesNotExistException.class, () -> this.RBC.getBalance("Eddi"));
		assertThrows(AccountDoesNotExistException.class, () -> this.TD.getBalance("Sara"));
		assertThrows(AccountDoesNotExistException.class, () -> this.HSBC.getBalance("David"));
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers

		// Transfer between banks (FROM TD TO HSBC)
		TD.transfer("Garvit", HSBC, "Pallavi", new Money(200.1551, CAD));
		assertEquals(899.845, TD.getBalance("Garvit"), .01);
		assertEquals(2709.74, HSBC.getBalance("Pallavi"), .01);

		// Transfer between banks (HSBC TDC TO RBC)
		HSBC.transfer("Pallavi", RBC, "Sachin", new Money(23.121, CAD));
		assertEquals(2686.62, HSBC.getBalance("Pallavi"), .01);
		assertEquals(573.12, RBC.getBalance("Sachin"), .01);

		// Transfer from account HSBC to account HSBC
		HSBC.transfer("Pallavi", "Niranjan", new Money(34.541, CAD));
		assertEquals(2652.08, HSBC.getBalance("Pallavi"), .01);
		assertEquals(1199.27, HSBC.getBalance("Niranjan"), .01);

		// Testing exception (Both account must exist)
		assertThrows(AccountDoesNotExistException.class,
				() -> this.TD.transfer("Garvit", HSBC, "xyz", new Money(200.1551, CAD)));
		assertThrows(AccountDoesNotExistException.class,
				() -> this.HSBC.transfer("Pallavi", RBC, "abc", new Money(23.121, CAD)));
		assertThrows(AccountDoesNotExistException.class,
				() -> this.HSBC.transfer("Pallavi", "pqr", new Money(34.541, CAD)));

	}

	@Test
	public void testTimePayment() {

	}

}
