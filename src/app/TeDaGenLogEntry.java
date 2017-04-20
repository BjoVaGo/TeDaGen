package app;

/**
 * Created by bjorn vangompel on 07/03/2017.
 * this class is for logging purposes
 */
public class TeDaGenLogEntry {
    private String logEntry;
    private logType type;

    public TeDaGenLogEntry(String logEntry, logType type) {
        this.logEntry = logEntry;
        this.type     = type;
    }

    @Override
    public String toString() {
        return logEntry.toString();
    }
}

