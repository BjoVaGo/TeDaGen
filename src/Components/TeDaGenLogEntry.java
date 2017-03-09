package Components;

/**
 * Created by bjorn vangompel on 07/03/2017.
 * this class is for logging purposes
 */
public class TeDaGenLogEntry {
    private String logEntry;

    public TeDaGenLogEntry(String logEntry) {
        this.logEntry = logEntry;
    }

    @Override
    public String toString() {
        return logEntry.toString();
    }
}
