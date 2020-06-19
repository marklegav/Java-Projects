/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Rita
 */
public class SendEmailTxtAPI implements SendEmail {

    /**
     * Writes all emails and all messages received by 
     * parameter in a text file named "email.txt".
     * 
     * @param emails the list of emails to write in the text file "email.txt"
     * @param messages the list of messages to write in the text file "email.txt"
     */
    @Override
    public void sendEmails(List<String> emails, List<String> messages) {
        for (String email : emails) {
            for (String message : messages) {
                try {
                FileWriter file;
                file = new FileWriter("src/email.txt", true);
                PrintWriter print = new PrintWriter(file);
                print.println("From: noreply@T4J.pt");
                print.println("Email to: " + email);
                print.println(message);
                print.println("---------------------------------------------");
                print.close();
                } catch (IOException ex) {
                    System.out.println("Couldn't write email.");
                }
            }
        }
    }
    
}
