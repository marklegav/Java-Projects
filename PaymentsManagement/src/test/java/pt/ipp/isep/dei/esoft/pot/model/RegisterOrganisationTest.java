/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;

/**
 *
 * @author Marcel
 */
public class RegisterOrganisationTest {
    
    private AutorizacaoFacade facade = new AutorizacaoFacade();
    private RegisterOrganisation instance;
    private Organization org;
    private Collaborator colab;
    private Manager man;
    
    public RegisterOrganisationTest() {
        this.instance = new RegisterOrganisation(facade);
        this.colab = new Collaborator("tester", "teste@test.pt");
        this.man = new Manager("tester2", "teste2@test.pt");
        this.org = new Organization("teste Inc", 123456789, colab, man);
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
     * Test of novaOrganizacao method, of class RegisterOrganisation.
     */
    @Test
    public void testNovaOrganizacao() {
        System.out.println("novaOrganizacao");
        String strNome = "Test Inc";
        Integer strNIF = 123456789;
        Organization expResult = this.org;
        Organization result = instance.novaOrganizacao(strNome, strNIF, this.colab, this.man);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of registaOrganizacao method, of class RegisterOrganisation.
     */
    @Test
    public void testRegistaOrganizacao() {
        System.out.println("registaOrganizacao");
        boolean expResult = true;
        boolean result = instance.registaOrganizacao(org);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerEmployeeAsUser method, of class RegisterOrganisation.
     */
//    @Test
//    public void testRegisterEmployeeAsUser() {
//        System.out.println("registerEmployeeAsUser");
//        String paper = Constantes.PAPEL_COLABORADOR_ORGANIZACAO;
//        String pwd = "123";
//        boolean expResult = true;
//        boolean result = instance.registerEmployeeAsUser(colab, paper, pwd);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of addOrganizacao method, of class RegisterOrganisation.
     */
    @Test
    public void testAddOrganizacao() {
        System.out.println("addOrganizacao");
        boolean expResult = true;
        boolean result = instance.addOrganizacao(org);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaOrganizacao method, of class RegisterOrganisation.
     */
    @Test
    public void testValidaOrganizacao() {
        System.out.println("validaOrganizacao");
        boolean expResult = true;
        boolean result = instance.validaOrganizacao(org);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompanByLogin method, of class RegisterOrganisation.
     */
    @Test
    public void testGetCompanByLogin() {
        System.out.println("getCompanByLogin");
        String userEmail = "teste@test.pt";
        instance.addOrganizacao(org);
        Organization expResult = org;
        Organization result = instance.getCompanByLogin(userEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompanyByUserEmail method, of class RegisterOrganisation.
     */
    @Test
    public void testGetCompanyByUserEmail() {
        System.out.println("getCompanyByUserEmail");
        String email = "teste@test.pt";
        instance.addOrganizacao(org);
        Organization expResult = this.org;
        Organization result = instance.getCompanyByUserEmail(email);
        assertTrue(expResult.equals(result));
    }
    
}
