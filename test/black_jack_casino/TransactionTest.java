package black_jack_casino;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 *
 * ENSE600
 * Project 2
 * Arin Bindra
 * ID:18042017
 * 
 */

public class TransactionTest {
    
    private Guest guest;
    private Casino casino;
    private Transaction transaction;
    
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        guest = new Guest("user test");
        casino = new Casino();
        
        transaction = new Transaction(guest, casino);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deposit method, of class Transaction.
     */
    @Test
    public void testDeposit() 
    {
        System.out.println("deposit");
        
        int amount = 10;
        int expected = 10;
        
        transaction.deposit(amount);
        int actual = guest.getDollars();
        
        Assert.assertEquals(expected, actual);
        
        guest.subtract(amount);
    }

    /**
     * Test of withdraw method, of class Transaction.
     */
    @Test
    public void testWithdraw() 
    {
        System.out.println("withdraw");
        
        transaction.deposit(20);
        int expected = 0;
        
        transaction.withdraw();
        int actual = guest.getDollars();
        
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test of win method, of class Transaction.
     */
    @Test
    public void testWin() 
    {
        System.out.println("win");
        
        int table = 25;
        int expected = 25;
        
        transaction.win(table);
        int actual = guest.getDollars();
        
        Assert.assertEquals(expected, actual);
        
        guest.subtract(guest.getDollars());
    }

    /**
     * Test of loss method, of class Transaction.
     */
    @Test
    public void testLoss() 
    {
        System.out.println("loss");
        
        int table = 10;
        int expected = 10;
        
        guest.add(20);
        transaction.loss(table);
        int actual = guest.getDollars();
        
        Assert.assertEquals(expected, actual);
        
        guest.subtract(guest.getDollars());
    }
    
}
