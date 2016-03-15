/**
 * Count number of words of each length 1-30
 * @DinhHuuNguyen
 * @01/02/2016
 */
import edu.duke.*;
public class WordLengths {
    
    public int[] countWordLengths(FileResource fr) {
        int[] counts = new int[31];        
        for(String s : fr.words()) {
            int l = 0;
            for(int i = 0; i < s.length(); i++){
                if(Character.isLetter(s.charAt(i)) || s.charAt(i) == '-') {
                    l += 1;
                }
            }
            if(l > 0 && l < 31) {
                counts[l] += 1;
            }
            if(l > 30) {
                counts[30] += 1;
            }
        }
        return counts;
    }
    
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = countWordLengths(fr);
        Helpers hp = new Helpers();
        int index = hp.indexOfMaxValue(counts);
        for(int i = 0; i < 31; i++) {
            if(counts[i] > 0) {
                System.out.println("length " + i + "\t" + counts[i] + " words");
            }
        }
        System.out.println("most popular length " + index);
    }
    
}