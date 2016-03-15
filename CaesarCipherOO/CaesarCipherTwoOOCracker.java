
/**
 * Write a description of CaesarCipherTwoOObreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwoOOCracker {
    
    public String halfOfString(String message, int start){
        String half = "";
        for (int k = start; k < message.length() ; k+= 2) {
            half = half + message.charAt(k);        
        }
        return half;
    }
    
    public String crack(String input) {
        //divide fr into half1 and half2;
        String half0 = halfOfString(input, 0);
        String half1 = halfOfString(input, 1);
        //get key0 and key1 from getKey(half0) and getKey(half1);
        CaesarCipherOOCracker ccOOb = new CaesarCipherOOCracker();
        int key0 = ccOOb.getKey(half0);
        int key1 = ccOOb.getKey(half1);
        System.out.println("key0, key1" + "\t" + key0 + "," + key1);
        CaesarCipherTwoOO cctOO = new CaesarCipherTwoOO(key0, key1);
        return cctOO.decrypt(input);
    }

}
