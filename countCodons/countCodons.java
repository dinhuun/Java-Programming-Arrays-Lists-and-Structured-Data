/**
 * for each reading frame of a DNA strand
 * find and store all codons in a HashMap
 * print the number of codons
 * print the codons that appear between x and y times
 * print the most common codon
 * @DinhHuuNguyen
 * @01/09/2016
 */
import edu.duke.*;
import java.util.*;

public class countCodons {
    private HashMap<String,Integer> map;
    
    public countCodons() {
        map = new HashMap<String,Integer>();        
    }
    
    public void buildCodonMap(int start, String string) {
        map.clear();
        for (int i = 0; i < (string.length() - start)/3; i++) {
            String codon = string.substring(start + 3*i, start + 3*(i + 1));
            if (! map.containsKey(codon)) {
                map.put(codon, 1);
            }
            else {
                map.put(codon,  map.get(codon) + 1);
            }
        }
    }
    
    public String getMostCommonCodon() {
        int max = 0;
        String mostcommoncodon = new String();
        for (String codon : map.keySet()) {
            if (map.get(codon) > max) {
                mostcommoncodon = codon;
                max = map.get(codon);
            }
        }
        return mostcommoncodon;
       }
       
    public void printcommonCodons (int low, int high) {
        System.out.println("codons that appear between " + low + "-" + high + " times");
        for (String key : map.keySet()) {
            if (low <= map.get(key) && map.get(key) <= high) {
                System.out.println(key + "\t" + map.get(key));
            }
        }
    }
    
    public void testcountCodons(){
        FileResource file = new FileResource();
        String dna = file.asString();
        //String dna = "CGTTCAAGTTCAA";
        String trimmed = dna.trim();
        String string = trimmed.toLowerCase();
        int low = 1;
        int high = 7;
            for (int i = 0; i < 3; i++) {
            buildCodonMap(i, string);
            System.out.println("in frame " + i + "\t" + map.size() + " codons");
            printcommonCodons(low, high);
            System.out.println("most common codon is " + getMostCommonCodon() + ", " + map.get(getMostCommonCodon()) + " times");
        }
    }
    
}
