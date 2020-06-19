/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.utils.filereader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcel
 */
public class ReaderProviderTest {
    
    public ReaderProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getType method, of class ReaderProvider.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        ReadType name = ReadType.TXT;
        StrategyRead expResult = new TXTReaderStrategy();
        StrategyRead result = ReaderProvider.getType(name);
        assertTrue(result instanceof TXTReaderStrategy);
    }
        
}
