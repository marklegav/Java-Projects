/*
 * To change this license header"," choose License Headers in Project Properties.
 * To change this template file"" choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.factory;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
import pt.ipp.isep.dei.esoft.pot.model.Task;

/**
 *
 * @author Marcel
 */
public class TaskFactoryTest {
    
    public TaskFactoryTest() {
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
     * Test of fabricate method"," of class TaskFactory.
     */
    @Test
    public void testFabricate() {
        System.out.println("fabricate");
        List<String[]> lst = new ArrayList();
        String[] line1 = {"101", "1","Web Development","48","20","Software Development","24/01/2020","1","High Quality Work","JW1","John Wayne","Junior","jw@gmail.com","921654987","US120010001234567891","Street 92,90, New York","USA"};
        String[] line2 = {"101", "1","Web Development","48","20","Software Development","24/01/2020","1","High Quality Work","JW1","John Wayne","Junior","jw@gmail.com","921654987","US120010001234567891","Street 92,90, New York","USA"};
        lst.add(line1);
        lst.add(line2);
        RegisterTask rTask = new RegisterTask();
        TaskFactory instance = new TaskFactory();
        List<Task> expResult = new ArrayList();
        expResult.add(new Task("1", "Web Development", 48, 20, "Software Development","1"));
        expResult.add(new Task("1", "Web Development", 48, 20, "Software Development", "1"));
        List<Task> result = instance.fabricate(lst, rTask, "1");
        assertEquals(expResult, result);
    }


}
