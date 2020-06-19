/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.utils.filereader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcel
 */
public class TXTReaderStrategyTest {
    
    public TXTReaderStrategyTest() {
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
     * Test of setListFromFile method, of class TXTReaderStrategy.
     */
    @Test
    public void testSetListFromFile() {
        System.out.println("setListFromFile");
        File fileName = new File("src/test/resources/TestReader.txt");
        TXTReaderStrategy instance = new TXTReaderStrategy();
        String line = "101	1	Web Development	48	20	Software Development	24/01/2020	1	High Quality Work	JW1	John Wayne	Junior	jw@gmail.com	921654987	US120010001234567891	Street 92- 90- New York	USA";
        List<String[]> expResult = new ArrayList();
        expResult.add(line.split("	"));
        List<String[]> result = instance.setListFromFile(fileName);
        String[] expResult2 = expResult.get(0);
        String[] result2 = result.get(0);
        assertEquals(expResult2[0], result2[0]);
    }
    
}
