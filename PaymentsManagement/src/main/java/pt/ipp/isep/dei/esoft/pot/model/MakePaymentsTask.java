/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.utils.PrintReport;

/**
 *
 * @author Marcel
 */
public class MakePaymentsTask extends TimerTask {
    
    private MakePayments make = new MakePayments();
    
    MakePaymentsTask() {
    }

    @Override
    public void run() {
        Date today = Calendar.getInstance().getTime();
        List<Organization> lstOrg = this.make.checkPaymentDates(today.getDay());
        List<Transaction> lstTrans = this.make.getTransactions(lstOrg);
        String report = this.make.makePayment(lstTrans);
        try {
            PrintReport.print(report, "payments.txt");
        } catch (IOException ex) {
            Logger.getLogger(MakePaymentsTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
