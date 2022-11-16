package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
*
* The method class communicates with the view class to set the active JPanels,
* whilst also initializing the blackjack game and checking all of the components.
* The class also initializes the user, casino, transaction, and card deck classes
* so they are all able to work together in order for the black jack game to run.
* 
*/

import java.util.Observable;

public class Model extends Observable{
    
    private Guest guest;
    private Casino casino;
    private BlackJackGame game;
    private Transaction transaction;
    private CardDeck deck;
    private String username;
    private final int table = 10;
    private boolean activeGame = false;
    private boolean win = false;
    private boolean loss = false;
    private boolean draw = false;
    private boolean invalidInput = false;
    
    private boolean userPanel = true;
    private boolean afterLoginPanel = false;
    private boolean transactionPanel = false;
    private boolean blackJackNPanel = false;
    private boolean gameFinishedPanel = false;
    private boolean preRulesPanel = false;
    private boolean afterRulesPanel = false;
    private boolean afterFundsPanel = false;
    
    public Model()
    {
        this.casino = new Casino();
        this.deck = new CardDeck();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The set guest method takes a username string as input and creates a new
     * guest object.
     * 
     */
    
    public void setGuest(String username)
    {
        this.guest = new Guest(username);
        this.username = this.guest.getUsername();
        this.setTransaction();
        
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The set transaction method initializes the transaction class
     * 
     */
    
    public void setTransaction()
    {
        this.transaction = new Transaction(this.guest, this.casino);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The start black jack method initializes the black jack game whilst also
     * setting the current guest win statuses to false
     * 
     */
    
    public void startBlackJack()
    {
        this.game = new BlackJackGame(this.deck);
        this.activeGame = true;
        this.win = false;
        this.draw = false;
        this.loss = false;
    }
    
    //----------------------------------------------------------------
    
    public int getAccount()
    {
        return this.guest.getDollars();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The get table difference returns the value between the table and guest
     * account
     * 
     */
    
    public int getTableDifference()
    {
        return 20 - this.getAccount();
    }
    
    //----------------------------------------------------------------
    
    public String getUsername()
    {
        return this.guest.getUsername();
    }
    
    //----------------------------------------------------------------
    
    public boolean getActiveGame()
    {
        return this.activeGame;
    }
    
    //----------------------------------------------------------------
    
    public String getUserCards()
    {
        return this.game.getUserCards();
    }
    
    //----------------------------------------------------------------
    
    public String getCasinoCards()
    {
        return this.game.getCasinoCards();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The save game method invokes the save user and guest methods,
     * which writes data to the connected databases and closes them after.
     * 
     */
    
    public void saveGame()
    {
        this.guest.saveUser();
        this.casino.saveCasino();
    }
    
    //----------------------------------------------------------------
    
    public boolean getWin()
    {
        return this.win;
    }
    
    //----------------------------------------------------------------
    
    public boolean getDraw()
    {
        return this.draw;
    }
    
    //----------------------------------------------------------------
    
    public boolean getLoss()
    {
        return this.loss;
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The deposit method takes an int amount as an input and 
     * 
     */
    
    public void deposit(int amount)
    {
        this.transaction.deposit(amount);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The withdraw method resets a users account value to zero, and
     * invokes the save method.
     * 
     */
    
    public void withdraw()
    {
        this.transaction.withdraw();
        this.saveGame();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The check win method, checks if the user has won, lost, or drawn the
     * black jack game with the casino, and set the appropriate Boolean value to
     * true. The method then updates its observers.
     * 
     */
    
    public void checkWin()
    {
        if(this.game.checkUserOver() && this.game.checkCasinoOver())
        {
            this.draw = true;
        }
        if(this.game.checkWin() == true)
        {
            this.guest.win();
            this.transaction.win(this.table);
            this.win = true;
        }
        if(this.game.checkUserCasinoDraw() == true)
        {
            this.draw = true;
        }
        if((this.game.checkLoss() == true) && (this.game.checkWin() == false) && (this.game.checkUserCasinoDraw() == false))
        {
            this.guest.loss();
            this.transaction.loss(this.table);
            this.loss = true;
        }
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The hit method allows the user to "hit" a new card in the black jack
     * game, and then notifies its observers.
     * 
     */
    
    public void hit()
    {
        this.game.Userhit();
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    //----------------------------------------------------------------
    
    public boolean checkOver()
    {
        return this.game.checkUserOver();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The casino hit method will allow the casino to "hit" a new card in the
     * black jack game, depending on the users card values. The method will then
     * notify its observers.
     * 
     */
    
    public void casinoHit()
    {
        if(this.game.getUserCardValue() > 21)
        {
            this.game.Casinohit();
        } 
        else if(this.game.getUserCardValue() <= 21)
        {
            while((this.game.getCasinoCardValue() <= 17))
            {
                this.game.Casinohit();
            }
        }
        
        this.checkWin();
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The set invalid input method will take a Boolean value as input which
     * represents if an input is true or false, and then sets the invalid input
     * value accordingly, whilst also notifying the observers.
     * 
     */
    
    public void setInvalidInput(boolean valid)
    {
        if(valid == false)
        {
            this.invalidInput = false;
            this.setChanged();
            this.notifyObservers(this);
        }
        else if(valid == true)
        {
            this.invalidInput = true;
            this.setChanged();
            this.notifyObservers(this);
        }
    }
    
    //-----------------------------------------------------------------
    
    public boolean getInValidInput()
    {
        return this.invalidInput;
    }
    
    //-----------------------------------------------------------------
    
    public double getWinRate()
    {
        return this.guest.getWinRate();
    }
    
    //----------------------------------------------------------------
    
    public void update()
    {
        this.setChanged();
        this.notifyObservers(this);
    }
    
    //---------------------------------------------------------------
    
    public boolean getUserPanel()
    {
        return this.userPanel;
    }
    
    public boolean getAfterLoginPanel()
    {
        return this.afterLoginPanel;
    }
    
    public boolean getTransactionPanel()
    {
        return this.transactionPanel;
    }
    
    public boolean getBlackJackNPanel()
    {
        return this.blackJackNPanel;
    }
    
    public boolean getGameFinishedPanel()
    {
        return this.gameFinishedPanel;
    }
    
    public boolean getPreRulesPanel()
    {
        return this.preRulesPanel;
    }
    
    public boolean getAfterRulesPanel()
    {
        return this.afterRulesPanel;
    }
    
    public boolean getAfterFundsPanel()
    {
        return this.afterFundsPanel;
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The following methods set which JPanel should be active in the view class,
     * and notify the observers accordingly.
     * 
     */
    
    public void setUserPanel()
    {
        this.userPanel = true;
        
        this.afterFundsPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setAfterLogin()
    {
        this.afterLoginPanel = true;
        
        this.userPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setTransactionPanel()
    {
        this.transactionPanel = true;
        
        this.afterLoginPanel = false;
        this.userPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setBlackJackNPanel()
    {
        this.blackJackNPanel = true;
        
        this.afterLoginPanel = false;
        this.transactionPanel = false;
        this.userPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setGameFinishedPanel()
    {
        this.gameFinishedPanel = true;
        
        this.afterLoginPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.userPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setPreRulesPanel()
    {
        this.preRulesPanel = true;
        
        this.afterLoginPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.userPanel = false;
        this.afterRulesPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setAfterRulesPanel()
    {
        this.afterRulesPanel = true;
        
        this.afterLoginPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.userPanel = false;
        this.afterFundsPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public void setAfterFundsPanel()
    {
        this.afterFundsPanel = true;
        
        this.afterLoginPanel = false;
        this.transactionPanel = false;
        this.blackJackNPanel = false;
        this.gameFinishedPanel = false;
        this.preRulesPanel = false;
        this.afterRulesPanel = false;
        this.userPanel = false;
        
        this.setChanged();
        this.notifyObservers(this);
    }
}
