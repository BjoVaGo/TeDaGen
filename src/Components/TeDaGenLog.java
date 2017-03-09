package Components;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjorn vangompel on 07/03/2017.
 */
public class TeDaGenLog {
    private List<TeDaGenLogEntry> logEntries = new LinkedList<TeDaGenLogEntry>();

    public TeDaGenLog() {

    }

    /**
     * add a message to the logfile
     *
     * @param errorMessage the error message.
     */
    public void add(String errorMessage) {
        this.logEntries.add(new TeDaGenLogEntry(errorMessage));
    }

    /**
     * clear all errors
     */
    public void clear() {
        logEntries.removeAll(logEntries);
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
