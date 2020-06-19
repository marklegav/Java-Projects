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
 * @author arccenio
 */
public class CollaboratorsTest {

    public CollaboratorsTest() {

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

    @Test
    public void testHasId() {
        System.out.println("hasId");
        String strId = "";
        Collaborators instance =  new Collaborators("arcenio","arcenio@gmail.com");
        boolean expResult = false;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);

    }





    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Collaborators instance = new Collaborator("arcenio","email");
        int expResult = 96619581;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Collaborators instance =new Collaborator("arcenio","email");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }


    
}
