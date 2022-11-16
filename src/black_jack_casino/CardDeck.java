package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class CardDeck {
    
    private ArrayList<Card> deck = new ArrayList();
    private Map<Integer, Integer> pulledCards = new HashMap();
    
    public CardDeck()
    {
        this.createDeck();
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The new card functions returns a card object which is stored in the
     * card deck arrayList.
     * 
     * A random int value up to the value of the size of the card deck array
     * list is generated, and that number corresponds to a card in the array.
     * 
     * The card is then removed from the array list. This simulates a shuffled
     * deck of cards.
     * 
     * The function also checks if the card deck array list is empty after 
     * each new card has been withdrawn and invokes the new card deck function.
     * 
     **/
    
    public Card newCard()
    {
        Random random = new Random();
        
        if(this.deck.isEmpty() == true)
        {
            this.deck.removeAll(this.deck);
            this.createDeck();
        } 
        
        int value = random.nextInt(this.deck.size()-1);
        Card card = this.deck.get(value);
        this.deck.remove(value);
        
        this.setCardOccurance(card);
        
        return card;
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The create deck function initiates the card class, which creates 
     * a series of new card objects from 1 to 13, and stores them in the
     * card deck array list.
     * 
     * Because most casinos use a 8 card decks combined for black jack
     * 32 of each card object is created and stored.
     * 
     **/
    
    private void createDeck()
    {
        this.deck.removeAll(this.deck);
        
        for(int i = 1; i < 14; i++)
        {
            for(int j = 0; j < 32; j++)
            {
                this.deck.add(new Card(i));
            }
        }

        this.createOccurance();
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The create occurrence function creates a hash map, which stores
     * the cards number as an index key and the number of times the card
     * has been selected as part of the new card function, to record its
     * occurrence.
     * 
     **/
    
    private void createOccurance()
    {
        this.pulledCards.clear();
        
        for(int i = 1; i < 14; i++)
        {
            this.pulledCards.put(i, 0);
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The set card occurrence function records the amount of times a card has
     * been selected as part of the new card function.
     * 
     * The function records the current times a card has been selected, and then
     * increases it by one. The index is then replaced in the hash map with the
     * new card occurrence value.
     * 
     **/
    
    private void setCardOccurance(Card card)
    {
        int value = this.pulledCards.get(card.getNumber());
        
        value++;
        
        this.pulledCards.replace(card.getNumber(), value);
    }
    
    //----------------------------------------------------------------
    
    public Map<Integer, Integer> getCardOccurance()
    {
        return this.pulledCards;
    }
    
}
