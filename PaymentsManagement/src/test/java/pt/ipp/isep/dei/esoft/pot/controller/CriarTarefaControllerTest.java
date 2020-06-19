/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Matheus Aguiar
 */
public class CriarTarefaControllerTest {
    
    private CriarTarefaController controller;
    
    public CriarTarefaControllerTest() {
        AplicacaoPOT.getInstance().doLogin("ma2@esoft.pt", "123");
        controller = new CriarTarefaController();
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
     * Test of newTask method, of class CreateTarefaController.
     */
    @org.junit.Test
    public void testNewTask() {
        System.out.println("newTask");
        String strID = "teste";
        String strDescricaoBreve = "teste";
        int duracao = 1;
        double custo = 1.0;
        String strCategoriaTarefa = "teste";
        boolean expResult = true;
        boolean result = controller.newTask(strID,strDescricaoBreve,
                duracao,custo,strCategoriaTarefa);
         assertEquals(expResult, result);
    }
    
    /**
     * Test of registaTarefa method, of class CreateTaskController.
     */
    @org.junit.Test
    public void testregistaTarefa() {
        System.out.println("registaFreelancer");
        boolean expResult = true;
        boolean result = controller.registaTarefa();
        assertEquals(expResult, result);
    }
    
}
