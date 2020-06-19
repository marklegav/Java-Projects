/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.utils;

import java.security.SecureRandom;

/**
 * Gthis class will generate the password automatically
 * @author arccenio
 */
public class GeneretePassword {
    private  SecureRandom random=new SecureRandom();
    private  final String   a="abcdefghijkmnpklmopqrtuwzy";
    private  final String   m="0123456789";
    
 public   String gerarPwd(int le ,String d){
     String result ="";
     for(int i=0;i<le;i++){
         int index=random.nextInt(d.length());
         result+=d.charAt(index);


     }
     return result;

    }
 public  String pwd(){
          int n=7;
     String pwd=gerarPwd(n ,a+m);
     return  pwd;
 }
 
    
    
}
