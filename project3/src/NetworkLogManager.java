import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class NetworkLogManager {

    enum method{
        Id, TimeStamp, Source, Destination, Protocol, Length, Description;
    }

    private ArrayList<LogEntry> commonMethod(String type){

    }

    public boolean loadFile(String filename){
        Scanner input = new Scanner(filename);
        input.nextLine();
    }

    public String toString() {
        return "there are " + " records";
    }

    public ArrayList<LogEntry> searchByRange(String fromDate, String toDate){
//        return;
    }
    public ArrayList<LogEntry> searchById(String date){
//        return;
    }
    public ArrayList<LogEntry> searchByTimeStamp(String date){
//        return;
    }
    public ArrayList<LogEntry> searchBySource(String date){
//        return "";
    }
    public ArrayList<LogEntry> searchByDestination(String date){
//        return "";
    }
    public ArrayList<LogEntry> searchByProtocol(String date){
//        return "";
    }
    public ArrayList<LogEntry> searchByLength(String date){
//        return "";
    }
    public ArrayList<LogEntry> searchByDescription(String date){
//        return "";
    }

}
