package pt.ipp.isep.dei.esoft.pot.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Transaction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;
import org.apache.commons.math.MathException;
import static org.apache.commons.math.util.FastMath.sqrt;


/**
 *
 * @author Maheus Aguiar
 */
public class Statistics {

    /**
     * Mean variable
     */
    double mean;
    /**
     * Variance Variable
     */
    double variance;
    /**
     * standard variation variable
     */
    double sDeviation;
    /**
     * first instervall variable
     */
    double firstinterval;
    /**
     * second interval variable
     */
    double secndinterval;
    /**
     * formater double
     */
    NumberFormat formatter = new DecimalFormat("#0.00"); 

   

    public Statistics() {

    }
    /**
     * calculate overall percentage
     * @param transactions
     * @return 
     */
    public double calculateOverallPercentageOfDelays(List<Transaction> transactions) {
        if (transactions.size() > 0) {
            int sum = 0;
            for (Transaction transaction : transactions) {
                if (transaction.getDelay() > 0) {
                    sum++;
                }
            }
            return sum / transactions.size() * 100;
        } else {
            return 0;
        }
    }
    /**
     * calculate freelancer percentage od delays
     * @param freel
     * @param transactions
     * @return 
     */
    public double calculateFreelancerPercentageOfDelays(Freelancer freel, List<Transaction> transactions) {
        int sum = 0;
        int freelTransactions = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getFreelancer().equals(freel)) {
                freelTransactions++;
                if (transaction.getDelay() > 0) {
                    sum++;
                }
            }
        }
        if (freelTransactions == 0) {
            return 0;
        }
        return sum / freelTransactions * 100;
    }
    /**
     * calculate freelancer mean
     * @param freel
     * @param transactions
     * @return 
     */
    public double calculateFreelancerMeanTaskDelay(Freelancer freel, List<Transaction> transactions) {
        int sum = 0;
        int freelTransactions = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getFreelancer().equals(freel)) {
                freelTransactions++;
                sum += transaction.getDelay();
            }
        }
        if (freelTransactions == 0) {
            return 0;
        }
        return sum / freelTransactions;
    }
/**
 * mean calculator ints
 * @param values
 * @return 
 */
    public double meanCalculatorInt(List<Integer> values) {

        double total = 0;

        for (int i = 0; i < values.size(); i++) {
            total += values.get(i);
        }

        mean = total / values.size();

        this.mean = mean;

        return mean;
    }
/**
 * mean calculator double
 * @param values 
 */
    public void meanCalculator(List<Double> values) {

        double mean = 0;
        double total = 0;

            System.out.println("Values to calculate mean");
        for (int i = 0; i < values.size(); i++) {

            System.out.println("-");
            System.out.println(values.get(i));
            
            total += values.get(i);
        }

        mean = total / values.size();
      
        
        
        setMean(doubleformat(mean));
    }
/**
 * variance Calculator 
 * @param mean
 * @param values 
 */
    public void varianceCalculator(double mean, List<Double> values) {
        double var;
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += Math.pow((values.get(i) - mean), 2);
        }
        var = sum / (values.size() - 1);

        setVariance(doubleformat(var));
    }
/**
 * standard deviation calculator
 * @param variance 
 */
    public void standardDeviationCalculator(double variance) {
        double sd = Math.sqrt(variance);
        setsDeviation(doubleformat(sd));
    }
/**
 * first interval histogram
 * @param mean
 * @param sDeviation
 * @return 
 */
    public double firstintervalHistogram(double mean, double sDeviation) {
 setFirstinterval(doubleformat(mean - sDeviation));
        return getFirstinterval();
    }
/**
 * second interval histogram
 * @param mean
 * @param sDeviation
 * @return 
 */
    public double secondintervalHistogram(double mean, double sDeviation) {
        setSecndinterval(doubleformat(mean + sDeviation));
        return getSecndinterval();
    }
/**
 * probability calculator
 * @param mean
 * @param sDeviation
 * @param sample
 * @param hours
 * @return
 * @throws MathException 
 */
    public double probabilityCalculator(double mean, double sDeviation, int sample, int hours) throws MathException {
             double prob;
             NormalDistributionImpl probability;
             
             
        if (sample == 0) {
            prob = 0;
        } else {
            double sampleStdDev = sDeviation / (sqrt(sample));
            probability = new NormalDistributionImpl(mean, sampleStdDev);

          double y= (hours - mean)/sampleStdDev;

            prob = 1 - probability.cumulativeProbability(3);
        }
       
        return doubleformat4(prob*= 100);

    }
/**
 * get standad deviation
 * @return 
 */
    public double getsDeviation() {
        return sDeviation;
    }
/**
 * sets deviation
 * @param sDeviation 
 */
    public void setsDeviation(double sDeviation) {
        this.sDeviation = sDeviation;
    }
/**
 * 
 * @return 
 */
    public double getMean() {
        return mean;
    }
/**
 * 
 * @param mean 
 */
    public void setMean(double mean) {
        this.mean = mean;
    }
/**
 * 
 * @return 
 */
    public double getVariance() {
        return variance;
    }
/**
 * 
 * @param variance 
 */
    public void setVariance(double variance) {
        this.variance = variance;
    }
    /**
     * 
     * @return 
     */
    public double getFirstinterval() {
        return firstinterval;
    }
/**
 * 
 * @param firstinterval 
 */
    public void setFirstinterval(double firstinterval) {
        this.firstinterval = firstinterval;
    }
/**
 * 
 * @return 
 */
    public double getSecndinterval() {
        return secndinterval;
    }
/**
 * 
 * @param secndinterval 
 */
    public void setSecndinterval(double secndinterval) {
        this.secndinterval = secndinterval;
    }
    /**
     * 
     * @param input
     * @return 
     */
    public double doubleformat(double input){
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();
        
        return newInput;
    }
    /**
     * 
     * @param input
     * @return 
     */
    public double doubleformat4(double input){
        BigDecimal bd = new BigDecimal(input).setScale(4, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();
        
        return newInput;
    }

}
