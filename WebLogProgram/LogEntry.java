/**
 * create a LogEntry class as well as write its toString method
 * toString method is called automatically when we print a LogEntry object, else object's memory location is printed
 * @DinhHuuNguyen 
 * @01/13/2016
 */

import  java.util.*;

public class LogEntry {
   private String IPaddress;
   private Date accessTime;
   private String request;
   private int statusCode;
   private int bytesReturned;
     
   public LogEntry(String IP, Date time, String req, int status, int bytes) {
       IPaddress = IP;
       accessTime = time;
       request = req;
       statusCode = status;
       bytesReturned = bytes;
       
   }
   
   public String getIPaddress() {
       return IPaddress;
   }
    public Date getAccessTime() {
       return accessTime;
   }   
   public String getRequest() {
       return request;
   }
   public int getStatusCode() {
       return statusCode;
   }
   public int getBytesReturned() {
       return bytesReturned;
   }
   
   public String toString() {
       return IPaddress + " " + accessTime + " " + request + " " + statusCode + " " + bytesReturned;
    }
    
}