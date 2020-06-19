package pt.ipp.isep.dei.esoft.autorizacao.model.password;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.security.SecureRandom;

/**
 * Gthis class will generate the password automatically
 * @author arccenio
 */
public class GeneretePassword implements PasswordAlgorithm{
    private  SecureRandom random=new SecureRandom();
    private  final String   a="abcdefghijkmnpklmopqrtuwzy";
    private  final String   m="0123456789";
    private final String e="!@#$*";

    @Override
 public String generatePassword(int qtChar, String rangeChar){
     String result ="";
    for(int i=0;i<qtChar;i++){
        int index=random.nextInt(rangeChar.length());
        result+=rangeChar.charAt(index);
     }
     return result;
}
 
    @Override
 public  String pwd(){
          int n=7;
     String pwd=generatePassword(n ,a+m+e);
     return  pwd;
 }
 
    
    
}
