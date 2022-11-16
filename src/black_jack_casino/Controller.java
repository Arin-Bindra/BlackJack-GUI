package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    
    public View view;
    public Model model;
    
    //----------------------------------------------------------------
    
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    //----------------------------------------------------------------

    /**
     *
     * The override action preformed method takes the action event as input, 
     * and communicates with the model class which methods to invoke, according
     * to the button pressed in the JFrame.
     * 
     * Because there are multiple JPanels with the same button names, 
     * the method checks which JPanel is currently active from the model class
     * and then communicates with the model class accordingly.
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        if(this.model.getUserPanel() == true)
        {
            switch(command)
            {
                case "Log in":
                    
                    String username = this.view.usernameInput.getText();
                    this.model.setGuest(username);
                    this.model.setAfterLogin();
                    break;
                    
                default:
                    break;
            }
        }
        
        if(this.model.getAfterLoginPanel() == true)
        {
            switch(command)
            {
                case "Deposit":
                    
                    this.model.setTransactionPanel();
                    break;
                    
                case "Continue":
                    
                    if(this.model.getAccount()<20)
                    {
                        this.model.setTransactionPanel();
                    }
                    else if(this.model.getAccount() >= 20)
                    {
                        this.model.setPreRulesPanel();  
                    }
                    break;
                default:
                    break;
            }
        }
        
        if(this.model.getTransactionPanel() == true)
        {
            switch(command)
            {
                case "$20":
                    this.model.deposit(20);
                    this.model.setPreRulesPanel();
                    break;
                    
                case "$50":
                    this.model.deposit(50);
                    this.model.setPreRulesPanel();
                    break;
                
                case "$100":
                    this.model.deposit(100);
                    this.model.setPreRulesPanel();
                    break;
                    
                default:
                    break;
            }
        }
        
        if(this.model.getPreRulesPanel() == true)
        {
            switch(command)
            {
                case "Continue":
                    this.model.startBlackJack();
                    this.model.setBlackJackNPanel();
                    break;
                default:
                    break;
            }
        }        
        
        if(this.model.getBlackJackNPanel() == true)
        {
            switch(command)
            {
                case "Hit":
                    if(this.model.checkOver() != true)
                    {
                        this.model.hit();
                        break;
                    }
                    else if(this.model.checkOver() == true)
                    {
                        this.model.checkWin();
                        this.model.setGameFinishedPanel();
                        break;
                    }
                    break;
                
                case "Stand":
                    this.model.casinoHit();
                    this.model.checkWin();
                    this.model.setGameFinishedPanel();
                    break;
                
                default:
                    break;
            }
        }
        
        if(this.model.getGameFinishedPanel() == true)
        {
            switch(command)
            {
                case "Play Again":
                    
                    if(this.model.getAccount()<20)
                    {
                        this.model.setAfterFundsPanel();
                        break;
                    }
                    else if(this.model.getAccount() >= 20)
                    {
                        this.model.startBlackJack();
                        this.model.setBlackJackNPanel();
                        break;
                    }
                    break;
                    
                case "Exit Game":
                    
                    this.model.saveGame();
                    System.exit(0);
                    break;
                    
                case "Read Rules":
                    
                    this.model.setAfterRulesPanel();
                    break;
                    
                case "Withdraw & Exit":
                {
                    this.model.withdraw();
                    System.exit(0);
                    break;
                }
                
                default:
                    break;
            }
        }
        
        if(this.model.getAfterRulesPanel() == true)
        {
            switch (command)
            {
                case "Continue":
                    this.model.setGameFinishedPanel();
                    break;
                    
                default:
                    break;
            }
        }
        
        if(this.model.getAfterFundsPanel() == true)
        {
            switch(command)
            {
                case "Deposit":
                    this.model.setTransactionPanel();
                    break;
                
                case "Exit":
                    this.model.saveGame();
                    System.exit(0);
                    break;
                
                default:
                    break;
            }
        }        
    }
}
