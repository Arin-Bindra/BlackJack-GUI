package black_jack_casino;

import java.util.Map;
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

public class CardDeckTest {
    
    private CardDeck cardDeck;
    private Card cardExpected;
    private Card cardResult;
    
    public CardDeckTest() {
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
        cardDeck = new CardDeck();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newCard method, of class CardDeck.
     */
    @Test
    public void testNewCard() {
        System.out.println("newCard");
        
        cardExpected = new Card(10);
        boolean same = false;
        
        while(same != true)
        {
            cardResult = cardDeck.newCard();
            
            if(cardResult.getNumber() == cardExpected.getNumber())
            {
                same = true;
            }
        }
        
        Assert.assertEquals(cardExpected, cardResult);
    }

    /**
     * Test of getCardOccurance method, of class CardDeck.
     */
    @Test
    public void testGetCardOccurance() {
        System.out.println("getCardOccurance");
        
        Card card = new Card(10);
        Card cardR;
        int expected = 1;
        boolean same = false;
        CardDeck deckR = new CardDeck();
        
        while(same != true)
        {
            cardR = deckR.newCard();
            
            if(cardR.getNumber() == card.getNumber())
            {
                same = true;
            }
        }
        
        Map<Integer, Integer> mapResult = deckR.getCardOccurance();
        
        int result = mapResult.get(10);
        
        Assert.assertEquals(expected, result);
    }
}
