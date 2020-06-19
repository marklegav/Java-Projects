/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;
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
public class OrganizationTest {
    
    public OrganizationTest() {
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
    public void testSetPayDay() {
        System.out.println("setPayDay");
        Collaborator col=new Collaborator("armando","armando@gmail");
        Manager ma =new Manager("Rita","rita@gmail");
        int payDay = 0;
        Organization instance = new  Organization("MBS",123,col,ma);
        instance.setPayDay(payDay);

    }


    @Test
    public void testNovoColaborador() {
        System.out.println("novoColaborador");
        String strNome = "armando";
        String strEmail = "armando@gmail";
        Collaborator expResult = new Collaborator(strNome,strEmail);
        Collaborator result = Organization.novoColaborador(strNome, strEmail);
        assertEquals(expResult, result);

    }

    @Test
    public void testNewManager() {
        System.out.println("newManager");
        String strNome = "Rita";
        String strEmail = "rita@gmail";
        Manager expResult = new Manager(strNome,strEmail);
        Manager result = Organization.newManager(strNome, strEmail);
        assertEquals(expResult, result);

    }

    @Test
    public void testHasCollaboratorWithEmail() {
        System.out.println("hasCollaboratorWithEmail");
        Collaborator col=new Collaborator("armando","armando@gmail");
        Manager ma =new Manager("Rita","rita@gmail");
        Organization instance = new Organization("MBS",123456,col,ma);
        String email = "";
        boolean expResult = false;
        boolean result = instance.hasCollaboratorWithEmail(email);
        assertEquals(expResult, result);

    }

    
}
