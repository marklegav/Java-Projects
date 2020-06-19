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
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;

/**
 *
 * @author Rita
 */
public class CreateFreelancerControllerTest {
    
    private CreateFreelancerController controller;
    
    public CreateFreelancerControllerTest() {
        AplicacaoPOT.getInstance().doLogin("ma2@esoft.pt", "123");
        controller = new CreateFreelancerController();
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
     * Test of newFreelancer method, of class CreateFreelancerController.
     */
    @org.junit.Test
    public void testNewFreelancer() {
        System.out.println("newFreelancer");
        String name = "João Sousa";
        LevelOfExpertise level = LevelOfExpertise.JUNIOR;
        String email = "js@esoft.pt";
        String nif = "111";
        String iban = "111";
        String address = "Rua-Zona-CodPostal";
        String country = "Portugal";
        boolean expResult = true;
        boolean result = controller.newFreelancer(name, level, email, nif, iban, address, country);
        assertEquals(expResult, result);
    }

    /**
     * Test of registaFreelancer method, of class CreateFreelancerController.
     */
    @org.junit.Test
    public void testRegistaFreelancer() {
        System.out.println("registaFreelancer");
        boolean expResult = true;
        boolean result = controller.registerFreelancer();
        assertEquals(expResult, result);
    }
    
}
