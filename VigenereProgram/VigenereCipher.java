import edu.duke.*;
import java.util.*;

public class VigenereCipher {
    CaesarCipher[] ciphers;
    
    public VigenereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int column = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[column];
            encrypted.append(thisCipher.encryptLetter(c));
            i++;
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int column = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[column];
            decrypted.append(thisCipher.decryptLetter(c));
            i++;
        }
        return decrypted.toString();
    }
    
    public String toString() {
        return Arrays.toString(ciphers);
    }
    
}
