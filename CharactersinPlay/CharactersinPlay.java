/**
 * use ArrayLists Characters, Freqs, Parts to
 * find characters in Shakespeare’s play and their number of speaking parts
 * find characters that speak certain percents of the times
 * find characters that speak between low-high times
 * find characters that speak the 1st most, 2nd most, 3rd most
 * @DinhHuuNguyen
 * @01/08/2016
 */

import edu.duke.*;
import java.util.*;

public class CharactersinPlay {
    
    private ArrayList<String> Parts;
    private ArrayList<String> Characters;
    private ArrayList<Integer> Freqs;
    
    public CharactersinPlay() {
        Parts = new ArrayList<String>();
        Characters = new ArrayList<String>();
        Freqs = new ArrayList<Integer>();
    }
    
    public void findAllCharacters(FileResource fr) {
        Parts.clear();
        Characters.clear();
        Freqs.clear();
        for(String line : fr.lines()){
            Parts.add(line);
            int start = 0;
            int dot = line.indexOf(".");
            if (dot != -1) {
                String name = line.substring(0,dot);
                update(name);
            }
        }
    }
    
    public void update(String name) {
        String person = name.toLowerCase();
        int index = Characters.indexOf(person);
        if (index == -1){
            Characters.add(person);
            Freqs.add(1);
        }
        else {
            int freq = Freqs.get(index);
            Freqs.set(index, freq + 1);
        }
    }
    
    public void testfindAllCharacters() {
        FileResource fr = new FileResource();
        findAllCharacters(fr);
        System.out.println("number of characters: " + Characters.size());
        for (int i = 0; i < Characters.size(); i++) {
            System.out.println(Characters.get(i) + "\t" + Freqs.get(i));            
        }
    }
    
    public void findWhoSpeakPercent (double percent) {
        FileResource fr = new FileResource();
        findAllCharacters(fr);
        System.out.println("who speaks more than " + percent + " of parts");
        for (int i = 0; i < Characters.size(); i++) {
            if (((float)Freqs.get(i)) / Parts.size() > percent) {
                System.out.println(Characters.get(i) + "\t" + Freqs.get(i));
            }
        }
    }
    
    public void findWhoSpeakInRange (int low, int high) {
        FileResource fr = new FileResource();
        findAllCharacters(fr);
        System.out.println("who speak between " + low + "-" + high + " parts");
        for (int i = 0; i < Characters.size(); i++) {
            if (low <= Freqs.get(i) && Freqs.get(i) < high) {
                System.out.println(Characters.get(i) + "\t" + Freqs.get(i));
            }
        }
    }
        
        public void findWhoSpeakMost2ndMost3rdMost () {
        FileResource fr = new FileResource();
        findAllCharacters(fr);
        Helpers hp = new Helpers();
        int index1 = hp.indexOfMax(Freqs);
        int index2 = hp.indexOfMaxBelow(Freqs, Freqs.get(index1));
        int index3 = hp.indexOfMaxBelow(Freqs, Freqs.get(index2));
        System.out.println(Characters.get(index1) + "\t" + Freqs.get(index1));
        System.out.println(Characters.get(index2) + "\t" + Freqs.get(index2));
        System.out.println(Characters.get(index3) + "\t" + Freqs.get(index3));
    }
    
}
