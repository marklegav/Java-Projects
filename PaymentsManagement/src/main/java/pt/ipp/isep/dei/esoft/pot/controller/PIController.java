/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.utils.Filter1;

/**
 *
 * @author Matheus Aguiar
 */
public class PIController {
    
    ObservableList<String> xTicks = FXCollections.observableArrayList();
    ObservableList<Integer> values = FXCollections.observableArrayList();
    
    double mean; 
    double variance;
    double svariation;
    
     public PIController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_GESTOR_ORGANIZACAO)){
                    throw new IllegalStateException("Unauthorized User.");

            }
        }

       
    }
     
     public XYChart.Series<String, Integer> showPlatformPayments(String strngFilter){
         
          Filter1 filter = new Filter1(strngFilter);

            xTicks = filter.getxTicks();
            values = filter.getValues();
            
            setMean(filter.getMean());
            setVariance(filter.getVariance());
            setSvariation(filter.getSvariation());
            

            XYChart.Series<String, Integer> series = new XYChart.Series();

            series.setName("Payments to all freelancers");
            series.getData().add(new XYChart.Data<>(xTicks.get(0), values.get(0)));
            series.getData().add(new XYChart.Data<>(xTicks.get(1), values.get(1)));
            series.getData().add(new XYChart.Data<>(xTicks.get(2), values.get(2)));
        
         return series;
         
     }
     public XYChart.Series<String, Integer> showPlatformDelays(String strngFilter){
         
          Filter1 filter1 = new Filter1(strngFilter);

            xTicks = filter1.getxTicks();
            values = filter1.getValues();

            setMean(filter1.getMean());
            setVariance(filter1.getVariance());
            setSvariation(filter1.getSvariation());
            
            XYChart.Series<String, Integer> series = new XYChart.Series();

            series.setName("Delays from all freelancers");
            series.getData().add(new XYChart.Data(xTicks.get(0), values.get(0)));
            series.getData().add(new XYChart.Data(xTicks.get(1), values.get(1)));
            series.getData().add(new XYChart.Data(xTicks.get(2), values.get(2)));

        
         
         return series;
         
     }
      public XYChart.Series<String, Integer> showFreelancerDelays(Freelancer freel, String D){
         
          Filter1 filter1 = new Filter1(freel, D);

            xTicks = filter1.getxTicks();
            values = filter1.getValues();
            
           
            setMean(filter1.getMean());
            setVariance(filter1.getVariance());
            setSvariation(filter1.getSvariation());
            
            
            XYChart.Series<String, Integer> series = new XYChart.Series<>();

            series.setName("Delays from the freelancer "+freel.getName());
            series.getData().add(new XYChart.Data<>(xTicks.get(0), values.get(0)));
            series.getData().add(new XYChart.Data<>(xTicks.get(1), values.get(1)));
            series.getData().add(new XYChart.Data<>(xTicks.get(2), values.get(2)));

        
         
         return series;
         
     }
       public XYChart.Series<String, Integer> showFreelancerPayment(Freelancer freel, String P){
         
          Filter1 filter = new Filter1(freel, P);

            xTicks = filter.getxTicks();
            values = filter.getValues();

            setMean(filter.getMean());
            setVariance(filter.getVariance());
            setSvariation(filter.getSvariation());
            
            XYChart.Series<String, Integer> series = new XYChart.Series<>();

            series.setName("Payments from the freelancer "+freel.getName());
            series.getData().add(new XYChart.Data<>(xTicks.get(0), values.get(0)));
            series.getData().add(new XYChart.Data<>(xTicks.get(1), values.get(1)));
            series.getData().add(new XYChart.Data<>(xTicks.get(2), values.get(2)));
         
         return series;
         
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

   
}
