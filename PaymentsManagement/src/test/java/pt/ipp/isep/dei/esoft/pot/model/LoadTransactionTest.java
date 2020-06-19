/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryProvider;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryType;
import pt.ipp.isep.dei.esoft.pot.model.factory.TaskFactory;
import pt.ipp.isep.dei.esoft.pot.model.factory.FactoryUpStream;
import pt.ipp.isep.dei.esoft.pot.model.factory.TransactionFactory;
import pt.ipp.isep.dei.esoft.pot.model.utils.filereader.CSVReaderStrategy;
import pt.ipp.isep.dei.esoft.pot.model.utils.filereader.StrategyRead;

/**
 *
 * @author Marcel
 */
public class LoadTransactionTest {
   
        private LoadTransaction instance;
        private RegisterTask rTask;
        private RegisterFreelancer rFreela;
        private List<Task> lstTsk = new ArrayList();
        private List<Freelancer> lstFree= new ArrayList();
        private List<List<?>> lst = new ArrayList();
        private List<String[]> lstFile = new ArrayList();
    
    
    public LoadTransactionTest() {
        this.instance = new LoadTransaction("1", "teste","org", new Date());
        this.rTask = new RegisterTask();
        this.rFreela = new RegisterFreelancer();
        this.lstTsk.add(new Task("1", "Web Development",48,20.0,"Software Development", "123"));
        this.lstFree.add(new Freelancer("JW1", "John Wayne", LevelOfExpertise.JUNIOR, "jw@gmail.com", "921654987", "US120010001234567891", "Street 92- 90- New York", "USA"));
        String line = "101;1;Web Development;48;20;Software Development;24/01/2020;1;High Quality Work;JW1;John Wayne;Junior;jw@gmail.com;921654987;US120010001234567891;Street 92- 90- New York;USA";
        this.lstFile.add(line.split(";"));
        this.lst.add(lstTsk);
        this.lst.add(lstFree);
        
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
    public void testGetFactoryTASK() {
        System.out.println("getFactory");
        FactoryType name = FactoryType.TASK;
        FactoryUpStream result = FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof TaskFactory);
    }
    
    /**
     * Test of getType method, of class FactoryProvider.
     */
    @Test
    public void testGetFactoryTRANSACTION() {
        System.out.println("getFactory");
        FactoryType name = FactoryType.TRANSACTION;
        FactoryUpStream result = pt.ipp.isep.dei.esoft.pot.model.factory.FactoryProvider.getType(name);
        Assert.assertTrue(result instanceof TransactionFactory);
    }

    /**
     * Test of loadTransaction method, of class LoadTransaction.
     */
//    @Test
//    public void testLoadTransaction() {
//        System.out.println("loadTransaction");
//        File fileName = new File("/src/test/resources/TestReader.csv");
//        String orgNIF = "123";
//        LoadTransaction instance = this.instance;
//        instance.loadTransaction(fileName, orgNIF);
//    }

    /**
     * Test of setStrategyReader method, of class LoadTransaction.
     */
    @Test
    public void testSetStrategyReader() {
        System.out.println("setStrategyReader");
        String extension = "csv";
        LoadTransaction instance = this.instance;
        StrategyRead result = instance.setStrategyReader(extension);
        assertTrue(result instanceof CSVReaderStrategy);
    }

//    /**
//     * Test of factory method, of class LoadTransaction.
//     */
//    @Test
//    public void testFactory() throws FileNotFoundException {
//        System.out.println("factory");
//        List lstFile = this.lstFile;
//        String orgNIF = "123";
//        LoadTransaction instance = this.instance;
//        List<List<?>> expResult = this.lst;
//        List<List<?>> result = instance.factory(lstFile, orgNIF);
//        assertEquals(expResult, result);
//    }       
    
}
