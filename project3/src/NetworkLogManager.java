import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NetworkLogManager {

    private ArrayList<LogEntry> listLogEntries;

    enum method{
        Id, TimeStamp, Source, Destination, Protocol, Length, Description;
    }

    public NetworkLogManager(){
        this.listLogEntries = new ArrayList<LogEntry>();
    }


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

    public Boolean loadFile(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String arr[] = line.split(",");
//                System.out.println(line);
                LogEntry logEntry = new LogEntry(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                listLogEntries.add(logEntry);
            }
            scanner.close();
            return Boolean.TRUE;
        }
        catch (FileNotFoundException e){
//            throw new FileNotFoundException;
            return Boolean.FALSE;
        }

    }

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
        return searchBy(method.Id, source);
    }
    public ArrayList<LogEntry> searchByDestination(String destination){
        return searchBy(method.Id, destination);
    }
    public ArrayList<LogEntry> searchByProtocol(String protocol){
        return searchBy(method.Id, protocol);
    }
    public ArrayList<LogEntry> searchByLength(String length){
        return searchBy(method.Id, length);
    }
    public ArrayList<LogEntry> searchByDescription(String description){
        return searchBy(method.Id, description);
    }

}
