import java.util.*;
import edu.duke.*;

public class VigenereCracker {
    
    public String sliceString(String message, int column, int columns) {
        StringBuilder slice = new StringBuilder();
        for (int i = column; i < message.length(); i+= columns) {
            slice.append(message.charAt(i));
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int keylength, char mostCommon) {
        int[] key = new int[keylength];
        for (int i = 0; i < keylength; i++) {
            String slice = sliceString(encrypted, i, keylength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            int keyi = cc.getKey(slice);
            key[i] = keyi;
        }
        return key;
    }
    
    public HashSet<String> readDictionary (FileResource fr) {
        HashSet<String> dictionary = new HashSet<String>();
        for (String line : fr.lines()) {
            dictionary.add(line.toLowerCase());
        }
        return dictionary;
    }
    
    public int countWords (String decrypted, HashSet<String> dictionary) {
        String[] words = decrypted.split("\\W");
        int count = 0;
        for (int i = 0; i < words.length; i++ ) {
            if (dictionary.contains(words[i].toLowerCase())) {
                count +=1;
            }
        }
        return count;
    }
    
    public String crackForLanguage (String encrypted, HashSet<String> dictionary, char mostCommon) {
        int max = 0;
        int keylength = 0;
        String message = new String();
        for (int i = 1; i < 101; i++) {
            int[] key = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted, dictionary);
            if (max < count) {
                max = count;
                keylength = i;
                message = decrypted;
            }
        }
        System.out.println("keylength " + keylength + " with " + max + " valid words");
        return message;
    }
    
    public char mostCommonChar(HashSet<String> dictionary) {
        HashMap<String, Integer> letterfreqs = new HashMap<String, Integer>();
        for (String word : dictionary) {
            String string = word.toLowerCase();
            for (int i = 0; i < string.length(); i++) {
                String c = word.substring(i, i+1);
                if (! letterfreqs.containsKey(c)) {
                    letterfreqs.put(c, 1);
                }
                else {
                    letterfreqs.put(c, letterfreqs.get(c) + 1);
                }
            }
        }
        Helpers hp = new Helpers();
        int max = hp.maxValue(letterfreqs);
        String s = hp.inverseImage(letterfreqs, max);
        char mostCommon = s.charAt(0);
        return mostCommon;
    }
    
    public String crackForLanguages (String encrypted, HashMap<String, HashSet<String>> languages) {
        HashMap<String, String> decryptedForLanguages = new HashMap<String, String>();
        HashMap<String, Integer> countForLanguages = new HashMap<String, Integer>();
        for (String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            char mostCommon = mostCommonChar(dictionary);
            System.out.print(language + "\t");
            String decryptedForLanguage = crackForLanguage(encrypted, dictionary, mostCommon);
            decryptedForLanguages.put(language, decryptedForLanguage);
            countForLanguages.put(language, countWords(decryptedForLanguage, dictionary));
        }
        Helpers hp = new Helpers();
        int max = hp.maxValue(countForLanguages);
        String bestlanguage = hp.inverseImage(countForLanguages, max);
        return decryptedForLanguages.get(bestlanguage);
    }
    
    public void testsliceString(String message, int column, int columns) {
        System.out.println(sliceString(message, column, columns));
    }
    
    public void testtryKeyLength(int keylength, char mostCommon) {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        FileResource frdict = new FileResource();
        HashSet<String> dictionary = readDictionary(frdict);
        int[] key = tryKeyLength(encrypted, keylength, mostCommon);
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(encrypted);
        int count = countWords(decrypted, dictionary);
        System.out.print("key ");
        for (int i = 0; i < key.length; i++) {
            System.out.print(key[i] + ",");
        }
        System.out.println("\n valid words " + count);
        System.out.println(decrypted);
    }
    
}
