/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ipp.isep.dei.esoft.pot.model.Collaborator;

/**
 *
 * @author Marcel
 */
public class EmpacotamentoIT {
    
    public EmpacotamentoIT() {
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
     * Test of gravarArquivoBinario method, of class Empacotamento.
     */
    @Test
    public void testGravarArquivoBinario() {
        System.out.println("gravarArquivoBinario");
        List<Object> lista = new ArrayList();
        lista.add(new Collaborator("test1", "t1@test.pt"));
        lista.add(new Collaborator("testet2", "t2@test.pt"));
        String nomeArq = "teste.bin";
        Empacotamento.gravarArquivoBinario(lista, nomeArq);

    }

    /**
     * Test of lerArquivoBinario method, of class Empacotamento.
     */
    @Test
    public void testLerArquivoBinario() {
        System.out.println("lerArquivoBinario");
        String nomeArq = "teste.bin";
        List<Object> expResult = new ArrayList();
        expResult.add(new Collaborator("test1", "t1@test.pt"));
        expResult.add(new Collaborator("testet2", "t2@test.pt"));
        List<Object> result = Empacotamento.lerArquivoBinario(nomeArq);
        assertEquals(expResult, result);
    }
    
}
