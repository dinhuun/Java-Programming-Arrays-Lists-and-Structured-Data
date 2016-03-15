/**
 * create a LogAnalyzer class to
 * create an ArrayList logentries of LogEntry objects
 * many methods to analyze them
 * @DinhHuuNguyen 
 * @01/13/2016
 */
import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
   private ArrayList<LogEntry> logentries;
    
   public LogAnalyzer () {
       logentries = new ArrayList<LogEntry>();   
   }
    
   public void readFile (String filename) {
       FileResource fr = new FileResource(filename);
       for (String line : fr.lines()) {
           LogEntry le = WebLogParser.parseEntry(line);
           logentries.add(le);
       }
   }
    
   public void printAll() {
       for (LogEntry le : logentries) {
           System.out.println(le);
       }
   }
   
   public ArrayList<LogEntry> entriesWithSCHigherThan (int num) {
       ArrayList<LogEntry> entriesWithStatusCodeOver = new ArrayList<LogEntry>();
       for (LogEntry le : logentries) {
           if (le.getStatusCode() > num) {
               entriesWithStatusCodeOver.add(le);
           }
       }
       return entriesWithStatusCodeOver;
   }
   
   public ArrayList<String> uniqueIPsWithSCInRange (int low, int high) {
       ArrayList<String> uniqueIPsWithSCbetween = new ArrayList<String>();       
        for (LogEntry le : logentries) {
           int statusCode = le.getStatusCode();
           String IPaddress = le.getIPaddress();
           if (low <= statusCode && statusCode <= high && (! uniqueIPsWithSCbetween.contains(IPaddress))) {
               uniqueIPsWithSCbetween.add(IPaddress);
           }
       }
       return uniqueIPsWithSCbetween;
   }
   
   public ArrayList<String> IPsInLog() {
       ArrayList<String> listOfIPsInLog = new ArrayList<String>();
       for (LogEntry le : logentries) {
           listOfIPsInLog.add(le.getIPaddress());       
       }
       return listOfIPsInLog;
   }
   
   public HashMap<String, ArrayList<String>> IPsByDates() {
       HashMap<String, ArrayList<String>> DatesToIPs = new HashMap<String, ArrayList<String>>();
       for (LogEntry le : logentries) {
           String accesstime = le.getAccessTime().toString();
           String date = accesstime.substring(4, 10);
           if (! DatesToIPs.containsKey(date)) {
               ArrayList<String> listofIPs = new ArrayList<String>();
               listofIPs.add(le.getIPaddress());
               DatesToIPs.put(date, listofIPs);
           }
           else {
               DatesToIPs.get(date).add(le.getIPaddress());
            }
       }
       return DatesToIPs;
   }
       
}