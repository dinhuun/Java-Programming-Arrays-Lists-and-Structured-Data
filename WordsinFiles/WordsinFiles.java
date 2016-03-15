/**
 * from a given number of files and all their words
 * use HashMap to find the largest number of files a word appears in and list those files
 * note that this word may not be unique
 * @DinhHuuNguyen
 * @01/09/2016
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsinFiles {
    private HashMap<String , ArrayList<String>> map;
    
    public WordsinFiles() {
        map = new HashMap<String , ArrayList<String>>();        
    }
    
    private void mapWordsToFile(File f) {
        String filename = f.getName();
        FileResource file = new FileResource(f);
        for (String word : file.words()) {
            if (! map.containsKey(word)) {
                ArrayList<String> containingfiles = new ArrayList<String>();
                containingfiles.add(filename);                
                map.put(word, containingfiles);
            }
            else {
                if (! map.get(word).contains(filename)) {
                map.get(word).add(filename);
                }
            }
        }
    }
    
    public void mapWordsToFiles() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            mapWordsToFile(file);
        }
    }
    
    public void testmapWordsToFiles() {
        mapWordsToFiles();
        System.out.println(map.size() + " words appear in selected files");
        for (String word : map.keySet()) {
            System.out.println(word);
            for (String file : map.get(word)) {
                System.out.println("\t" + file);
            }
        }
    }
    
    public void WordsInMostFiles () {
        mapWordsToFiles();
        Helpers hp = new Helpers();
        HashMap<String, Integer> maptoimagesize = hp.sizeOfEachImage(map);
        int max = hp.maxValue(maptoimagesize);
        ArrayList<String> list = hp.inverseImage(maptoimagesize, max);
        System.out.println(list.size() + " words appear in the most number of files");
        for (String word : list) {
            System.out.println(word);
            for (String file : map.get(word)) {
                System.out.println("\t" + file);
            }
        }
    }
    
    public void WordsInNumFiles (int number) {
        mapWordsToFiles();
        Helpers hp = new Helpers();
        HashMap<String, Integer> maptoimagesize = hp.sizeOfEachImage(map);
        ArrayList<String> list = hp.inverseImage(maptoimagesize, number);
        System.out.println(list.size() + " words appear in exactly " + number + " files");
        for (String word : list) {
            System.out.println(word);
            for (String file : map.get(word)) {
                System.out.println("\t" + file);
            }
        }
    }
    
    public void FilesContainingWord (String word) {
        mapWordsToFiles();
        if (map.containsKey(word)) {
            System.out.println("\"" + word + "\" appears in");
            for (String file : map.get(word)) {
                System.out.println(file);
            }
        }
    }
    
}
