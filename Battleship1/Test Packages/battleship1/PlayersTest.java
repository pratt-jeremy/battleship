/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;

import static org.junit.Assert.*;

/**
 *
 * @author JPratt2
 */
public class PlayersTest {
    
    public PlayersTest() {
    }

    /**
     * Test of displayName method, of class Players.
     */
    
    public void testDisplayName() {
        System.out.println("displayName");
        Players instance = new Players();
        instance.displayName();        
    }

    /**
     * Test of getWinningPercentage method, of class Players.
     */
  
    public void testGetWinningPercentage() {
        
        // test 1
        System.out.println("getWinningPercentage - Test 1");
        long wins = 5L;
        long losses = 4L;   
        double expResult = 56L;      
        Players instance = new Players();
        double result = instance.getWinningPercentage();       
        assertEquals(expResult, result, 0.0);
        
        // test 2
        System.out.println("getWinningPercentage - Test 2");
        wins = -1L;
        losses = 4L;  
        expResult = -999L;
        result = instance.getWinningPercentage();
        assertEquals(expResult, result, 0.0);
        
        // test 3
        System.out.println("getWinningPercentage - Test 3");
        wins = 3L;
        losses = -1L; 
        expResult = -999L;
        result = instance.getWinningPercentage();
        assertEquals(expResult, result, 0.0);
                       
        // test 4
        System.out.println("\ngetWinningPercentage - Test 4");
        wins = -3L;
        losses = -4L;    
        expResult = -999L;
        result = instance.getWinningPercentage();
        assertEquals(expResult, result, 0.0);
                        
        // test 5
        System.out.println("getWinningPercentage - Test 5");
        wins = 0L;
        losses = 0L;    
        expResult = 0L;
        result = instance.getWinningPercentage();
        assertEquals(expResult, result, 0.0);
        
    }
}