import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkLogManager {

    private final static SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyy HH:mm:ss");

    private final ArrayList<LogEntry> listLogEntries;

    public enum SearchField {
        ID, TIMESTAMP, SOURCE, DESTINATION, PROTOCOL, LENGTH, DESCRIPTION
    }

    public NetworkLogManager() {

        this.listLogEntries = new ArrayList<LogEntry>();
    }

    public boolean loadFile(String fileName) {

        /*
         * Convert to code using Streams.
         * Do not use Scanner or while
         */
        try {
            Files.lines(Paths.get(fileName))
                    .forEach(line -> {
                        String[] lineArr = line.split(",");
                        try {
                            listLogEntries.add(new LogEntry(lineArr[0].trim(), lineArr[1].trim(), lineArr[2].trim(),
                                    lineArr[3].trim(), lineArr[4].trim(), lineArr[5].trim(), lineArr[6].trim()));
                        }
                        catch (IllegalArgumentException ex){
                            System.out.printf("Skipping line: %s%n", line);
                        }
                    });
        }
        catch (IOException fnfe) {
            return false;
        }
        return true;
    }

    public String toString() {

        return String.format("NetworkLogManager: there are %,d valid records", listLogEntries.size());
    }

    public List<LogEntry> searchById(String str) {

        return searchBy(str, SearchField.ID);
    }

    public List<LogEntry> searchByTimestamp(String str) {

        return searchBy(str, SearchField.TIMESTAMP);
    }

    public List<LogEntry> searchBySource(String str) {

        return searchBy(str, SearchField.SOURCE);
    }

    public List<LogEntry> searchByDestination(String str) {

        return searchBy(str, SearchField.DESTINATION);
    }

    public List<LogEntry> searchByProtocol(String str) {

        return searchBy(str, SearchField.PROTOCOL);
    }

    public List<LogEntry> searchByLength(String str) {

        return searchBy(str, SearchField.LENGTH);
    }

    public List<LogEntry> searchByDescription(String str) {

        return searchBy(str, SearchField.DESCRIPTION);
    }

    public List<LogEntry> searchByRange(String fromDate, String toDate) throws ParseException {

        /*
         * Convert to code using Streams.
         * Do not use for
         */

        Date from = formatter.parse(fromDate);
        Date to = formatter.parse(toDate);

        List<LogEntry> retList = listLogEntries.stream()
                .filter(x -> {
                    try {
                        return formatter.parse(x.getTimestamp()).compareTo(from) >= 0
                                && formatter.parse(x.getTimestamp()).compareTo(to) <= 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return Boolean.parseBoolean(null);
                    }
                }).collect(Collectors.toList());

        return retList;
    }

    private List<LogEntry> searchBy(String searchVal, SearchField field) {

        /*
         * Convert to code using Streams.
         * Do not use for
         */

        List<LogEntry> retList = listLogEntries.stream().filter(x -> getSearchValue(x, field).equals(searchVal))
                .collect(Collectors.toList());


        return retList;
    }

    private String getSearchValue(LogEntry logEnt, SearchField field) {

        switch (field) {
            case ID:
                return logEnt.getId();
            case TIMESTAMP:
                return logEnt.getTimestamp();
            case SOURCE:
                return logEnt.getSource();
            case DESTINATION:
                return logEnt.getDestination();
            case DESCRIPTION:
                return logEnt.getDescription();
            case PROTOCOL:
                return logEnt.getProtocol();
            case LENGTH:
                return logEnt.getLength();
            default:
                return null;
        }
    }
}