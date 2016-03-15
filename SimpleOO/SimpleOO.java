/**
 * repeat a word
 * @DinhHuuNguyen 
 * @01/05/2016
 */

public class SimpleOO{
    
     private String word; 
     private String phrase;
     private int number;
     
     public SimpleOO(int n, String w) { 	
          word = w; 	
          phrase = mystery(n, w);
          number = n;
     }   
     
     private String mystery(int num, String string) {  	
          String answer = "";  	
          for (int k = 0; k < num; k++) {     	
               answer = answer + string;  	
          }  	
          return answer; 
     } 
     
     public String toString() { 	
          return phrase + " is " + word + " repeated " + number + " times";
     }
}