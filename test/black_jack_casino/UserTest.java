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

public class UserTest {
    
    private Guest guest;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        guest = new Guest("user test");
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of add method, of class User.
     */
    @Test
    public void testAdd() 
    {
        System.out.println("add Test");
        
        int amount = 20;
        guest.add(amount);
        
        int actual = guest.getDollars();
        int expected = 20;
        
        Assert.assertEquals(expected, actual);
        
        guest.subtract(guest.getDollars());
    }

    /**
     * Test of subtract method, of class User.
     */
    @Test
    public void testSubtract() 
    {
        System.out.println("subtract");
        
        int amount = 10;
        
        guest.add(20);
        guest.subtract(amount);
        
        int actual = guest.getDollars();
        int expected = 10;
        
        Assert.assertEquals(expected, actual);
        
        guest.subtract(guest.getDollars());
    }

    /**
     * Test of win method, of class User.
     */
    @Test
    public void testWin() 
    {
        System.out.println("win");
        
        guest.win();
        int actual = guest.getWins();
        int expected = 1;
        
        Assert.assertEquals(expected, actual);
        
        guest.wins = 0;
    }

    /**
     * Test of loss method, of class User.
     */
    @Test
    public void testLoss() 
    {
        System.out.println("loss");
        
        guest.wins = 2;
        
        guest.loss();
        
        int actual = guest.getLosses();
        int expected = 1;
        
        Assert.assertEquals(expected, actual);
        
        guest.losses = 0;
    }

    /**
     * Test of getLosses method, of class User.
     */
    

    public class UserImpl extends User {

        public UserImpl() {
            super("");
        }
    }
    
}
