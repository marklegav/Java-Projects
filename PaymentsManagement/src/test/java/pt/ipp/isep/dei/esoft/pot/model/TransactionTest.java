/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.pot.model.exchange.CalculateAmout;
import pt.ipp.isep.dei.esoft.pot.model.exchange.CalculateAmoutEuro;

/**
 *
 * @author Marcel
 */
public class TransactionTest {
    
    private Task t1;
    private Freelancer fJunior, fSenior;
    private Transaction trJunior, trSenior;
    
    public TransactionTest() {
        t1 = new Task("1", "abc", 10, 20, "cat", "1");
        fSenior = new Freelancer ("1", "Teste", LevelOfExpertise.SENIOR, "teste", "123", "123", "1-1-1", "Brazil");
        fJunior = new Freelancer ("1", "Teste", LevelOfExpertise.JUNIOR, "teste", "123", "123", "1-1-1", "Brazil");
        trJunior = new Transaction(t1, fJunior, "1", "20/05/2020", 1, "abc", "123");
        trSenior = new Transaction(t1, fSenior, "1", "20/05/2020", 1, "abc", "123");
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
     * Test of factorLevel method, of class Transaction.
     */
    @Test
    public void testFactorLevelSenior() {
        System.out.println("factorLevelSenior");
        Transaction instance = this.trSenior;
        double expResult = 2.0;
        double result = instance.factorLevel();
        assertEquals(expResult, result, 0.0);
    }
    
      /**
     * Test of factorLevel method, of class Transaction.
     */
    @Test
    public void testFactorLevelJunior() {
        System.out.println("factorLevelJunior");
        Transaction instance = this.trJunior;
        double expResult = 1.0;
        double result = instance.factorLevel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateAmountPay method, of class Transaction.
     */
    @Test
    public void testCalculateAmountPay() {
        System.out.println("calculateAmountPay");
        Transaction instance = this.trJunior;
        double expResult = 200.0;
        double result = instance.calculateAmountPay();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getExchangeAlg method, of class Transaction.
     */
    @Test
    public void testGetExchangeAlg() {
        System.out.println("getExchangeAlg");
        Transaction instance = this.trJunior;
        CalculateAmout result = instance.getExchangeAlg();
        assertTrue(result instanceof CalculateAmoutEuro);
    }    
}
