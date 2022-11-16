package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
* 
* The black jack game class controls and checks all of the aspects of the 
* game black jack.
* 
**/

import java.util.ArrayList;

public class BlackJackGame {
    
    private CardDeck cardDeck;
    private ArrayList<Card> userCards = new ArrayList();
    private ArrayList<Card> casinoCards = new ArrayList();
    private ArrayList<Integer> userCardValues = new ArrayList();
    private ArrayList<Integer> casinoCardValues = new ArrayList();
    private int userCardDifference = 21;
    private int casinoCardDifference = 21;
    
    public BlackJackGame(CardDeck cardDeck)
    {
        this.setCardDeck(cardDeck);
        this.initialCards();
    }
    
    //----------------------------------------------------------------
    
    public CardDeck getCardDeck()
    {
        return this.cardDeck;
    }
    
    //----------------------------------------------------------------
    
    private void setCardDeck(CardDeck cardDeck)
    {
        this.cardDeck = cardDeck;
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The user hit function takes a random card object from the card deck
     * and places it into the user cards array, which stores all of the users
     * cards for the hand. 
     * 
     * Because cards with the value one in black jack can also be regarded to
     * have a value of 11, if allows the value of the total cards to be closer
     * to 21, the function also checks that cards with a value one can be regarded
     * to have a value of 11 if suiting.
     * 
     * When a new card is drawn from the deck the cards value is also recorded
     * in the user card value array.
     * 
     **/
    
    public void Userhit()
    {
        this.userCards.add(this.cardDeck.newCard());
        
        if(this.userCards.get(this.userCards.size()-1).getValue() == 1)
        {
            if(this.userCardDifference - 11 >= 0)
            {
                this.userCardValues.add(11);
                this.userCardDifference = this.userCardDifference - 11;
            }
            else
            {
                this.userCardValues.add(this.userCards.get(this.userCards.size()-1).getValue());
                this.userCardDifference = this.userCardDifference - this.userCards.get(this.userCards.size()-1).getValue();
            }
        }
        else
        {
            this.userCardValues.add(this.userCards.get(this.userCards.size()-1).getValue());
            this.userCardDifference = this.userCardDifference - this.userCards.get(this.userCards.size()-1).getValue();
        }
    }
    
    //----------------------------------------------------------------
        
    public void setUserCards(Card card)
    {
        this.userCards.add(card);
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The print user cards function prints the current card objects
     * that the array user cards is holding, along with a total all of the values
     * that the user card values array list is also holding.
     * 
     **/
        
    public String getUserCards()
    {
        String cards = "";
        int value = 0;
        String statement;
        
        for(int i = 0; i < this.userCards.size(); i++)
        {
            cards = cards + " " + this.userCards.get(i);
        }
        
        for(int i = 0; i < this.userCardValues.size(); i++)
        {
            value = value + this.userCardValues.get(i);
        }
        
       statement = " | Your Cards: " + cards + ". Total value = " + value;
       
       return statement;
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The print casino cards function prints the current card objects
     * that the array casino cards is holding, along with a total all of the values
     * that the casino card values array list is also holding.
     * 
     **/
        
    public String getCasinoCards()
    {
        String cards = "";
        int value = 0;
        String statement;
        
        for(int i = 0; i < this.casinoCards.size(); i++)
        {
            cards = cards + " " + this.casinoCards.get(i);
        }
        
        for(int i = 0; i < this.casinoCardValues.size(); i++)
        {
            value = value + this.casinoCardValues.get(i);
        }
        
        statement = "Dealer Cards: " + cards + ". Total value = " + value;
        
        return statement;
    }
    
    //----------------------------------------------------------------
    
    public ArrayList<Card> getUserCardsArray()
    {
        return this.userCards;
    }
    
    //----------------------------------------------------------------
    
    public ArrayList<Card> getCasinoCardsArray()
    {
        return this.casinoCards;
    }
    
    //----------------------------------------------------------------
        
    public void setUserCardDifference(int value)
    {
        this.userCardDifference = this.userCardDifference - value;
    }
    
    //----------------------------------------------------------------
        
    public int getUserCardDifference()
    {
        return this.userCardDifference;
    }
    
    //----------------------------------------------------------------
        
    public void setUserCardvalues(int value)
    {
        this.userCardValues.add(value);
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The casino hit function takes a random card object from the card deck
     * and places it into the casino cards array, which stores all of the casinos
     * cards for the hand. 
     * 
     * Because cards with the value one in black jack can also be regarded to
     * have a value of 11, if allows the value of the total cards to be closer
     * to 21, the function also checks that cards with a value one can be regarded
     * to have a value of 11 if suiting.
     * 
     * When a new card is drawn from the deck the cards value is also recorded
     * in the casino card value array.
     * 
     **/
    
    public void Casinohit()
    {
        this.casinoCards.add(this.cardDeck.newCard());
        
        if(this.casinoCards.get(this.casinoCards.size()-1).getValue() == 1)
        {
            if(this.casinoCardDifference - 11 >= 0)
            {
                this.casinoCardValues.add(11);
                this.casinoCardDifference = this.casinoCardDifference - 11;
            }
            else
            {
                this.casinoCardValues.add(this.casinoCards.get(this.casinoCards.size()-1).getValue());
                this.casinoCardDifference = this.casinoCardDifference - this.casinoCards.get(this.casinoCards.size()-1).getValue();
            }
        }
        else
        {
            this.casinoCardValues.add(this.casinoCards.get(this.casinoCards.size()-1).getValue());
            this.casinoCardDifference = this.casinoCardDifference - this.casinoCards.get(this.casinoCards.size()-1).getValue();
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The initial cards object takes two cards from the card deck and
     * stores them in the user cards array list, and one card from the card
     * deck and stores it in the casino cards array list. This simulates the
     * start of a hand in black jack.
     * 
     * The function also checks if a drawn cards value is one, if it is possible
     * to change its value to 11 is the total values of the cards are under 21
     * for the user.
     * 
     * For the casino cards array list if a card with a value of 1 is drawn its
     * value is changed to 11 because only one card is drawn.
     * 
     * 
     **/
    
    private void initialCards()
    {
        for(int i = 0; i < 2; i++)
        {
            this.userCards.add(this.cardDeck.newCard());
            
            if(this.userCards.get(i).getValue() == 1)
            {
                if(this.userCardDifference - 11 >= 0)
                {
                    this.userCardValues.add(11);
                }
                else
                {
                    this.userCardValues.add(this.userCards.get(i).getValue());
                }
            }
            else
            {
                this.userCardValues.add(this.userCards.get(i).getValue());
            }
        }
        
        this.casinoCards.add(this.cardDeck.newCard());
            
        if(this.casinoCards.get(0).getValue() == 1)
        {
            this.casinoCardValues.add(11);
        }
        else
        {
            this.casinoCardValues.add(this.casinoCards.get(0).getValue());
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The check user black jack function checks if the total value of a users
     * cards are equal to 21, and if so returns a true Boolean value.
     * 
     **/
    
    public boolean checkUserBlackJack()
    {
        boolean win = false;
        
        if(this.userCardDifference == 0)
        {
            win = true;
        }
        
        return win;
    }
    
    //----------------------------------------------------------------
    
    public int getCasinoCardValue()
    {
        int total = 0;
        
        for(int i = 0; i < this.casinoCards.size(); i++)
        {
            total = total + this.casinoCardValues.get(i);
        }
        
        return total;
    }
    
    //----------------------------------------------------------------
    
    public int getUserCardValue()
    {
        int total = 0;
        
        for(int i = 0; i < this.userCardValues.size(); i++)
        {
            total = total + this.userCardValues.get(i);
        }
        
        return total;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check casino black jack function checks if the total value of a users
     * cards are equal to 21, and if so returns a true Boolean value.
     * 
     **/
    
    public boolean checkCasinoBlackJack()
    {
        boolean win = false;
        
        if(this.casinoCardDifference == 0)
        {
            win = true;
        }
        
        return win;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check user casino draw function, checks if both the total value of 
     * the users cards and casinos cards are under 21 and are equal, or if both
     * the casino and users cards total value is over 21. If any of these two
     * conditions are true, a true Boolean value is returned.
     * 
     **/
    
    public boolean checkUserCasinoDraw()
    {
        boolean draw = false;
        
        if(this.checkCasinoOver() && this.checkUserOver())
        {
            draw = true;
        }
        
        if((this.getCasinoCardValue() <= 21) && (this.getUserCardValue() <= 21))
        {
            if(this.getCasinoCardValue() == this.getUserCardValue())
            {
                draw = true;
            }
        }
        
        return draw;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check win function checks if the total value of the users cards are
     * higher then that of the casinos cards whilst being under 21, or if the
     * total value of the casinos cards are over 21 and the users are not.
     * 
     * The function then returns a true Boolean value if any of those two
     * conditions are met.
     * 
     **/
    
    public boolean checkWin()
    {
        boolean win = false;
        
        if((this.getUserCardValue() > this.getCasinoCardValue()) && (this.getUserCardValue() <=21))
        {
            win = true;
        }
        
        if((this.getCasinoCardValue() > 21) && (this.getUserCardValue() <= 21))
        {
            win = true;
        }
        
        return win;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check loss function checks the total value of the users cards are
     * lower then the casinos whilst the total value of the casinos cards are
     * under 21, or if the total value of the users cards are over 21 and the
     * casinos are under 21.
     * 
     * If any of these two conditions are met the function returns a true
     * Boolean value.
     * 
     **/
    
    public boolean checkLoss()
    {
        boolean loss = false;
        
        if((this.getUserCardValue() > this.casinoCardDifference)
                && (this.casinoCardDifference>=0))
        {
            loss = true;
        }
        
        if((this.userCardDifference < 0) && (this.casinoCardDifference >= 0))
        {
            loss = true;
        }
        
        return loss;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check user over function checks if the total value of the users
     * cards are over 21, and if so returns a true Boolean value.
     * 
     **/
    
    public boolean checkUserOver()
    {
        boolean loss = false;
        
        if(this.getUserCardValue() > 21)
        {
            loss = true;
        }
        
        return loss;
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The check casino function checks if the total value of the casinos
     * cards are over 21, and if so returns a true Boolean value.
     * 
     **/
    
    public boolean checkCasinoOver()
    {
        boolean loss = false;
        
        if(this.casinoCardDifference < 0)
        {
            loss = true;
        }
        
        return loss;
    }
    
}
