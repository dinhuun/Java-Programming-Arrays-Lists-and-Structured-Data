/**
 * Caesar Cipher encryption and decryption with one key
 * @DinhHuuNguyen
 * @12/29/2015
 */
import edu.duke.*;
public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String loweralphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperalphabet0 = upperalphabet.substring(key) + upperalphabet.substring(0,key);
        String loweralphabet0 = loweralphabet.substring(key) + loweralphabet.substring(0,key);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int indexinupper = upperalphabet.indexOf(currChar);
            int indexinlower = loweralphabet.indexOf(currChar);
            if(indexinupper != -1) {
                char newChar = upperalphabet0.charAt(indexinupper);
                encrypted.setCharAt(i, newChar);
            }
            if(indexinlower != -1) {
                char newChar = loweralphabet0.charAt(indexinlower);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise do nothing
        }
        return encrypted.toString();
    }
    
    public void testCaesarCipher(int key) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
        //bruteforce
        //for (int i = 1; i < 27; i++){
            //String tries = encrypt(encrypted, 26 - i);
            //System.out.println("key " + i);
            //System.out.println(tries);
        //}
    }
    
}