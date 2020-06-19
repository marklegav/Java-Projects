/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Matheus Aguiar
 */
public class RegisterTaskTest {
    
  private RegisterTask regtask;
    private Task task;
    
    public RegisterTaskTest() {
        regtask = new RegisterTask();
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
     * Test of newTask method, of class RegisterTask.
     */
    @org.junit.Test
    public void testNewFreelancer() {
        System.out.println("newTask");
        String strID = "teste";
        String strDescricaoBreve = "teste";
        int duracao = 1;
        double custo = 1.0;
        String strCategoriaTarefa = "teste";
        Task expResult = new Task(strID, strDescricaoBreve, duracao, custo, strCategoriaTarefa, strID);
        Task result = regtask.newTarefa(strID, strDescricaoBreve, duracao, custo, strCategoriaTarefa, strID);
        assertEquals(expResult, result);
    }

   
   

    /**
     * Test of registerTask method, of class RegisterTask.
     */
    @org.junit.Test
    public void testRegisterFreelancer() {
        System.out.println("registerTask");
        Task tk = regtask.newTarefa("teste", "teste", 1, 1.0, "teste", "teste");
        boolean expResult = true;
        boolean result = regtask.registaTarefa(tk);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTask method, of class RegisterTask.
     */
    
    @org.junit.Test
    public void testvalidaTarefa() {
        System.out.println("validateTask");
        Task task = regtask.newTarefa("teste", "teste", 1, 1.0, "teste", "teste");
        boolean expResult = true;
        boolean result = regtask.registaTarefa(task);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaskByID method, of class RegisterFreelancer.
     */
    @org.junit.Test
    public void testgetTaskByID() {
        System.out.println("getTaskByID");
        String id = "teste";
        Task expResult = task;
        Task result = regtask.getTaskByID(id);
        assertEquals(expResult, result);
    }
 
    
}
