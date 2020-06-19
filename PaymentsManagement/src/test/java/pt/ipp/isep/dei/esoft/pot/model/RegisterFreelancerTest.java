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
import static org.junit.Assert.*;

/**
 *
 * @author Rita
 */
public class RegisterFreelancerTest {
    
    private RegisterFreelancer regfreel;
    private Freelancer freel1;
    
    public RegisterFreelancerTest() {
        regfreel = new RegisterFreelancer();
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
     * Test of newFreelancer method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testNewFreelancer() {
        System.out.println("newFreelancer");
        String id = "RC1";
        String name = "Rita Carneiro";
        LevelOfExpertise level = LevelOfExpertise.JUNIOR;
        String email = "rc@esoft.pt";
        String nif = "123";
        String iban = "123";
        String address = "Rua-Zona-CodPostal";
        String country = "Portugal";
        Freelancer expResult = new Freelancer(id, name, level, email, nif, iban, address, country);
        Freelancer result = regfreel.newFreelancer(name, level, email, nif, iban, address, country);
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        String name = "Rita Carneiro";
        String expResult1 = "RC1";
        String result1 = regfreel.setId(name);
        assertEquals(expResult1, result1);
        Freelancer freel = regfreel.newFreelancer("Rui Carvalho", LevelOfExpertise.SENIOR, "rc@esoft.pt", "123", "123", "Rua-Zona-CodPostal", "Portugal");
        regfreel.registerFreelancer(freel);
        String expResult2 = "RC2";
        String result2 = regfreel.setId(name);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getInitials method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testGetInitials() {
        System.out.println("getInitials");
        String name = "Joana Duarte Silva";
        String expResult = "JS";
        String result = regfreel.getInitials(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerFreelancer method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testRegisterFreelancer() {
        System.out.println("registerFreelancer");
        Freelancer freel = regfreel.newFreelancer("Rui Carvalho", LevelOfExpertise.SENIOR, "rc@esoft.pt", "123", "123", "Rua-Zona-CodPostal", "Portugal");;
        boolean expResult = true;
        boolean result = regfreel.registerFreelancer(freel);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateFreelancer method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testValidateFreelancer() {
        System.out.println("validateFreelancer");
        Freelancer freel2 = regfreel.newFreelancer("Maria Soares", LevelOfExpertise.SENIOR, "ms@esoft.pt", "789", "789", "Rua-Zona-CodPostal", "Portugal");
        boolean expResult1 = true;
        boolean result1 = regfreel.validateFreelancer(freel2);
        assertEquals(expResult1, result1);
        regfreel.registerFreelancer(freel2);
        Freelancer freel3 = regfreel.newFreelancer("Sara Duarte", LevelOfExpertise.JUNIOR, "sd@esoft.pt", "789", "789", "Rua-Zona-CodPostal", "Portugal");
        boolean expResult2 = false;
        boolean result2 = regfreel.validateFreelancer(freel3);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getFreelancerByID method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testGetFreelancerByID() {
        System.out.println("getFreelancerByID");
        String id = "RC1";
        Freelancer expResult = this.freel1;
        Freelancer result = regfreel.getFreelancerByID(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getFreelancerByNIF method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testGetFreelancerByNIF() {
        System.out.println("getFreelancerByNIF");
        String nif = "123";
        Freelancer expResult = this.freel1;
        Freelancer result = regfreel.getFreelancerByNIF(nif);
        assertEquals(expResult, result);
    }
    
}
