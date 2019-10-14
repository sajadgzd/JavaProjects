import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class NetworkLogManager {

    enum method{
        Id, TimeStamp, Source, Destination, Protocol, Length, Description;
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
    public String searchById(String date){
        return "";
    }
    public String searchByTimeStamp(String date){
        return "";
    }
    public String searchBySource(String date){
        return "";
    }
    public String searchByDestination(String date){
        return "";
    }
    public String searchByProtocol(String date){
        return "";
    }
    public String searchByLength(String date){
        return "";
    }
    public String searchByDescription(String date){
        return "";
    }

}
