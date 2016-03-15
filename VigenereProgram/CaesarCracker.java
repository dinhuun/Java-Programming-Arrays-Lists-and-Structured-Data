import edu.duke.*;

public class CaesarCracker {
    char mostCommon;
    
    public CaesarCracker() {
        mostCommon = 'e';
    }
    
    public CaesarCracker(char c) {
        mostCommon = c;
    }
    
    public int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alphabet.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] values){
        int max = 0;
        for(int k=0; k < values.length; k++){
            if (values[k] > values[max]){
                max = k;
            }
        }
        return max;
    }

    public int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int max = maxIndex(freqs);
        int mostCommonPos = mostCommon - 'a';
        int key = max - mostCommonPos;
        if (max < mostCommonPos) {
            key = max + 26 - mostCommonPos;
        }
        return key;
    }
    
    public String crack(String encrypted){
        int key = getKey(encrypted);
        System.out.println("key " + key);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
        
    }
   
}
