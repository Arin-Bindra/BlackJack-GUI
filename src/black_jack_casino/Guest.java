package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.lang.Math;

public class Guest extends User{
    
    private double winRate;
    private boolean existing;
    
    public Guest(String username)
    {
        super(username);
        this.existingUser();
    }
       
    //----------------------------------------------------------------
    /**
     * 
     * The get win rate function calculates the wins/losses of a user and 
     * returns the double value, allowing the user to keep track of their
     * winning information.
     * 
     **/
    public double getWinRate()
    {
        double winsD = this.wins;
        double lossesD = this.losses;
                
        this.winRate = Math.round(winsD/lossesD);
        
        return this.winRate;
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The existing user function checks is already stored in the user data file,
     * and if it is, it sets the users wins, losses, and account accordingly.
     * 
     **/
    
    private void existingUser()
    {
        this.existing = false;
        
        if(this.data.checkUser(super.getUsername()) == true)
        {
            this.wins = this.data.getUserWins();
            this.losses = this.data.getUserLosses();
            super.add(this.data.getUserAccount());
            this.existing = true;
            
            //System.out.println("\nWelcome Back " + super.getUsername() + ", You currently have $" + super.getDollars() + " in your account.\n");
        }
        else
        {
            super.add(10);
            //System.out.println("\nWelcome " + super.getUsername() + ", You currently have $0 in your new account");
        }
    }
    
    //----------------------------------------------------------------
     /**
     * 
     * The save user function, invokes the write user data and user win rate functions
     * in the casino data class, which writes the users information to the
     * corresponding data files.
     * 
     **/
    public void saveUser()
    {
        this.data.writeUserData(this.getUsername(), this.getDollars(), this.existing);
        this.data.writeUserWinRate(this.getWins(), this.getLosses(), this.existing);
        this.data.closeConnection();
    }
}
