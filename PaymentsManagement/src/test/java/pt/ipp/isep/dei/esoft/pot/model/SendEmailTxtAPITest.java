/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

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
 * @author Rita
 */
public class SendEmailTxtAPITest {
    
    public SendEmailTxtAPITest() {
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
     * Test of sendEmails method, of class SendEmailTxtAPI.
     */
    @Test
    public void testSendEmails() {
        System.out.println("sendEmails");
        List<String> emails = new ArrayList<>();
        emails.add("test@test.pt");
        List<String> messages = new ArrayList<>();
        messages.add("hello, this is a test");
        SendEmailTxtAPI instance = new SendEmailTxtAPI();
        instance.sendEmails(emails, messages);
    }
    
}
