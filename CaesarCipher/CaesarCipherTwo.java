/**
 * Caesar Cipher encryption and decryption with two keys
 * @DinhHuuNguyen 
 * @12/31/2015
 */
import edu.duke.*;
public class CaesarCipherTwo {
    
    public String encrypt(String input, int key0, int key1) {
        StringBuilder encrypted = new StringBuilder(input);
        String upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String loweralphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperalphabet0 = upperalphabet.substring(key0) +
        upperalphabet.substring(0,key0);
        String upperalphabet1 = upperalphabet.substring(key1) +
        upperalphabet.substring(0,key1);
        String loweralphabet0 = loweralphabet.substring(key0) +
        loweralphabet.substring(0,key0);
        String loweralphabet1 = loweralphabet.substring(key1) +
        loweralphabet.substring(0,key1);
        //Count from 0 to < length of encrypted, (call it i)
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
    
    public void testCaesarCipherTwo(int key0, int key1) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key0, key1);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26 - key0, 26 - key1);
        System.out.println(decrypted);
    }
    
}
