///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pt.ipp.isep.dei.esoft.pot.model.factory;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
//import pt.ipp.isep.dei.esoft.pot.model.LevelOfExpertise;
//import pt.ipp.isep.dei.esoft.pot.model.RegisterFreelancer;
//import pt.ipp.isep.dei.esoft.pot.model.RegisterTask;
//import pt.ipp.isep.dei.esoft.pot.model.RegisterTransaction;
//import pt.ipp.isep.dei.esoft.pot.model.Task;
//import pt.ipp.isep.dei.esoft.pot.model.Transaction;
//
///**
// *
// * @author Marcel
// */
//public class TransactionFactoryTest {
//    
//    public TransactionFactoryTest() {
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
////    /**
////     * Test of fabricate method"," of class TaskFactory.
////     */
//    @Test
//    public void testFabricate() {
//        System.out.println("fabricate");
//        List<String[]> lst = new ArrayList();
//        String[] line1 = {"101", "1","Web Development","48","20","Software Development","24/01/2020","1","High Quality Work","JW1","John Wayne","Junior","jw@gmail.com","921654987","US120010001234567891","Street 92,90, New York","USA"};
//        lst.add(line1);
//        RegisterTransaction rTrans = new RegisterTransaction();
//        TransactionFactory instance = new TransactionFactory();
//        RegisterFreelancer rFree = new RegisterFreelancer();
//        RegisterTask rTsk = new RegisterTask();
//        rFree.registerFreelancer(new Freelancer("JW1","John Wayne",LevelOfExpertise.valueOf("JUNIOR"),"jw@gmail.com","921654987","US120010001234567891","Street 92-90- New York","USA"));
//        rTsk.registaTarefa(new Task("1","Web Development", 48, 20,"Software Development","1"));
//        List<Transaction> expResult = new ArrayList();
//        expResult.add(new Transaction(new Task("1","Web Development", 48, 20,"Software Development","1"), 
//                new Freelancer("JW1","John Wayne",LevelOfExpertise.valueOf("JUNIOR"),"jw@gmail.com","921654987","US120010001234567891","Street 92-90- New York","USA"),
//                "101","24/01/2020",1,"High Quality Work","1"));
//        List<Transaction> result = instance.fabricate(lst, rTrans, "1");
//        assertEquals(expResult, result);
//    }
//
//    
//}
