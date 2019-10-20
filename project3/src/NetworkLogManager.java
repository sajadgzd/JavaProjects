import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NetworkLogManager {

    private ArrayList<LogEntry> listLogEntries;

    //enum types to be used to specify which type of search is used
    enum method{
        Id, TimeStamp, Source, Destination, Protocol, Length, Description;
    }
    // default constructor
    public NetworkLogManager(){
        this.listLogEntries = new ArrayList<LogEntry>();
    }
    // common method for all searchBy methods
    private ArrayList<LogEntry> searchBy(method type, String passedValue){
        ArrayList<LogEntry> resultArrayList = new ArrayList<>();
        switch (type) {
            case Id:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getId() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case TimeStamp:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getTimestamp() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case Source:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getSource() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case Destination:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getDestination() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case Protocol:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getProtocol() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case Length:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getLength() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
            case Description:
                for(int i = 0; i < listLogEntries.size(); i++){
                    if(listLogEntries.get(i).getDescription() == passedValue){
                        resultArrayList.add(listLogEntries.get(i));
                    }
                }
                break;
        }
        return resultArrayList;
    }

    // method to load the file with entries
    public Boolean loadFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String arr[] = line.split(",");
            try {
                LogEntry logEntry = new LogEntry(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                listLogEntries.add(logEntry);
            } catch (IllegalArgumentException e) {
                System.out.printf("Skipping line: %s%n", line);
            }
        }
        if(scanner != null){
            scanner.close();
        }
        return Boolean.TRUE;
    }

    @Override
    public String toString() {
        return "NetworkLogManager: there are " + listLogEntries.size() + " records";
    }

    public ArrayList<LogEntry> searchByRange(String fromDate, String toDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyy HH:mm:ss");
        Date from = dateFormat.parse(fromDate);
        Date to = dateFormat.parse(toDate);
        ArrayList<LogEntry> result = new ArrayList<>();

        for(int i = 0; i < listLogEntries.size(); i++){
            Date timestampDate = dateFormat.parse(listLogEntries.get(i).getTimestamp());
            if(timestampDate.compareTo(from) >=  0 && timestampDate.compareTo(to) <= 0){
                result.add(listLogEntries.get(i));
            }
        }
        return result;
    }

    public ArrayList<LogEntry> searchById(String id){
        return searchBy(method.Id, id);
    }
    public ArrayList<LogEntry> searchByTimeStamp(String date){
        return searchBy(method.TimeStamp, date);
    }
    public ArrayList<LogEntry> searchBySource(String source){
        return searchBy(method.Source, source);
    }
    public ArrayList<LogEntry> searchByDestination(String destination){
        return searchBy(method.Destination, destination);
    }
    public ArrayList<LogEntry> searchByProtocol(String protocol){
        return searchBy(method.Protocol, protocol);
    }
    public ArrayList<LogEntry> searchByLength(String length){
        return searchBy(method.Length, length);
    }
    public ArrayList<LogEntry> searchByDescription(String description){
        return searchBy(method.Description, description);
    }

}
