/**
 * test Caesar Cipher Object Oriented
 * @DinhHuuNguyen
 * @01/05/2016
 */

import edu.duke.*;

public class Tests {
    
    public void testCaesarCipherOO(int key) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherOO ccOO = new CaesarCipherOO(key);
        String encrypted = ccOO.encrypt(message);
        System.out.println(encrypted);
        String decrypted = ccOO.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testCaesarCipherOOCracker() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        CaesarCipherOOCracker ccOOb= new CaesarCipherOOCracker();
        String message = ccOOb.crack(encrypted);
        System.out.println(message);
    }
    
    public void testCaesarCipherTwoOO(int key0, int key1) {
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwoOO cctOO = new CaesarCipherTwoOO(key0, key1);
        String encrypted = cctOO.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cctOO.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testCaesarCipherTwoOOCracker() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        CaesarCipherTwoOOCracker ccOOb= new CaesarCipherTwoOOCracker();
        String message = ccOOb.crack(encrypted);
        System.out.println(message);
    }
    
}