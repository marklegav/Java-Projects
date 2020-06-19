/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
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
public class RegisterTransactionIT {
    
    private List<Transaction> lstTrans = new ArrayList();
    private RegisterTransaction rTrans;
    
    public RegisterTransactionIT() {
        this.rTrans = new RegisterTransaction();
        Task tsk1 = new Task("1", "teste", 1, 1, "Teste", "123");
        Task tsk2 = new Task("1", "teste", 1, 1, "Teste", "456");
        Freelancer free = new Freelancer("123", "Teste", LevelOfExpertise.SENIOR, "teste", "123", "123", "1-1-1", "test");
        rTrans.addTransaction(new Transaction(tsk1, free, "1", "1", 1, "1", "123"));
        rTrans.addTransaction(new Transaction(tsk2, free, "1", "1", 1, "1", "456"));
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
     * Test of getListTransactioByOrg method, of class RegisterTransaction.
     */
    @Test
    public void testGetListTransactioByOrg() {
        System.out.println("getListTransactioByOrg");
        String orgNIF = "123";
        RegisterTransaction instance = this.rTrans;
        List<Transaction> expResult = new ArrayList();
        expResult.add(new Transaction(new Task("1", "teste", 1, 1, "Teste", "123"),
                new Freelancer("123", "Teste", LevelOfExpertise.SENIOR, "teste", "123", "123", "1-1-1", "test"),
                "1", "1", 1, "1", "123"));
        List<Transaction> result = instance.getListTransactioByOrg(orgNIF);
        assertEquals(expResult, result);
    }


    
}
