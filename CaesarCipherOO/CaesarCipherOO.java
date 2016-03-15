/**
 * Caesar Cipher Object Oriented encryption and decryption with one key
 * @DinhHuuNguyen
 * @01/05/2016
 */
import edu.duke.*;

public class CaesarCipherOO {
    
    private String loweralphabet;
    private String upperalphabet;
    private String loweralphabet0;
    private String upperalphabet0;
    private int mainkey;
    
    public CaesarCipherOO(int key){
       upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       loweralphabet = "abcdefghijklmnopqrstuvwxyz";
       upperalphabet0 = upperalphabet.substring(key) + upperalphabet.substring(0,key);
       loweralphabet0 = loweralphabet.substring(key) + loweralphabet.substring(0,key);
       mainkey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int indexinupper = upperalphabet.indexOf(currChar);
            int indexinlower = loweralphabet.indexOf(currChar);
            if(indexinupper != -1){
                char newChar = upperalphabet0.charAt(indexinupper);
                encrypted.setCharAt(i, newChar);
            }
            if(indexinlower != -1){
                char newChar = loweralphabet0.charAt(indexinlower);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise do nothing
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherOO cc = new CaesarCipherOO(26 - mainkey);
        return cc.encrypt(input);
    }
    
}
