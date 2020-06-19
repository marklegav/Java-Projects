/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.utils;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.management.Query.lt;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.RegisterOrganisation;
import pt.ipp.isep.dei.esoft.pot.model.RegisterTransaction;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;

/**
 *
 * @author Matheus Aguiar
 */
public class Filter {

    private Freelancer freel;

    private RegisterTransaction rTrans = new RegisterTransaction();
    private Statistics sttscs = new Statistics();
    private   RegisterOrganisation og;
            List<Transaction> lstTrans = new ArrayList();

    ObservableList<String> xTicks = FXCollections.observableArrayList();
    ObservableList<Integer> values = FXCollections.observableArrayList();

    double mean; 
    double variance;
    double svariation;

    public Filter(String arg) {

        this.rTrans = AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction();
       
        this.lstTrans = rTrans.getPaymentOrders();
        
       
        
        switch (arg) {
            case "PlatformP":
                List<Double> totalValues = new ArrayList();
                totalValues = getPaymentValuesFromTransactions(lstTrans);

                sttscs.meanCalculator(totalValues);
                
                sttscs.varianceCalculator(sttscs.getMean(), totalValues);
                sttscs.standardDeviationCalculator(sttscs.getVariance());
                

                setMean(sttscs.getMean());
                setVariance(sttscs.getVariance());
                setSvariation(sttscs.getsDeviation());


                String intervalFirst = String.valueOf(sttscs.firstintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));
                String intervalSecond = String.valueOf(sttscs.secondintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));

                this.xTicks.add(String.valueOf("]-∞ ; " + intervalFirst + "]"));
                this.xTicks.add(String.valueOf("]" + intervalFirst + " ; " + intervalSecond + "]"));
                this.xTicks.add(String.valueOf("]" + intervalSecond + " ; +∞["));

                int firstinterval = 0;
                int secndinterval = 0;
                int tirdinterval = 0;

                for (Double tv : totalValues) {
                    if (tv <= sttscs.getFirstinterval()) {
                        firstinterval++;
                    } else {
                        if (tv > sttscs.getFirstinterval() && tv <= sttscs.getSecndinterval()) {

                            secndinterval++;
                        } else {
                            tirdinterval++;
                        }
                    }
                }
               
                values.add(firstinterval);
                values.add(secndinterval);
                values.add(tirdinterval);

                break;
            case "PlatformD":

                List<Double> totalValuesD = new ArrayList();
                totalValuesD = getDelaysFromTransactions(lstTrans);

                sttscs.meanCalculator(totalValuesD);
                sttscs.varianceCalculator(sttscs.getMean(), totalValuesD);
                sttscs.standardDeviationCalculator(sttscs.getVariance());
                
                setMean(sttscs.getMean());
                setVariance(sttscs.getVariance());
                setSvariation(sttscs.getsDeviation());
              
                String intervalFirstD = String.valueOf(sttscs.firstintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));
                String intervalSecondD = String.valueOf(sttscs.secondintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));

                this.xTicks.add(String.valueOf("]-∞ ; " + intervalFirstD + "]"));
                this.xTicks.add(String.valueOf("]" + intervalFirstD + " ; " + intervalSecondD + "]"));
                this.xTicks.add(String.valueOf("]" + intervalSecondD + " ; +∞["));

                int firstintervalD = 0;
                int secndintervalD = 0;
                int tirdintervalD = 0;

                for (Double tv : totalValuesD) {
                    if (tv <= sttscs.getFirstinterval()) {
                        firstintervalD++;
                    } else {
                        if (tv > sttscs.getFirstinterval() && tv <= sttscs.getSecndinterval()) {

                            secndintervalD++;
                        } else {
                            tirdintervalD++;
                        }
                    }
                }
                
                values.add(firstintervalD);
                values.add(secndintervalD);
                values.add(tirdintervalD);

                break;

        }
    }

    public Filter(Freelancer freel, String arg) {

        this.rTrans = AplicacaoPOT.getInstance().getPlataforma().getRegisterTransaction();
        this.lstTrans = rTrans.getPaymentOrders();

        switch (arg) {
            case ("FreelancerDelay"):

                this.lstTrans = getTransactionFromFreelancer(freel, lstTrans);
                
                List<Double> totalValues = new ArrayList();
                totalValues = getDelaysFromTransactions(lstTrans);
                   
                
                sttscs.meanCalculator(totalValues);
                sttscs.varianceCalculator(sttscs.getMean(), totalValues);
                sttscs.standardDeviationCalculator(sttscs.getVariance());

                
                setMean(sttscs.getMean());
                setVariance(sttscs.getVariance());
                setSvariation(sttscs.getsDeviation());
                
                String intervalFirst = String.valueOf(sttscs.firstintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));
                String intervalSecond = String.valueOf(sttscs.secondintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));

                this.xTicks.add(String.valueOf("]-∞ ; " + intervalFirst + "]"));
                this.xTicks.add(String.valueOf("]" + intervalFirst + " ; " + intervalSecond + "]"));
                this.xTicks.add(String.valueOf("]" + intervalSecond + " ; +∞["));

                int firstinterval = 0;
                int secndinterval = 0;
                int tirdinterval = 0;

                for (Double tv : totalValues) {
                    if (tv <= sttscs.getFirstinterval()) {
                        firstinterval++;
                    } else {
                        if (tv > sttscs.getFirstinterval() && tv <= sttscs.getSecndinterval()) {

                            secndinterval++;
                        } else {
                            tirdinterval++;
                        }
                    }
                }
                values.add(firstinterval);
                values.add(secndinterval);
                values.add(tirdinterval);

                break;
            case ("FreelancerPayment"):

                this.lstTrans = getTransactionFromFreelancer(freel, lstTrans);
                
                List<Double> totalValuesP = new ArrayList();
                totalValuesP = getPaymentValuesFromTransactions(lstTrans);
                   
                
                sttscs.meanCalculator(totalValuesP);
                sttscs.varianceCalculator(sttscs.getMean(), totalValuesP);
                sttscs.standardDeviationCalculator(sttscs.getVariance());

                
                setMean(sttscs.getMean());
                setVariance(sttscs.getVariance());
                setSvariation(sttscs.getsDeviation());
              
                String intervalFirstP = String.valueOf(sttscs.firstintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));
                String intervalSecondP = String.valueOf(sttscs.secondintervalHistogram(sttscs.getMean(), sttscs.getsDeviation()));

                this.xTicks.add(String.valueOf("]-∞ ; " + intervalFirstP + "]"));
                this.xTicks.add(String.valueOf("]" + intervalFirstP + " ; " + intervalSecondP + "]"));
                this.xTicks.add(String.valueOf("]" + intervalSecondP + " ; +∞["));

                int firstintervalP = 0;
                int secndintervalP = 0;
                int tirdintervalP = 0;

                for (Double tv : totalValuesP) {
                    if (tv <= sttscs.getFirstinterval()) {
                        firstintervalP++;
                    } else {
                        if (tv > sttscs.getFirstinterval() && tv <= sttscs.getSecndinterval()) {

                            secndintervalP++;
                        } else {
                            tirdintervalP++;
                        }
                    }
                }
                values.add(firstintervalP);
                values.add(secndintervalP);
                values.add(tirdintervalP);

         
                break;
        }

    }

    public List<Transaction> getTransactionFromFreelancer(Freelancer freela, List<Transaction> listTrans) {
        List<Transaction> freelTrans = new ArrayList();;

        for (Transaction lt : listTrans) {

            if (freela.equals(lt.getFreelancer())) {

                freelTrans.add(lt);
            }

        }

        
        return freelTrans;
    }

    public List<Double> getPaymentValuesFromTransactions(List<Transaction> listTrans) {
        List<Double> total = new ArrayList();

        for (Transaction tran : listTrans) {

            total.add(tran.calculateAmountPay());
        }

        return total;
    }

    public List<Double> getDelaysFromTransactions(List<Transaction> listTrans) {
        List<Double> total = new ArrayList();

        for (Transaction tran : listTrans) {

            total.add(tran.getDelay());
        }

        return total;
    }

    public Statistics getStatisticObject() {

        return this.sttscs;
    }

    public ObservableList<String> getxTicks() {
        return xTicks;
    }

    public void setxTicks(ObservableList<String> xTicks) {
        this.xTicks = xTicks;
    }

    public ObservableList<Integer> getValues() {
        return values;
    }

    public void setValues(ObservableList<Integer> values) {
        this.values = values;
    }

    public Freelancer getFreel() {
        return freel;
    }

    public void setFreel(Freelancer freel) {
        this.freel = freel;
    }
    
    
    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public double getSvariation() {
        return svariation;
    }

    private void setSvariation(double svariation) {
        this.svariation = svariation;
    }

   public int getNumberOfTasks(){
       int total = 0;
       total= this.lstTrans.size();
       
       return total;
   }
 
}
