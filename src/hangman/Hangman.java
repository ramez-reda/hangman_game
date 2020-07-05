/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ramez
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String csvFile = "C:\\Users\\Ramez\\Downloads\\Video\\baby-names_mod.csv";
        String line = "";
       ;
 LinkedList<String> names = new LinkedList<String> ();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                
               names.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
      int random_int = (int)(Math.random() * (names.size() - 0 + 1) + 0);
    
        String secret_name = names.get(random_int);
        //System.out.println("Secret Name is : " +secret_name);
        System.out.println("Welcome , The game chosed a secret name , guess it's characters ");
        char [] sec_name = secret_name.toCharArray();
        
        LinkedList<char_verify> chars = new LinkedList<char_verify>();
        for (int k=0 ; k <sec_name.length ; k++){
        char_verify ch = new char_verify(sec_name[k], false);
        chars.add(ch);
        }
        
        
        Boolean Success = false ;
        int tries = 1 ;
        Scanner input = new Scanner (System.in);
        
        Boolean wrong = true ;
        while (tries < 6){
            wrong = true ;
            System.out.println("enter a character");
            String str =input.next(); 
            char chr = str.toLowerCase().charAt(0);
            char chr2 = str.toUpperCase().charAt(0);
        for (int t =0 ; t<chars.size();t++)
        {
            if (chars.get(t).character == chr || chars.get(t).character == chr2 ){
                chars.get(t).chosen = true ;
                System.out.println("RIGHT");
                wrong = false ;
            }
        }
        if (wrong){ 
        tries+=1 ;
            System.out.println("Not exists");
        
        }
        
        
        if (check (chars))
        {
            Success = true ;
            System.out.println("Congrats , you won");
            break ;
        }
       
        }
        if (!Success)
        System.out.println("You Lose , try agian");
        
        
        System.out.println("The name was : " + secret_name);
    }
    
    
    
    public static Boolean check (LinkedList<char_verify> list){
    for (int t =0 ; t<list.size();t++)
        {
              if ( list.get(t).chosen == false) 
              return false ;
        }
    return true ;
    }
}
