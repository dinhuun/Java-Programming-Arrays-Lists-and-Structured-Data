/**
 * compare the time to count words in a file using countWords without HashMap
 * and the time to count words in a file using countWords with Hashmap
 * @DinhHuuNguyen
 * @01/10/2016
 */
import edu.duke.*;
import java.util.*;

public class WordFrequenciesMap {
	
	public void countWords(String filename){
		FileResource fr = new FileResource(filename);
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> counters = new ArrayList<Integer>();
		for(String w : fr.words()){
			w = w.toLowerCase();
			int index = words.indexOf(w);
			if (index == -1){
				words.add(w);
				counters.add(1);
			}
			else {
				int value = counters.get(index);
				counters.set(index, value + 1);
			}
		}
		int total = 0;
		for(int k=0; k < words.size(); k++){
			if (counters.get(k) > 500){
				System.out.println(words.get(k) + "\t" + counters.get(k));
			}
			total += counters.get(k);
		}
		System.out.println("total words \t" + total);
		System.out.println("unique words \t" + words.size());
	}
	
	public void countWordsMap(String filename){
		FileResource fr = new FileResource(filename);
		HashMap<String,Integer> map = new HashMap<String,Integer>();

		for(String w : fr.words()){
			w = w.toLowerCase();
			if (!map.containsKey(w)){
				map.put(w,1);
			}
			else {
				map.put(w,map.get(w)+1);
			}
		}
		int total = 0;
		for(String w : map.keySet()){
			int value = map.get(w);
			if (value > 500){
				System.out.println(w + "\t" + value);
			}
			total += value;
		}
		System.out.println("total words \t" + total);
		System.out.println("unique words \t" + map.keySet().size());
	}
	
	public void tesWordFrequenciesMap(){
		String filename = "kjv10.txt";
		double start = System.currentTimeMillis();
		countWords(filename);
		double end = System.currentTimeMillis();
		double time = (end - start)/1000;
		System.out.println("time \t" + time);
		start = System.currentTimeMillis();
		countWordsMap(filename);
		end = System.currentTimeMillis();
		time = (end - start)/1000;
		System.out.println("time \t" + time);
	}
	
}
