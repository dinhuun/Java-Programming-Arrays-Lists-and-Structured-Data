/**
 * crack Caesar Cipher Object Oriented
 * @DinhHuuNguyen 
 * @01/05/2016
 */

public class CaesarCipherOOCracker {
    
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
    
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        Helpers hp = new Helpers();
        int max = hp.indexOfMaxValue(freqs);
        int key = 0;
        if (max < 4) {
            key = 26 + max - 4;
        }
        else {
            key = max - 4;
        }
        return key;
    }
    
    public String crack(String encrypted) {
        int key = getKey(encrypted);
        System.out.println("key " + key);
        CaesarCipherOO ccOO = new CaesarCipherOO(key);
        return ccOO.decrypt(encrypted);
    }

}
