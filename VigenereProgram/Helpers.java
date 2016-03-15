/**
 * some helpers for VigenereProgram
 * @DinhHuuNguyen 
 * @01/17/2016
 */

import edu.duke.*;
import java.io.*;
import java.util.*;

public class Helpers {
    
    public HashMap<String, Integer> sizeOfEachImage (HashMap<String, ArrayList<String>> map) {
        HashMap<String, Integer> maptoimagesize = new HashMap<String, Integer>();
        for (String s : map.keySet()) {
            maptoimagesize.put(s, map.get(s).size());
        }
        return maptoimagesize;
    }
    
    public int maxValue (HashMap<String, Integer> map) {
       int max = 0;
       for (String s : map.keySet()) {
           if (max < map.get(s)) {
               max = map.get(s);
           }
       }
       return max;
    }
    
    public String inverseImage (HashMap<String, Integer> map, int value) {
       String preimage = new String();
       for (String s : map.keySet()) {
           if (map.get(s) == value) {
               preimage = s;
           }
       }
       return preimage;
    }

}