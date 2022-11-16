package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
* 
* The transaction class allows transactions to occur between both the casino
* and the guest. Having the casino and guest as inputs, it allows control
* over both of their winning and losses per game.
* 
**/
public class Transaction {
    
    private Guest guest;
    private Casino casino;
    private final int table = 10;
    
    public Transaction(Guest guest, Casino casino)
    {
        this.setGuest(guest);
        this.setCasino(casino);
    }
        
    //----------------------------------------------------------------
    
    private void setGuest(Guest guest)
    {
        this.guest = guest;
    }
    
    //----------------------------------------------------------------
    
    private void setCasino(Casino casino)
    {
        this.casino = casino;
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The deposit function takes an int value as an input, and as long
     * as it is not negative, it will add the value to the guests account.
     * 
     **/
    public void deposit(int amount)
    {
        if(amount>0)
        {
            this.guest.add(amount);
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The withdraw function removes all the guests account value, simulating
     * they are withdrawing their full account.
     * 
     **/
    public void withdraw()
    {
        this.guest.subtract(this.guest.getDollars());
    }
    
    //----------------------------------------------------------------
    /**
     * 
     * The win function takes an int amount as an input, and allows  the amount
     * to be subtracted from the casino account and added to the guests account.
     * 
     * The function invokes the add and subtract function in the user class.
     * 
     * The function also insures that the casinos account value never drops below
     * 50 to ensure that the casino continues to operate.
     * 
     **/
    public void win(int table)
    {
        this.guest.add(10);
        this.casino.subtract(10);
        
        if(this.casino.getDollars() < 50)
        {
            this.casino.add(50 - this.casino.getDollars());
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The loss function takes an int amount as an input and subtracts the value
     * from the guests account, whilst also adding the same value to the casinos
     * account. 
     * 
     * This function invokes the user add and subtract functions.
     * 
     **/
    public void loss(int table)
    {
        this.guest.subtract(10);
        this.casino.add(10);
    }
    
    
}
