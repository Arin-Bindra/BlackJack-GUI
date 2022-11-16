package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
* 
* The card class stores a card objects attributes, such as its value, and appearance
* 
**/

public class Card {
    
    private int number;
    private String name;
    private int value;
    private String layout;
    
    public Card(int number)
    {
        this.setNumber(number);
        this.setName();
        this.setValue();
        this.setLayout();
    }
    
    //----------------------------------------------------------------
    
    public int getNumber()
    {
        return this.number;
    }
    
    //----------------------------------------------------------------
    
    private void setNumber(int number)
    {
        this.number = number;
    }
    
    //---------------------------------------------------------------
    
    private void setName()
    {
        if(this.number == 1)
        {
            this.name = "ace";
        }
        
        if(this.number == 2)
        {
            this.name = "two";
        }
        
        if(this.number == 3)
        {
            this.name = "three";
        }
        
        if(this.number == 4)
        {
            this.name = "four";
        }
        
        if(this.number == 5)
        {
            this.name = "five";
        }
        
        if(this.number == 6)
        {
            this.name = "six";
        }
        
        if(this.number == 7)
        {
            this.name = "seven";
        }
        
        if(this.number == 8)
        {
            this.name = "eight";
        }
        
        if(this.number == 9)
        {
            this.name = "nine";
        }
        
        if(this.number == 10)
        {
            this.name = "ten";
        }
        
        if(this.number == 11)
        {
            this.name = "jack";
        }
        
        if(this.number == 12)
        {
            this.name = "queen";
        }
        
        if(this.number == 13)
        {
            this.name = "king";
        }
    }  
    
        //---------------------------------------------------------------
    
    private void setLayout()
    {
        if((this.number > 1) && (this.number < 11))
        {
            this.layout = "[" + this.number + "]"; 
        }
        
        if(this.number == 1)
        {
            this.layout = "[A]";
        }
        
        if(this.number == 11)
        {
            this.layout = "[J]";
        }
        
        if(this.number == 12)
        {
            this.layout = "[Q]";
        }
        
        if(this.number == 13)
        {
            this.layout = "[K]";
        }
    } 

    //---------------------------------------------------------------
    
    public String getName() 
    {
        return this.name;
    }
    
    //---------------------------------------------------------------
     /**
     * 
     * Because the number of each card in black jack is not corresponding
     * to its value, the values of each cards are being set individually.
     * 
     **/
    
    private void setValue()
    {
        if(this.number < 11)
        {
            this.value = this.number;
        }
        
        if(this.number > 10)
        {
            this.value = 10;
        }
    }
    
    //---------------------------------------------------------------
    
    public int getValue()
    {
        return this.value;
    }
    
    //--------------------------------------------------------------
    
    @Override
    public String toString()
    {
        return this.layout;
    }
}
