/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Rita
 */
public class NotifyFreelancerControllerTest {
    
    public NotifyFreelancerControllerTest() {
        AplicacaoPOT.getInstance().doLogin("ma1@esoft.pt", "123");
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
     * Test of notifyFreelancersNow method, of class NotifyFreelancerController.
     */
    @org.junit.Test
    public void testNotifyFreelancersNow() {
        System.out.println("notifyFreelancersNow");
        NotifyFreelancerController instance = new NotifyFreelancerController();
        instance.notifyFreelancersNow();
    }
    
}
