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

public class CardTest {
    
    private Card card;
    
    public CardTest() {
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
        card = new Card(12);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Card.
     */
    @Test
    public void testGetName() 
    {
        System.out.println("getName Test");
        
        String actual = card.getName();
        String expected = "queen";
        
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() 
    {
        System.out.println("getValue");
        
        int expected = 10;
        int actual = card.getValue();
        
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() 
    {
        System.out.println("toString");
        
        String expected = "[Q]";
        String actual = card.toString();
        
        Assert.assertEquals(expected, actual);
    }
    
}
