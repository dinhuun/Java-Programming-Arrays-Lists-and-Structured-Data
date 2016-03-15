
/**
 * some helpers for Characters in Play program
 * find index of max of an Array List of integers
 * find index of max below given upperbound of an Array List of integers
 * @DinhHuuNguyen
 * @01/08/2016
 */

import edu.duke.*;
import java.util.*;

public class Helpers {
    
    public int indexOfMax(ArrayList<Integer> list) {
        int max = 0;
        int index = 0;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) > max){
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public int indexOfMaxBelow(ArrayList<Integer> list, int upperbound) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i) && list.get(i) < upperbound) {
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }

}
