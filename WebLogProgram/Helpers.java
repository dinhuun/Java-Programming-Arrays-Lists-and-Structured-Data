/**
 * some helpers for WebLogProgram
 * @DinhHuuNguyen 
 * @01/13/2016
 */

import edu.duke.*;
import java.io.*;
import java.util.*;

public class Helpers {
    
    public int maxValue (HashMap<String, Integer> map) {
       int max = 0;
       for (String s : map.keySet()) {
           if (max < map.get(s)) {
               max = map.get(s);
           }
       }
       return max;
    }
    
    public ArrayList<String> inverseImage (HashMap<String, Integer> map, int value) {
       ArrayList<String> list = new ArrayList<String>();
       for (String s : map.keySet()) {
           if (map.get(s) == value) {
               list.add(s);
           }
       }
       return list;
    }
    
    public HashMap<String, Integer> countMultiplicities (ArrayList<String> list) {
        HashMap<String, Integer> itemsandmultiplicities = new HashMap<String, Integer>();
        for (String s : list) {
            if (! itemsandmultiplicities.containsKey(s)) {
                itemsandmultiplicities.put(s, 1);
            }
            else {
                itemsandmultiplicities.put(s, itemsandmultiplicities.get(s) + 1);
            }
        }
        return itemsandmultiplicities;
    }

}
