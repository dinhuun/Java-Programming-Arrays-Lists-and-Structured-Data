/**
 * using Array versus uing ArrayList
 */
import java.util.*;
import edu.duke.*;

public class CountWordswithArrayversusArrayList {
    StorageResource myWords;
    
    public CountWordswithArrayversusArrayList() {
        myWords = new StorageResource();
    }
    
    public int getCount(){
        return myWords.size();
    }
    
    public String getRandomWordA(String[] words) {
		Random rand = new Random();
		int index = rand.nextInt(words.length);
		return words[index];
	}
	
    public String getRandomWordAL() {
		Random rand = new Random();
		int choice = rand.nextInt(myWords.size());
		for(String s : myWords.data()){
			if (choice == 0) {
				return s;
			}
			choice = choice - 1;
		}
		return "*** NEVER HAPPENS ***";
		}
		
	public void readWords(String source) {
        myWords.clear();
        if (source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                myWords.add(word.toLowerCase());
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                myWords.add(word.toLowerCase());
            }
        }
    }
    
    public boolean contains(String[] list, int size, String word) {
        for(int k = 0; k < size; k++){
            if (list[k].equals(word)){
                return true;
            }
        }
        return false;
    }
    
    public int countUniqueWordsA() {
        int num = 0;
        String[] words = new String[getCount()];
        for(String s : myWords.data()){
             if (! contains(words, num, s)){
                 words[num] = s;
                 num++;
             }
        }
        return num;
    }
    
    public int countUniqueWordsAL(){
        ArrayList<String> words = new ArrayList<String>();
        for(String s : myWords.data()){
            if (! words.contains(s)) {
                words.add(s);
            }
        }
        return words.size();
    }
    
    public void tester(){
        readWords("confucius.txt");
        //readWords("http://dukelearntoprogram.com/data/confucius.txt");
        System.out.println("number of words read: " + getCount());
        int cA = countUniqueWordsA();
        int cAL = countUniqueWordsAL();
        System.out.println(cA + " compared with " + cAL);
    }
    
    public void randomTester(){
        readWords("data/confucius.txt");
        System.out.println("starting");
        int RAND_SIZE = 100000;
        for(int k=0; k < RAND_SIZE; k++){
            String word = getRandomWordAL();
            if (word.indexOf("*** NEVER HAPPENS ***") != -1){
                System.out.println(word);
            }
        }
        System.out.println("done with randoms");
        
        String[] words = new String[myWords.size()];
        int index = 0;
        for(String s : myWords.data()){
            words[index] = s;
            index += 1;
        }
        System.out.println("starting array");
        for(int k=0; k < RAND_SIZE; k++){
            String word = getRandomWordA(words);
        }System.out.println("done with randoms");
    }
    
}
