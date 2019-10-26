// Sajad Gholamzadehrizi
// updated with the new update in the description of the project on Friday

public class LogEntry {
    //private member variables
    private String id;
    private String timestamp;
    private String source;
    private String destination;
    private String protocol;
    private String length;
    private String description;

    // non default constructor
    public LogEntry(String id, String timestamp, String source, String destination, String protocol,
                     String length, String description){
        if( !id.matches("[0-9]+") || id.equals("0") || timestamp.isEmpty() ||
                source.isEmpty() || destination.isEmpty() ||
                protocol.isEmpty() || !protocol.matches("[A-Za-z0-9]+")|| length.isEmpty()
                || length.equals("0") || description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.timestamp = timestamp;
        this.source = source;
        this.destination = destination;
        this.protocol = protocol;
        this.length = length;
        this.description = description;

        }


    //overriding toString method
    @Override
    public String toString() {
        return  id + "," + timestamp + "," + source + "," + destination + "," + protocol + "," +
                 length + "," + description;
    }

    // below are the getters listed
    public String getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }
}
