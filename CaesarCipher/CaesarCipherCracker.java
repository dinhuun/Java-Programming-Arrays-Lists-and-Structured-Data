/**
 * Break Caesar Cipher with frequency analysis and with brute force
 * @DinhHuuNguyen
 * @12/29/2015
 */
import edu.duke.*;

public class CaesarCipherCracker {
    
    public int[] countLetters(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
            char ch = Character.toLowerCase(s.charAt(i));
            int index = alphabet.indexOf(ch);
            counts[index] += 1;
            }
        }
        return counts;
    }
    
    public int indexOfMaxValue(int[] counts) {
        int index = 0;
        for(int i = 0; i < counts.length; i++){
            if (counts[i] > counts[index]) {
                index = i;
            }
        }
        return index;
    }
    
    public int getKey(String s) {
    int[] freqs = countLetters(s);
    Helpers hp = new Helpers();
    int index = hp.indexOfMaxValue(freqs);
    int key = 0;
    if (index < 4) {
        key = 26 + index - 4;
    }
    else {
        key = index - 4;
    }
    return key;
    }
    
    public void crack () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        //get key from getKey;
        int key = getKey(encrypted);
        System.out.println("key " + key);
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
    }
    
}