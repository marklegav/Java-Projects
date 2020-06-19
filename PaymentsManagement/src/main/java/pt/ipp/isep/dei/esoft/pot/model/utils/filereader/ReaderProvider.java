/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model.utils.filereader;

/**
 *
 * @author Marcel
 */
public class ReaderProvider {
    
    public static StrategyRead getType(ReadType name) {
        switch (name){
            case CSV:
                return new CSVReaderStrategy();
            case TXT:
                return new TXTReaderStrategy();
            default:
                return null;
        }
    }
}
