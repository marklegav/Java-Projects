/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.utils.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marcel
 */
public interface  StrategyRead {
    
    /**
     * This interface is a prototype what all strategies class must implement.
     */
    
    /**
     * Determine
     * @param fileName
     * @return
     * @throws FileNotFoundException 
     */
    
    public List<String[]> setListFromFile(File fileName) throws FileNotFoundException;
    

    
    
}
