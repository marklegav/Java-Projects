/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rita
 */
public class FreelancerTest {

    Freelancer freel1;
    Freelancer freel2;
    Freelancer freel3;
    
    public FreelancerTest() {
        freel1 = new Freelancer("RC1", "Rita Carneiro", LevelOfExpertise.SENIOR, "rc@esoft.pt", "123", "123", "Rua-Zona-CodPostal", "Portugal");
        freel2 = new Freelancer("RD1", "Rodrigo Duarte", LevelOfExpertise.SENIOR, "rd@esoft.pt", "456", "456", "Rua-Zona-CodPostal", "Portugal");
        freel3 = new Freelancer("DD1", "Diogo Duarte", LevelOfExpertise.JUNIOR, "dd@esoft.pt", "123", "123", "Rua-Zona-CodPostal", "Portugal");
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of hasEmail method, of class Freelancer.
     */
    @org.junit.Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String email = "rc@esoft.pt";
        boolean expResult1 = true;
        boolean result1 = freel1.hasEmail(email);
        assertEquals(expResult1, result1);
        boolean expResult2 = false;
        boolean result2 = freel2.hasEmail(email);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hasId method, of class Freelancer.
     */
    @org.junit.Test
    public void testHasId() {
        System.out.println("hasId");
        String id = "RC1";
        boolean expResult1 = true;
        boolean result1 = freel1.hasId(id);
        assertEquals(expResult1, result1);
        boolean expResult2 = false;
        boolean result2 = freel2.hasId(id);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hasInitials method, of class Freelancer.
     */
    @org.junit.Test
    public void testHasInitials() {
        System.out.println("hasInitials");
        String initials = "RC";
        boolean expResult1 = true;
        boolean result1 = freel1.hasInitials(initials);
        assertEquals(expResult1, result1);
        boolean expResult2 = false;
        boolean result2 = freel2.hasInitials(initials);
        assertEquals(expResult2, result2);
    }
    
    /**
     * Test of equals method, of class Freelancer.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        boolean expResult1 = false;
        boolean result1 = freel1.equals(freel2);
        assertEquals(expResult1, result1);
        boolean expResult2 = true;
        boolean result2 = freel1.equals(freel3);
        assertEquals(expResult2, result2);
    }
    
}
