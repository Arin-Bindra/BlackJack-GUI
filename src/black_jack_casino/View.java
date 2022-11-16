package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.*;

public class View extends JFrame implements Observer{
    
    boolean started = false;
    private int startCount = 0;
    
    //All Panels
    private JPanel userPanel = new JPanel();
    private JPanel afterLoginPanel = new JPanel();
    private JPanel transactionPanel = new JPanel();
    private JPanel blackJackNPanel = new JPanel();
    private JPanel gameFinsihedPanel = new JPanel();
    private JPanel preRulesPanel = new JPanel(); 
    private JPanel afterRulesPanel = new JPanel();
    private JPanel afterFundsPanel = new JPanel();
    
    //User Panel
    private JLabel welcomeLabelUP = new JLabel("Welcome to the Black Jack Casino");
    private JLabel messageLabelUP = new JLabel("To Start please enter your username");
    private JLabel usernameLabelUP = new JLabel("Username: ");
    public JTextField usernameInput = new JTextField(10);
    private JButton logginButtonUP = new JButton("Log in");
    
    //After Login Panel
    private JLabel messageLabelALP = new JLabel();
    private JLabel message2LabelALP = new JLabel();
    private JLabel message3LabelALP = new JLabel("The only avalible table is $20 per hand");
    private JButton depositButtonALP = new JButton("Deposit");
    private JButton continueButtonALP = new JButton("Continue");
    
    private final String rules = "The rules are as follows:\n"
            + "There are two ways you can win the game.\n"
            + "1. The value of your cards are higher than the dealers, and under 21\n"
            + "2. The value of the dealers cards go above 21, whilst yours do not\n\n"
            + "The sequence of events in the game are as follows:\n"
            + "The dealer will deal one card to himself and two cards to you.\n"
            + "Based on the value of your cards and the dealers, you can choose to take('Hit') another card or stay('Stand') with the cards you have.\n"
            + "After this, the dealer will deal himself more cards, until he feels the value of his cards are more then yours.\n"
            + "The value of whoevers cards are greater at the end of the game, whilst being under 21\n\n"
            + "Card Values:\n"
            + "[A] = either 1 or 11 | [2] = 2 | [3] = 3 | [4] = 4 | [5] = 5 | [6] = 6 | [7] = 7 |\n"
            + "[8] = 8 | [9] = 9 | [10] = 10 | [J] = 10 | [Q] = 10 | [K] = 10";
    
    //Pre Rules Panel
    private JLabel headingPRP = new JLabel("Rules");
    private JScrollPane scrollPRP = new JScrollPane();
    private JButton continuePRP = new JButton("Continue");
    
    //After Rules
    private JLabel headingARP = new JLabel("Rules");
    private JButton continueARP = new JButton("Continue");
    
    //Transaction Panel
    private JLabel headerLabelTP = new JLabel("Transaction");
    private JLabel messageLabel2TP = new JLabel();
    private JLabel messageLabelTP = new JLabel("How much would you like to deposit today?");
    private JButton depositButton20TP = new JButton("$20");
    private JButton depositButton50TP = new JButton("$50");
    private JButton depositButton100TP = new JButton("$100");
    private JLabel errorLabelTP = new JLabel();
    
    //Black Jack Normal Panel
    private JLabel headerlabelBJNP = new JLabel("Black Jack Normal|");
    private JLabel messageLabelBJNP = new JLabel();
    private JLabel userCardsBJNP = new JLabel();
    private JLabel casinoCardsBJNP = new JLabel();
    private JButton hitBJNP = new JButton("Hit");
    private JButton standBJNP = new JButton("Stand");
    
    //Game Finished Panel
    private JLabel messageWinnerLabelGFP = new JLabel();
    private JLabel messageLabelGFP = new JLabel();
    private JButton playAgainButtonGFP = new JButton("Play Again");
    private JButton exitButtonGFP = new JButton("Exit Game");
    private JButton rulesButtonGFP = new JButton("Read Rules");
    private JButton withdrawButtonGFP = new JButton("Withdraw & Exit");
    
    //After Funds Panel
    private JLabel messageLabelAFP = new JLabel("You currently do not have enough funds to get a new hand");
    private JLabel message2LabelAFP = new JLabel();
    private JButton depositButtonAFP = new JButton("Deposit");
    private JButton exitButtonAFP = new JButton("Exit");
    private JLabel errorLabelAFP = new JLabel();
    
    //----------------------------------------------------------------
    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);

        //User Panel
        this.userPanel.add(this.welcomeLabelUP);
        this.userPanel.add(this.messageLabelUP);
        this.userPanel.add(this.usernameLabelUP);
        this.userPanel.add(this.usernameInput);
        this.userPanel.add(this.logginButtonUP);
        
        this.add(this.userPanel);
        this.setVisible(true);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The following methods add the action listener to the appropriate buttons
     * 
     */
    
    public void addActionListener(ActionListener listener)
    {
        //User Panel
        this.logginButtonUP.addActionListener(listener);
        
        //After Loggin Panel
        this.depositButtonALP.addActionListener(listener);
        this.continueButtonALP.addActionListener(listener);
        
        //Game Finsihed Panel
        this.exitButtonGFP.addActionListener(listener);
        this.playAgainButtonGFP.addActionListener(listener);
        this.rulesButtonGFP.addActionListener(listener);
        this.withdrawButtonGFP.addActionListener(listener);
        
        //Transaction Panel
        this.depositButton20TP.addActionListener(listener);
        this.depositButton50TP.addActionListener(listener);
        this.depositButton100TP.addActionListener(listener);
        
        //Black Jack Normal Panel
        this.hitBJNP.addActionListener(listener);
        this.standBJNP.addActionListener(listener);
        
        //After Game Rules
        this.continueARP.addActionListener(listener);
        
        //Pre Game Rules
        this.continuePRP.addActionListener(listener);
        
        //After Funds Panel
        this.depositButtonAFP.addActionListener(listener);
        this.exitButtonAFP.addActionListener(listener);
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The following methods add the appropriate J components to the corresponding
     * J panels, when a particular J panel is invoked. The methods also remove active
     * J panel whilst revalidate and repainting the J Frame.
     * 
     */
    
    private void afterLoginPanel()
    {
        this.afterLoginPanel.add(this.messageLabelALP);
        this.afterLoginPanel.add(this.message2LabelALP);
        this.afterLoginPanel.add(this.message3LabelALP);
        this.afterLoginPanel.add(this.depositButtonALP);
        this.afterLoginPanel.add(this.continueButtonALP);
        
        this.getContentPane().removeAll();
        this.afterLoginPanel.setVisible(true);
        this.add(this.afterLoginPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void blackJackNormalPanel()
    {
        this.blackJackNPanel.add(this.headerlabelBJNP);
        this.blackJackNPanel.add(this.messageLabelBJNP);
        this.blackJackNPanel.add(this.casinoCardsBJNP);
        this.blackJackNPanel.add(this.userCardsBJNP);
        this.blackJackNPanel.add(this.hitBJNP);
        this.blackJackNPanel.add(this.standBJNP);
        
        this.getContentPane().removeAll();
        this.blackJackNPanel.setVisible(true);
        this.add(this.blackJackNPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void gameFinsihedPanel()
    {
        this.gameFinsihedPanel.add(this.casinoCardsBJNP);
        this.gameFinsihedPanel.add(this.userCardsBJNP);
        this.gameFinsihedPanel.add(this.messageWinnerLabelGFP);
        this.gameFinsihedPanel.add(this.messageLabelGFP, BorderLayout.CENTER);
        this.gameFinsihedPanel.add(this.playAgainButtonGFP, BorderLayout.SOUTH);
        this.gameFinsihedPanel.add(this.exitButtonGFP, BorderLayout.SOUTH);
        this.gameFinsihedPanel.add(this.rulesButtonGFP, BorderLayout.SOUTH);
        this.gameFinsihedPanel.add(this.withdrawButtonGFP, BorderLayout.SOUTH);
        
        this.getContentPane().removeAll();
        this.gameFinsihedPanel.setVisible(true);
        this.add(this.gameFinsihedPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void transactionPanel()
    {        
        this.transactionPanel.add(this.headerLabelTP);
        this.transactionPanel.add(this.messageLabelTP);
        this.transactionPanel.add(this.depositButton20TP);
        this.transactionPanel.add(this.depositButton50TP);
        this.transactionPanel.add(this.depositButton100TP);
        this.transactionPanel.add(this.errorLabelTP);
        
        this.getContentPane().removeAll();
        this.transactionPanel.setVisible(true);
        this.add(this.transactionPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void afterFundsPanel()
    {
        this.afterFundsPanel.add(this.messageLabelAFP);
        this.afterFundsPanel.add(this.message2LabelAFP);
        this.afterFundsPanel.add(this.depositButtonAFP);
        this.afterFundsPanel.add(this.exitButtonAFP);
        this.afterFundsPanel.add(this.errorLabelAFP);

        this.getContentPane().removeAll();
        this.afterFundsPanel.setVisible(true);
        this.add(this.afterFundsPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void afterRulesPanel()
    {
        JTextArea rulesText = new JTextArea();
        rulesText.setText(this.rules);
        rulesText.setEditable(false);
        rulesText.setLineWrap(true);
        rulesText.setWrapStyleWord(true);
        
        this.scrollPRP.setViewportView(rulesText);
        this.scrollPRP.setPreferredSize(new Dimension(600,200));
        this.scrollPRP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPRP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.afterRulesPanel.add(this.headingARP, BorderLayout.NORTH);
        this.afterRulesPanel.add(this.scrollPRP);
        this.afterRulesPanel.add(this.continueARP);
        
        this.getContentPane().removeAll();
        this.afterRulesPanel.setVisible(true);
        this.add(this.afterRulesPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    
    private void preRulesPanel()
    {
        JTextArea rulesText = new JTextArea();
        rulesText.setText(this.rules);
        rulesText.setEditable(false);
        rulesText.setLineWrap(true);
        rulesText.setWrapStyleWord(true);
        
        this.scrollPRP.setViewportView(rulesText);
        this.scrollPRP.setPreferredSize(new Dimension(600,200));
        this.scrollPRP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPRP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.preRulesPanel.add(this.headingPRP, BorderLayout.NORTH);
        this.preRulesPanel.add(this.scrollPRP);
        this.preRulesPanel.add(this.continuePRP);
        
        this.getContentPane().removeAll();
        this.preRulesPanel.setVisible(true);
        this.add(this.preRulesPanel);
        this.revalidate();
        this.repaint();
    }
    
    //----------------------------------------------------------------
    /**
     *
     * The update method overrides the observable update method to update
     * the appropriate JLabels and also set the current JPanel.
     * 
     */
    
    @Override
    public void update(Observable o, Object arg)
    {
        Model model = (Model) arg;
        
        if(this.startCount < 1)
        {
            this.messageLabelALP.setText("Welcome "+model.getUsername()+"");
            this.message2LabelALP.setText("You currently have $"+model.getAccount()+" in your account");
        }
            
        this.startCount++;
        
        if(model != null )
        {
            if(model.getGameFinishedPanel() != true)
            {
                if((model.getWin() == true) && (model.getDraw() == false) && (model.getLoss() == false)) //After game panel
                {
                    this.messageLabelGFP.setText("     "+"Congratulations, you WIN! | $20 has been added into your account, your current balance is $"+model.getAccount()+" | Win Rate: "+ model.getWinRate()+"     ");
                }
                else if((model.getWin() == false) && (model.getDraw() == false) && (model.getLoss() == true))
                {
                    this.messageLabelGFP.setText("     "+"Sorry, you LOST this hand | $20 has been deducted from your account, your current balance is $"+model.getAccount()+" | Win Rate: "+ model.getWinRate()+"     ");
                }
            }
        }
                
        if(model != null)
        {
            if(model.getBlackJackNPanel() == true)
            {
                this.userCardsBJNP.setText(model.getUserCards()); //Black Jack Panel
                this.casinoCardsBJNP.setText(model.getCasinoCards());
            }
        }

        
        if(model != null)
        {
            if(model.getAfterFundsPanel() == true)
            {
                this.message2LabelAFP.setText("You must deposit at least $"+model.getTableDifference()+" to continue playing");//After funds panel
            }
            
            if(model.getTransactionPanel())
            {
                this.messageLabel2TP.setText("You currently have $"+model.getAccount()+" in your account"); //Transaction panel
            }
        }    
        
        if(model != null)
        {
            if(model.getAfterLoginPanel() == true)
            {
                this.afterLoginPanel();
            }

            if(model.getTransactionPanel() == true)
            {
                this.transactionPanel();
            }

            if(model.getBlackJackNPanel() == true)
            {
                this.blackJackNormalPanel();
            }

            if(model.getGameFinishedPanel() == true)
            {
                this.gameFinsihedPanel();
            }

            if(model.getPreRulesPanel() == true)
            {
                this.preRulesPanel();
            }

            if(model.getAfterRulesPanel() == true)
            {
                this.afterRulesPanel();
            }

            if(model.getAfterFundsPanel() == true)
            {
                this.afterFundsPanel();
            }
        }
    }
}
