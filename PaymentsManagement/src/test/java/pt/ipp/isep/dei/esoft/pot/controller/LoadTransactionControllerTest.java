///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pt.ipp.isep.dei.esoft.pot.controller;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Marcel
// */
//public class LoadTransactionControllerTest {
//    
//    public LoadTransactionControllerTest() {
//        
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
//     * Test of newLoadTransaction method, of class LoadTransactionController.
//     */
//    @Test
//    public void testNewLoadTransaction() {
//        System.out.println("newLoadTransaction");
//        LoadTransactionController instance = new LoadTransactionController();
//        boolean expResult = true;
//        boolean result = instance.newLoadTransaction();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addFile method, of class LoadTransactionController.
//     */
//    @Test
//    public void testAddFile() throws Exception {
//        System.out.println("addFile");
//        String ofileName = "teste.csv";
//        LoadTransactionController instance = new LoadTransactionController();
//        instance.newLoadTransaction();
//        boolean expResult = true;
//        boolean result = instance.addFile(ofileName);
//        assertEquals(expResult, result);
//    }
//
////    /**
////     * Test of createPaymentTransactionByFile method, of class LoadTransactionController.
////     */
////    @Test
////    public void testCreatePaymentTransactionByFile() throws Exception {
////        System.out.println("createPaymentTransactionByFile");
////        LoadTransactionController instance = new LoadTransactionController();
////        boolean expResult = false;
////        boolean result = instance.createPaymentTransactionByFile();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//}
