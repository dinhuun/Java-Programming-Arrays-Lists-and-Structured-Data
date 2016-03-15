/**
 * find index of max value in an integer array
 * @DinhHuuNguyen
 * @01/04/2016
 */
public class Helpers {
    
    public int indexOfMaxValue(int[] counts) {
        int index = 0;
        for(int i = 0; i < counts.length; i++){
            if (counts[i] > counts[index]) {
                index = i;
            }
        }
        return index;
    }

}