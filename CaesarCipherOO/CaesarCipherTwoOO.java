/**
 * Caesar Cipher Two Object Oriented encryption and decryption with two keys
 * @DinhHuuNguyen 
 * @01/05/2016
 */
import edu.duke.*;

public class CaesarCipherTwoOO {
    
    private String upperalphabet;
    private String loweralphabet;
    private String upperalphabet0;
    private String loweralphabet0;
    private String upperalphabet1;
    private String loweralphabet1;
    private int mainkey0;
    private int mainkey1;
    
    public CaesarCipherTwoOO(int key0, int key1){
        upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        loweralphabet = "abcdefghijklmnopqrstuvwxyz";
        upperalphabet0 = upperalphabet.substring(key0) + upperalphabet.substring(0,key0);  
        upperalphabet1 = upperalphabet.substring(key1) + upperalphabet.substring(0,key1);       
        loweralphabet0 = loweralphabet.substring(key0) + loweralphabet.substring(0,key0);
        loweralphabet1 = loweralphabet.substring(key1) + loweralphabet.substring(0,key1);
        mainkey0 = key0;
        mainkey1 = key1;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int indexinupper = upperalphabet.indexOf(currChar);
            int indexinlower = loweralphabet.indexOf(currChar);
            if(i % 2 == 0 && indexinupper != -1){
                char newChar = upperalphabet0.charAt(indexinupper);
                encrypted.setCharAt(i, newChar);
            }
            if(i % 2 == 1 && indexinupper != -1){
                char newChar = upperalphabet1.charAt(indexinupper);
                encrypted.setCharAt(i, newChar);
            }
            if(i % 2 == 0 && indexinlower != -1){
                char newChar = loweralphabet0.charAt(indexinlower);
                encrypted.setCharAt(i, newChar);
            }
            if(i % 2 == 1 && indexinlower != -1){
                char newChar = loweralphabet1.charAt(indexinlower);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise do nothing
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherTwoOO cct = new CaesarCipherTwoOO(26 - mainkey0, 26 - mainkey1);
        return cct.encrypt(input);
    }
}