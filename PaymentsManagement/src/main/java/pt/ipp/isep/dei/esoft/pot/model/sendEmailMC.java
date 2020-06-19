/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author arccenio
 */
public class sendEmailMC  { 
     public  void sendEmail(String strEmailM, String pwdM, String strEmailC, String pwdC) {
        
            try{
                FileWriter writer = new FileWriter("src/emailPowd.txt");
                writer.write(String.format("Email %s ",strEmailM));
                writer.write(String.format(" password : %s  \n  ",pwdM));
                writer.write(String.format("Email %s ",strEmailC));
                writer.write(String.format(" password : %s  \n  ",pwdC));
                writer.close(); 
        } catch (IOException e) {
            System.out.println("Ficheiro não criado "+ e.getMessage());
        }

    }

 
    
    
    
}
