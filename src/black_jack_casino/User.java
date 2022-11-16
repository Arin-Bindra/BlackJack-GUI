package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
 * The user class, creates a user object with two attributes, username and dollars.
 * this keeps track of the amount of dollars in its account. 
 * 
 **/
abstract class User {
    
    private String username = "";
    private int dollars = 0;
    public int wins = 0;
    public int losses = 0;
    public CasinoDB data = new CasinoDB();
    
    public User(String username)
    {
        this.setUsername(username);
    }
    
    //----------------------------------------------------------------
    
    public String getUsername()
    {
        return this.username;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * Sets and cleans username of all chars other then a-z and spaces
    * 
    **/
    private void setUsername(String username)
    {
        String usernameClean = "";
        
        for(int i = 0; i < username.length(); i++)
        {
            int ascii =(int) username.charAt(i);
            
            if(((ascii > 64) && (ascii < 91)) || ((ascii > 96) && (ascii < 123)) || (ascii == 32))
            {
                usernameClean = usernameClean + username.charAt(i);
            }
        }
        
        this.username = usernameClean.toLowerCase();
    }
    
    //----------------------------------------------------------------
    
    public int getDollars()
    {
        return this.dollars;
    }
    
    //----------------------------------------------------------------
    
    private void setDollars(int dollars)
    {
        this.dollars = dollars;
    }
    
    //----------------------------------------------------------------
    
    public void add(int amount)
    {
        this.setDollars(this.dollars + amount);
    }
    
    //----------------------------------------------------------------
    
    public void subtract(int amount)
    {
        this.setDollars(this.dollars - amount);
    }
    
    //----------------------------------------------------------------
    
    public void win()
    {
        this.wins++;
    }
    
    //----------------------------------------------------------------
    
    public int getWins()
    {
        return this.wins;
    }
    
    //----------------------------------------------------------------
    
    public void loss()
    {
        this.losses ++;
    }
    
    //----------------------------------------------------------------
    
    public int getLosses()
    {
        return this.losses;
    }
}
