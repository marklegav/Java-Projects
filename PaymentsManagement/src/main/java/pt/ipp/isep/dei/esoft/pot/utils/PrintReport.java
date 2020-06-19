/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Marcel
 */
public class PrintReport {
    
    
    /**
     * Recive the structured report to be export in a file, and the file name.
     * 
     * File name should have the complete diretory, for the export users report, or just 
     * the file name and extension, in case of systens files.
     * 
     * This method always create a new file in directory indicated.
     * 
     * 
     * @param report
     * @param fileName
     * @throws IOException 
     */
    public static void print(String report, String fileName ) throws IOException{
        File reportFile = new File(fileName);
        reportFile.createNewFile();
        FileWriter fw = new FileWriter(fileName);
        fw.write(report);
        fw.close();
        System.out.println("Runtime Report created in: "+fileName);
    }
    
}
