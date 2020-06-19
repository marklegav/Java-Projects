///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pt.ipp.isep.dei.esoft.pot.model;
//
//import java.util.List;
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
//public class OrganizationIT {
//    
//    private Organization org;
//    private Collaborator colab;
//    private Manager man;
//    
//    public OrganizationIT() {
//        this.colab = new Collaborator("tester", "teste@test.pt");
//        this.man = new Manager("tester2", "teste2@test.pt");
//        this.org = new Organization("teste Inc", 123456789, colab, man);
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
//     * Test of getM_Colaborador method, of class Organization.
//     */
//    @Test
//    public void testGetM_Colaborador() {
//        System.out.println("getM_Colaborador");
//        Organization instance = new Organization();
//        Collaborator expResult = null;
//        Collaborator result = instance.getM_Colaborador();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getM_manager method, of class Organization.
//     */
//    @Test
//    public void testGetM_manager() {
//        System.out.println("getM_manager");
//        Organization instance = new Organization();
//        Manager expResult = null;
//        Manager result = instance.getM_manager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPayDay method, of class Organization.
//     */
//    @Test
//    public void testGetPayDay() {
//        System.out.println("getPayDay");
//        Organization instance = new Organization();
//        int expResult = 0;
//        int result = instance.getPayDay();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPayDay method, of class Organization.
//     */
//    @Test
//    public void testSetPayDay() {
//        System.out.println("setPayDay");
//        int payDay = 0;
//        Organization instance = new Organization();
//        instance.setPayDay(payDay);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Organization.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Organization instance = new Organization();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Organization.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object o = null;
//        Organization instance = new Organization();
//        boolean expResult = false;
//        boolean result = instance.equals(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Organization.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Organization instance = new Organization();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of novoColaborador method, of class Organization.
//     */
//    @Test
//    public void testNovoColaborador() {
//        System.out.println("novoColaborador");
//        String strNome = "";
//        String strEmail = "";
//        Collaborator expResult = null;
//        Collaborator result = Organization.novoColaborador(strNome, strEmail);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of newManager method, of class Organization.
//     */
//    @Test
//    public void testNewManager() {
//        System.out.println("newManager");
//        String strNome = "";
//        String strEmail = "";
//        Manager expResult = null;
//        Manager result = Organization.newManager(strNome, strEmail);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hasCollaboratorWithEmail method, of class Organization.
//     */
//    @Test
//    public void testHasCollaboratorWithEmail() {
//        System.out.println("hasCollaboratorWithEmail");
//        String email = "este@test.pt";
//        Organization instance = new Organization();
//        boolean expResult = true;
//        boolean result = instance.hasCollaboratorWithEmail(email);
//    }
//
//    /**
//     * Test of validatePayDay method, of class Organization.
//     */
//    @Test
//    public void testValidatePayDay() {
//        System.out.println("validatePayDay");
//        int payDay = 0;
//        Organization instance = new Organization();
//        boolean expResult = false;
//        boolean result = instance.validatePayDay(payDay);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListTaskForPayment method, of class Organization.
//     */
//    @Test
//    public void testGetListTaskForPayment() {
//        System.out.println("getListTaskForPayment");
//        Organization instance = new Organization();
//        List<String> expResult = null;
//        List<String> result = instance.getListTaskForPayment();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
