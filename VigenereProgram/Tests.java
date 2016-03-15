
/**
 * Write a description of testCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.*;

public class Tests {
    
    public void testCaesarCipher(int key) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testCaesarCracker() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        CaesarCracker cc = new CaesarCracker();
        String message = cc.crack(encrypted);
        System.out.println(message);
    }
    
    public void testVigenereCipher(int[] key) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        VigenereCipher vcp = new VigenereCipher(key);
        String encrypted = vcp.encrypt(message);
        System.out.println(encrypted);
        String decrypted = vcp.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testcrackForLanguage(char mostCommon) {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        VigenereCracker vck = new VigenereCracker();
        FileResource frdict = new FileResource();
        HashSet<String> dictionary = vck.readDictionary(frdict);
        String message = vck.crackForLanguage(encrypted, dictionary, mostCommon);
        System.out.println(message);
        //int[] key = tryKeyLength(encrypted, keylength, mostCommon);
        //VigenereCipher vc = new VigenereCipher(key);
        //String decrypted = vc.decrypt(encrypted);
        //System.out.println(decrypted);
    }
    
    public void testcrackForLanguages() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        VigenereCracker vck = new VigenereCracker();
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename = f.getName();
            FileResource frdict = new FileResource(f);
            languages.put(filename, vck.readDictionary(frdict));
        }
        String message = vck.crackForLanguages(encrypted, languages);
        System.out.println(message);
    }

}
