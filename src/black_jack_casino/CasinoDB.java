package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
* 
* The Casino DB class reads and writes data from a connected database
* 
**/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class CasinoDB {
    
    private CasinoDBManager dbManager;
    private Connection conn;
    private Statement statement;
    private int userID;
    private int newUserID;
    
    /**
    * 
    * The constructor method establishes a new database connection using the
    * casino DB manager class, and then initializes a statement
    * 
    **/
    public CasinoDB()
    {
        this.dbManager = new CasinoDBManager();
        this.conn = this.dbManager.getConnection();
        
        try 
        {
        statement = conn.createStatement();
        } catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    //----------------------------------------------------------------
    
    public void closeConnection()
    {
        this.dbManager.closeConnections();
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The check user method takes a username string as an input, and writes a statement
    * to the connected database to see if the username exists in the database
    * 
    **/
    
    public boolean checkUser(String username)
    {
        boolean same = false;
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM USERDATA WHERE USERNAME = '"+username+"'");
            
            if(rs != null)
            { 
                while(rs.next())
                {
                    this.userID = rs.getInt(1);
                    same = true;
                }
                
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return same;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The get user account reads and returns an existing users int account value
    * 
    **/
    
    public int getUserAccount()
    {
        int account = 0;
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM USERDATA WHERE USERID="+this.userID);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    account = rs.getInt("userdollars");
                }
               
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return account;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The get user wins method reads and returns an existing users wins from the database
    * 
    **/
    
    public int getUserWins()
    {
        int wins = 0;
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM USERWINRATE WHERE USERID="+this.userID);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    wins = rs.getInt("userwins");
                }
               
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return wins;
    }
    
    //----------------------------------------------------------------
    /**
    *  
    * The get user losses method reads and returns an existing users losses from the database
    * 
    **/
    
    public int getUserLosses()
    {
        int losses = 0;
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM USERWINRATE WHERE USERID="+this.userID);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    losses = rs.getInt("userlosses");
                }
               
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return losses;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The read casino data method reads and returns the casino dollars int from the database
    * 
    **/
    
    public int readCasinoData()
    {
        int account = 0;
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM CASINODATA");
            
            if(rs != null)
            {
                while(rs.next())
                {
                    account = rs.getInt("casinodollars");
                }
               
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return account;        
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The read casino win rate method reads a casinos wins and losses value from the database
    * and stores the values in an array list which is returned
    * 
    **/
    
    public ArrayList<Integer> readCasinoWinRate()
    {
        ArrayList<Integer> winRate = new ArrayList();
        
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM CASINOWINRATE");
            
            if(rs != null)
            {
                while(rs.next())
                {
                    winRate.add(rs.getInt("casinowins"));
                    winRate.add(rs.getInt("casinolosses"));
                }
               
                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return winRate;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The new user id method creates a new user id for new users, after reading
    * the total number of users from the database and adding one to create a
    * unique id
    * 
    **/
    
    private void newUserId()
    {
        ResultSet rs = null;
        
        try
        {
            statement = conn.createStatement();

            rs = statement.executeQuery("SELECT COUNT(*) FROM USERDATA");

            if(rs != null)
            {
                while(rs.next())
                {
                    this.newUserID = rs.getInt("1")+1;
                }

                rs.close();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The write user data method takes the username string, account value int,
    * and Boolean existing components as an input, and will write the username,
    * account and user id values to the database. If the user is existing it will
    * delete that user from the database and rewrite it, otherwise if a new user
    * is inputted it will directly write its attributes to the database.
    * 
    **/
    
    public void writeUserData(String username, int account, boolean existing)
    {
        int id;
        
        if(existing != true)
        {
            newUserId();
            id = this.newUserID;
        }
        else
        {
            try
            {
                Statement statementDel = conn.createStatement();
                
                statementDel.addBatch("DELETE FROM USERDATA WHERE USERID="+this.userID);
                statementDel.executeBatch();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            id = this.userID;
        }
        
        try
        {
            statement = conn.createStatement();
            
            statement.addBatch("INSERT INTO USERDATA VALUES(" + id + ",'" + username + "'," + account + ")");
            statement.executeBatch();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The write user win rate method takes a users wins, losses, and existing 
    * Boolean values as an input and writes the user wins and losses to the database.
    * If the user is existing the users outdated data will be deleted before it is
    * rewritten.
    * 
    **/
    
    public void writeUserWinRate(int wins, int losses, boolean existing)
    {
        int id = 0;
        
        if(existing != true)
        {
            id = this.newUserID;
        }
        else
        {
            try
            {
                Statement statementDel = conn.createStatement();
                
                statementDel.addBatch("DELETE FROM USERWINRATE WHERE USERID="+this.userID);
                statementDel.executeBatch();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            id = this.userID;
        }
        
        try
        {
            statement = conn.createStatement();
            
            statement.addBatch("INSERT INTO USERWINRATE VALUES(" + id + "," + wins + "," + losses + ")");
            statement.executeBatch();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The write casino data takes the casinos account int as input, and updates
    * the value in the database.
    * 
    **/
    
    public void writeCasinoData(int account)
    {
        try
        {
            statement = conn.createStatement();
            
            statement.addBatch("UPDATE CASINODATA SET CASINODOLLARS = " + account + " WHERE CASINOID = 1");
            statement.executeBatch();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The write casino win rate takes the casinos win and losses integers as
    * input and updates the database with the updated values
    * 
    **/
    
    public void writeCasinoWinRate(int wins, int losses)
    {
        try
        {
            statement = conn.createStatement();
            
            statement.addBatch("UPDATE CASINOWINRATE SET CASINOWINS = " + wins + ", CASINOLOSSES = " + losses + " WHERE CASINOID = 1");
            statement.executeBatch();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CasinoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
