package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.pot.model.LoadTransaction;
import pt.ipp.isep.dei.esoft.pot.model.RegisterLoadTransaction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Platform;

/**
 *
 * @author Marcel
 */
public class LoadTransactionController {
    
    
    private RegisterLoadTransaction rLoadTransaction;
    private LoadTransaction oLoadTransaction;
    private Platform oPlatform;
    private List<List<?>> lstLoaded = new ArrayList();
    private Organization org;
    
    
    public LoadTransactionController(){
        this.oPlatform = AplicacaoPOT.getInstance().getPlataforma();
        this.rLoadTransaction = this.oPlatform.getRegisterLoad();
    }
    
    /**
     * 
     * @param log
     * @param emailColab Collaborator's e-mail, how create this log transaction by file process
     * @param org valor �nico que permita idenficar a organiza��o
     * @param dtExec
     * @return 
    */
    public LoadTransaction newLoadTransaction() {
        String emailColab = AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador();
        this.org = oPlatform.getRegisterOrganisation().getCompanByLogin(emailColab);
        this.oLoadTransaction = rLoadTransaction.createLoadTransaction(emailColab, org.getOrgName(), new Date());
        return this.oLoadTransaction;
    }

    public boolean addFile(String ofileName) throws IOException, FileNotFoundException {
        File fileName = new File(ofileName);
        this.oLoadTransaction.loadTransaction(fileName, this.org.getNIF()); 
        return true;
    }

    public boolean createPaymentTransactionByFile() throws IOException, FileNotFoundException {
        this.oLoadTransaction.register(this.org.getNIF());
        return true;
    }
}