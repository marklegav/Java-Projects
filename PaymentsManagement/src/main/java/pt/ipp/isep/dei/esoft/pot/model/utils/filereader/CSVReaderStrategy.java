/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.utils.filereader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
public class CSVReaderStrategy implements StrategyRead {
    

    public List<String[]> setListFromFile(File fileName) {
        List<String[]> lstFile = new ArrayList();
        try {
            Scanner in = new Scanner(fileName);
            String[] itens;
            lstFile = new ArrayList();
            in.nextLine(); //skip first line
            while(in.hasNextLine()){
                String line = in.nextLine();
                itens = line.split(";");
                lstFile.add(itens);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReaderStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstFile;
    }
}
