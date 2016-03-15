/**
 * From a source of URS of files or of directory of files that contain alternative colors, nouns,..., fruits
 * use HashMap to replace each lable color, noun,..., fruit in a given story with a random corresponding alternative
 * usedWords makes sure an alternative is never used more than once
 * @DinhHuuNguyen
 * @01/10/2016
*/
import edu.duke.*;
import java.util.*;
import java.io.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> map;
    private ArrayList<String> usedWords;
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap() {
        map = new HashMap<String , ArrayList<String>>();        
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        usedWords = new ArrayList<String>();        
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
           URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private void initializeFromSource(String source) {
        String[] labels = {"color", "noun", "adjective", "country", "name", "animal", "timeframe", "verb", "fruit"};
        for (int i = 0; i < labels.length; i++) {
            map.put(labels[i], readIt(source + "/" + labels[i] + ".txt"));
        }
    }
    
    private String randomFrom(ArrayList<String> list){
        int index = myRandom.nextInt(list.size());
        return list.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        else if (map.containsKey(label)) {
            return (randomFrom(map.get(label)));
        }
        else {return "**UNKNOWN**";}
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = "used";
        while (true) {
            sub = getSubstitute(w.substring(first+1,last));   
            if (! usedWords.contains(sub)) {
                usedWords.add(sub);
                break;
            }
        }
        return prefix + sub + suffix;
    }
    
    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    public int totalWordsinMap () {
        int total = 0;
        for (ArrayList<String> list : map.values()) {
            for (String word : list) {
                total +=1;
            }
        }
        return total;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    public void makeStory(){
        usedWords.clear();
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println();
        System.out.println("used " + usedWords.size() + " substitutes out of " + totalWordsinMap() + " words");
        for (int i = 0; i < usedWords.size(); i++) {
            System.out.println(usedWords.get(i));
        }
    }
    
}
