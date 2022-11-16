package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.util.ArrayList;

public class Casino extends User{
    
    public Casino()
    {
        super("Casino");
        this.existingUser();
    }
    
    //----------------------------------------------------------------
    
    private void existingUser()
    {
        super.add(this.data.readCasinoData());
        setCasinoWinRate();
    }
    
    //----------------------------------------------------------------
    
    private void setCasinoWinRate()
    {
        ArrayList<Integer> winsLosses = new ArrayList();
        
        winsLosses = this.data.readCasinoWinRate();
        
        super.wins = winsLosses.get(0);
        super.losses = winsLosses.get(1);
    }
    
    //----------------------------------------------------------------
    
    public void saveCasino()
    {
        this.data.writeCasinoData(this.getDollars());
        this.data.writeCasinoWinRate(this.getWins(), this.getLosses());
        this.data.closeConnection();
    }
}
