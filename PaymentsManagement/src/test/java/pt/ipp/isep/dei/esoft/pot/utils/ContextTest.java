///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pt.ipp.isep.dei.esoft.pot.utils;
//
//import java.util.List;
//import java.util.Properties;
//import java.util.Set;
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
//public class ContextTest {
//    
//    public ContextTest() {
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
//     * Test of loadProperties method, of class Context.
//     */
//    @Test
//    public void testLoadProperties() {
//        System.out.println("loadProperties");
//        Context instance = new Context();
//        Properties expResult = new Properties();
//        Properties result = instance.loadProperties();
//        assertNotNull(result);
//    }
//
//    /**
//     * Test of getContext method, of class Context.
//     */
//    @Test
//    public void testGetContext() {
//        System.out.println("getContext");
//        Context instance = new Context();
//        instance.getContext();
//    }
//
//    /**
//     * Test of getQtObjects method, of class Context.
//     */
//    @Test
//    public void testGetQtObjects() {
//        System.out.println("getQtObjects");
//        Context instance = new Context();
//        String expResult = "1";
//        instance.loadProperties();
//        String result = instance.getQtObjects();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of createObjects method, of class Context.
//     */
//    @Test
//    public void testCreateObjects() {
//        System.out.println("createObjects");
//        Context instance = new Context();
//        List expResult = null;
//        List result = instance.createObjects();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of creteDAO method, of class Context.
//     */
//    @Test
//    public void testCreteDAO() throws Exception {
//        System.out.println("creteDAO");
//        int i = 0;
//        Context instance = new Context();
//        DAO expResult = null;
//        DAO result = instance.creteDAO(i);
//        assertNotNull(result);
//    }
//    
//    @Test
//    public void testGetClassProp() {
//        Context instance = new Context();
//        String expResult = "pt.ipp.isep.dei.esoft.pot.model.Freelancer";
//        instance.loadProperties();
//        String result = instance.getClassProp();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getAllKeys method, of class Context.
//     */
//    @Test
//    public void testGetAllKeys() {
//        System.out.println("getAllKeys");
//        Context instance = new Context();
//        Set<Object> expResult = null;
//        Set<Object> result = instance.getAllKeys();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
