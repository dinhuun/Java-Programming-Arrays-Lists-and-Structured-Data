/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;
import java.util.*;
import java.io.*;
public class WordFrequencies {
    private ArrayList<String> Words;
    private ArrayList<Integer> Freqs;
    
    public WordFrequencies() {
        Words = new ArrayList<String>();
        Freqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        Words.clear();
        Freqs.clear();
        FileResource fr = new FileResource();
        for(String word : fr.words()){
            word = word.toLowerCase();
            int index = Words.indexOf(word);
            if (index == -1){
                Words.add(word);
                Freqs.add(1);
            }
            else {
                int freq = Freqs.get(index);
                Freqs.set(index,freq+1);
            }
        }
    }
    
    public int findMax(ArrayList<Integer> list){
        int max = list.get(0);
        int maxIndex = 0;
        for(int k=0; k < list.size(); k++){
            if (list.get(k) > max){
                max = list.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void testWordFrequencies(){
        findUnique();
        for (int i = 0; i < Words.size(); i++) {
            System.out.println(Freqs.get(i) + "\t" + Words.get(i));
        }
        System.out.println("number of unique words: " + Words.size());
        int maxIndex = findMax(Freqs);
        System.out.println("most frequent word: " + Words.get(maxIndex) + "\t" + Freqs.get(maxIndex) + " times");
    }
}
