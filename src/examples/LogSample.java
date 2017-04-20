package examples;

import app.TeDaGenLog;

/**
 * Created by bjornvangompel on 07/03/2017.
 */
public class LogSample {

    public static void main(String[] args) {
        TeDaGenLog logger = new TeDaGenLog();
        logger.addError("this is the error message");
        logger.addWarning("this is a warning message");
        System.out.println("All messages :");
        logger.print();
        logger.clear();
        System.out.println("No More error messages :");
        logger.print();

    }


}
