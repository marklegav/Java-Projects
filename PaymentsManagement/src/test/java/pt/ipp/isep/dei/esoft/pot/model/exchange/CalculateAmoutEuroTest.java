/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.exchange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcel
 */
public class CalculateAmoutEuroTest {
    
    public CalculateAmoutEuroTest() {
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
     * Test of calculate method, of class CalculateAmoutEuro.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        double costPerHour = 10;
        double taskDuration = 10;
        int factor = 2;
        String currencyFreelancer = "";
        CalculateAmoutEuro instance = new CalculateAmoutEuro();
        double expResult = 200;
        double result = instance.calculate(costPerHour, taskDuration, factor, currencyFreelancer);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getExchanceRate method, of class CalculateAmoutEuro.
     */
    @Test
    public void testGetExchanceRate() {
        System.out.println("getExchanceRate");
        String currencyOrg = "";
        String currencyFreelancer = "";
        CalculateAmoutEuro instance = new CalculateAmoutEuro();
        double expResult = 1.0;
        double result = instance.getExchanceRate(currencyOrg, currencyFreelancer);
        assertEquals(expResult, result, 0.0);
    }
    
}
