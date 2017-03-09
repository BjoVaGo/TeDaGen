package examples;

import Components.TeDaGenLog;

/**
 * Created by bjornvangompel on 07/03/2017.
 */
public class LogSample {

    public static void main(String[] args) {
        TeDaGenLog logger = new TeDaGenLog();
        logger.add("this is the error message");
        logger.add("another error message");
        System.out.println("All error messages :");
        logger.print();
        logger.clear();
        System.out.println("No More error messages :");
        logger.print();

    }


}
