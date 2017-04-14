package Components;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjorn vangompel on 07/03/2017.
 */
public class TeDaGenLog {
    private List<TeDaGenLogEntry> logEntries = new LinkedList<TeDaGenLogEntry>();
    private boolean hasError;
    private boolean hasWarning;

    public TeDaGenLog() {

    }

    /**
     * add an Monitor message to the logfile
     *
     * @param monitorMessage the Monitor message.
     */
    public void addMonitor(String monitorMessage) {
        this.logEntries.add(new TeDaGenLogEntry(monitorMessage, logType.MONITOR) );
        this.hasError = true;
    }

    /**
     * add a warning message to the logfile
     *
     * @param warningMessage the error message.
     */
    public void addWarning(String warningMessage) {
        this.logEntries.add(new TeDaGenLogEntry(warningMessage, logType.WARNING));
        this.hasWarning = true;
    }

    /**
     * add an error message to the logfile
     *
     * @param errorMessage the error message.
     */
    public void addError(String errorMessage) {
        this.logEntries.add(new TeDaGenLogEntry(errorMessage, logType.ERROR) );
        this.hasError = true;
    }

    /**
     * clear all errors
     */
    public void clear() {
        logEntries.removeAll(logEntries);
        this.hasWarning = false;
        this.hasError   = false;
    }

    /**
     * print the errors to the console
     */
    public void print() {
        for (int i = 0; i < logEntries.size(); i++) {
            System.out.println(logEntries.get(i).toString());
        }

    }

}
