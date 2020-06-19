/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.utils;
import java.io.File;
  import java.io.IOException;
  import java.util.ArrayList;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
import java.util.List;
    
public class Empacotamento {
    //Inspirado em: https://www.devmedia.com.br/serializacao-de-objetos-em-java/23413
    /**
     * Serialize a list of object 
     * @param lista
     * @param nomeArq 
     */
    public static void gravarArquivoBinario(List<Object> lista, String nomeArq) {

        File arq = new File("src/main/resources/bin/"+nomeArq);
        try {
            arq.delete();
            arq.createNewFile();
    
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();
            System.out.println("Saved: "+nomeArq);
        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
    
    /**
     * Deserialize a bin file to a list of object
     * @param nomeArq
     * @return 
    */
    public static List<Object> lerArquivoBinario(String nomeArq) {
        System.out.println("Loading:"+nomeArq+"...");
        List<Object> lista = new ArrayList();
        try {
            File arq = new File("src/main/resources/bin/"+nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>)objInput.readObject();
                System.out.println(lista.getClass());
                objInput.close();
            }
        } catch(IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        System.out.println("Conclued:"+ nomeArq+"...");
        return(lista);
    }    
  }