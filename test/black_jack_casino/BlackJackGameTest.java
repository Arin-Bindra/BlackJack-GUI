package black_jack_casino;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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

public class BlackJackGameTest {
    
    public BlackJackGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of Userhit method, of class BlackJackGame.
     */
    @Test
    public void testUserhit() 
    {
        System.out.println("Userhit");
        
        int expected = 3;
        ArrayList<Card> userCards = new ArrayList();
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        
        game.Userhit();
        userCards = game.getUserCardsArray();
        
        int result = userCards.size();
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of Casinohit method, of class BlackJackGame.
     */
    @Test
    public void testCasinohit() {
        System.out.println("Casinohit");
        
        int expected = 2;
        ArrayList<Card> casinoCards = new ArrayList();
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        
        game.Casinohit();
        casinoCards = game.getCasinoCardsArray();
        
        int result = casinoCards.size();
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkUserBlackJack method, of class BlackJackGame.
     */
    @Test
    public void testCheckUserBlackJack() {
        System.out.println("checkUserBlackJack");

        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkUserBlackJack();
        
        if(game.getUserCardValue() != 21)
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkCasinoBlackJack method, of class BlackJackGame.
     */
    @Test
    public void testCheckCasinoBlackJack() 
    {
        System.out.println("checkCasinoBlackJack");

        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkCasinoBlackJack();
        
        if(game.getCasinoCardValue() != 21)
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkUserCasinoDraw method, of class BlackJackGame.
     */
    @Test
    public void testCheckUserCasinoDraw() {
        System.out.println("checkUserCasinoDraw");
        
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkUserCasinoDraw();
        
        if(game.getUserCardValue() == game.getCasinoCardValue())
        {
           expected = true; 
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkWin method, of class BlackJackGame.
     */
    @Test
    public void testCheckWin() {
        System.out.println("checkWin");
        
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkWin();
        
        if((game.getUserCardValue() > game.getCasinoCardValue()))
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkLoss method, of class BlackJackGame.
     */
    @Test
    public void testCheckLoss() {
        System.out.println("checkLoss");
        
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkLoss();
        
        if((game.getUserCardValue() < game.getCasinoCardValue()))
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkUserOver method, of class BlackJackGame.
     */
    @Test
    public void testCheckUserOver() {
        System.out.println("checkUserOver");
        
        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkUserOver();
        
        if((game.getUserCardValue() > 21))
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }

    /**
     * Test of checkCasinoOver method, of class BlackJackGame.
     */
    @Test
    public void testCheckCasinoOver() {
        System.out.println("checkCasinoOver");

        CardDeck cardDeck = new CardDeck();
        BlackJackGame game = new BlackJackGame(cardDeck);
        boolean expected = false;
        boolean result = game.checkCasinoOver();
        
        if((game.getCasinoCardValue() > 21))
        {
            expected = true;
        }
        
        Assert.assertEquals(expected, result);
    }
    
}
