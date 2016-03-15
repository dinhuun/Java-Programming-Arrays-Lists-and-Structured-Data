/**
 * test different classes in LogAnalyzer
 * @DinhHuuNguyen 
 * @01/13/2016
 */
import edu.duke.*;
import java.io.*;
import java.util.*;

public class Tests {
    
    public void printArrayList (ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        la.printAll();
    }
    
    public void testentriesWithSCHigherThan(String filename, int num) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(filename);
        ArrayList<LogEntry> entriesWithStatusCodeOver = la.entriesWithSCHigherThan(num);
        System.out.println("all log entries in " + filename + " with status code higher than " + num);
        printArrayList(entriesWithStatusCodeOver);
    }
    
    public void testuniqueIPsWithSCInRange (String filename, int low, int high) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(filename);
        ArrayList<String> entriesWithStatusCodeOver = la.uniqueIPsWithSCInRange(low, high);
        System.out.println("number of log entries with status codes between " + low + " and " + high + " in " + filename + " is "
        + entriesWithStatusCodeOver.size());
    }
    
    public void testIPsInLog (String filename) {
        LogAnalyzer la = new LogAnalyzer();
        Helpers hp = new Helpers();
        la.readFile(filename);
        ArrayList<String> listOfIPsInLog = la.IPsInLog();        
        HashMap<String, Integer> uniqueIPs = hp.countMultiplicities(listOfIPsInLog);
        System.out.println("there are " + uniqueIPs.size() + " unique IPs for " + listOfIPsInLog.size() + " visits in " + filename);
        System.out.println("those IPs with max number of visits " + hp.maxValue(uniqueIPs) + " in " + filename);        
        printArrayList(hp.inverseImage(uniqueIPs, hp.maxValue(uniqueIPs)));
    }
    
    public void testIPsByDates(String filename) {
        LogAnalyzer la = new LogAnalyzer();
        Helpers hp = new Helpers();
        la.readFile(filename);
        HashMap<String, ArrayList<String>> DatesToIPs = la.IPsByDates();
        HashMap<String, Integer> DatesToIPsCounts = new HashMap<String, Integer>();
        for (String date : DatesToIPs.keySet()) {  
            DatesToIPsCounts.put(date, DatesToIPs.get(date).size());                        
        }
        System.out.println("those dates with max number of visits " + hp.maxValue(DatesToIPsCounts) + " in " + filename);        
        printArrayList(hp.inverseImage(DatesToIPsCounts, hp.maxValue(DatesToIPsCounts)));
    }
    
    public void testIPsInDay(String filename, String day) {
        LogAnalyzer la = new LogAnalyzer();
        Helpers hp = new Helpers();
        la.readFile(filename);
        HashMap<String, ArrayList<String>> DatesToIPs = la.IPsByDates();
        ArrayList<String> listofIPs = DatesToIPs.get(day);
        HashMap<String, Integer> uniqueIPs = hp.countMultiplicities(listofIPs);
        System.out.println("there are " + uniqueIPs.size() + " unique IPs for " + listofIPs.size() + " visits in " + day + " in " + filename);
        System.out.println("those IPs with max number of visits " + hp.maxValue(uniqueIPs) + " in " + day);        
        printArrayList(hp.inverseImage(uniqueIPs, hp.maxValue(uniqueIPs)));
    }
}