///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pt.ipp.isep.dei.esoft.pot.utils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import junit.framework.Assert;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author Marcel
// */
//public class CSVReaderStrategyTest {
//    
//    public CSVReaderStrategyTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of setListFromFile method, of class CSVReaderStrategy.
//     */
//    @Test
//    public void testSetListFromFile() throws FileNotFoundException {
//        System.out.println("setListFromFile");
//        //Scanner in =  new Scanner("/src/main/resources/teste.csv");
//        File fileName = new File("teste.csv");
//        
//        CSVReaderStrategy instance = new CSVReaderStrategy();
//        List<String[]> expResult = new ArrayList();
//        String[] line1 = {"101","1","web development","48","20","software development",
//            "24/01/2020","1","high quality work","jw1","john wayne",
//            "junior","jw@gmail.com","921654987","us120010001234567891","street 92, 90, new york","usa"};
//        String[] line2 = {"102","2","Network Administration","20","40","Network Administration",
//            "25/01/2020","3","Non-expert, problem unsolved","MA","Marion Antoine",
//            "Senior","Marion190@hotmail.com","223654587","LU120010001234567891","Boulevard Royal, 100","Luxembourg"};
//        expResult.add(line1);
//        expResult.add(line2);
//        
//        instance.setListFromFile(fileName);
//    }
//    
//}
