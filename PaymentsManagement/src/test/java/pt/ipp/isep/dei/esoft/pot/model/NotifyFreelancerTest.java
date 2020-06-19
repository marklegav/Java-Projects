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

/**
 *
 * @author Rita
 */
public class NotifyFreelancerTest {
    
    public NotifyFreelancerTest() {
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
     * Test of getFreelancersThatApply method, of class NotifyFreelancer.
     */
    @org.junit.Test
    public void testGetFreelancersThatApply() {
        System.out.println("getFreelancersThatApply");
        NotifyFreelancer instance = new NotifyFreelancer();
        instance.getFreelancersThatApply();
    }

    /**
     * Test of writeEmail method, of class NotifyFreelancer.
     */
    @org.junit.Test
    public void testWriteEmail() {
        System.out.println("writeEmail");
        String freelName = "Rita";
        NotifyFreelancer instance = new NotifyFreelancer();
        String expResult = "Hello Rita,"
                + "\nDuring this past year you had a mean task delay time higher "
                + "than 3 hours and your percentage of delays is currently "
                + "higher than the overall percentage of delays."
                + "\nThis means your performance is bellow expectations.";
        String result = instance.writeEmail(freelName);
        assertEquals(expResult, result);
    }

    /**
     * Test of notifyFreelancers method, of class NotifyFreelancer.
     */
    @org.junit.Test
    public void testNotifyFreelancers() {
        System.out.println("notifyFreelancers");
        NotifyFreelancer instance = new NotifyFreelancer();
        instance.notifyFreelancers();
    }
    
}
