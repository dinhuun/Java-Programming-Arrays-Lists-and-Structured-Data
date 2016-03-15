/**
 * Break Caesar Cipher Two with frequency analysis
 * @DinhHuuNguyen
 * @01/03/2016
 */
import edu.duke.*;
public class CaesarCipherTwoCracker {
    
    public String halfOfString(String message, int start){
        String half = new String();
        for (int k = start; k < message.length() ; k+= 2) {
            half = half + message.charAt(k);        
        }
        return half;
    }
    
    public void testCaesarCipherTwoBreaker () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        //divide fr into half1 and half2;
        String half0 = halfOfString(encrypted, 0);
        String half1 = halfOfString(encrypted, 1);
        //get key0 from half0, key1 from half1;
        CaesarCipherCracker ccc = new CaesarCipherCracker();
        int key0 = ccc.getKey(half0);
        int key1 = ccc.getKey(half1);
        System.out.println("key0, key1 " + "\t" + key0 + "," + key1);
        CaesarCipherTwo cc = new CaesarCipherTwo();
        String decrypted = cc.encrypt(encrypted, 26 - key0, 26 - key1);
        System.out.println(decrypted);
    }
    
}