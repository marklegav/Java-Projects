/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

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
public class FactoryProviderTest {
    
    public FactoryProviderTest() {
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
     * Test of getType method, of class FactoryProvider.
     */
    @Test
    public void testGetTypeTASK() {
        System.out.println("getTypeTASK");
        FactoryType name = FactoryType.TASK;
        FactoryUpStream result = FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof TaskFactory);
    }
        /**
     * Test of getType method, of class FactoryProvider.
     */
    @Test
       public void testGetTypeFREELANCER() {
        System.out.println("getTypeFREELANCER");
        FactoryType name = FactoryType.FREELANCER;
        FactoryUpStream result = FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof FreelancerFactory);
    }
     /**
     * Test of getType method, of class FactoryProvider.
     */
    @Test
    public void testGetTypeTRANSACTION() {
        System.out.println("getTypeTRANSACTION");
        FactoryType name = FactoryType.TRANSACTION;
        FactoryUpStream result = FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof TransactionFactory);
    }
    /**
     * Test of getType method, of class FactoryProvider.
     */
    @Test     
    public void testGetType() {
        System.out.println("getTypeORGANIZATION");
        FactoryType name = FactoryType.ORGANIZATION;
        FactoryUpStream result = FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof OrganizationFactory);
    }
    
}
