package Components;

import Components.OutputGenerators.IOutputGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main tedagen class where all the magic starts
 *
 * Created by bjorn vangompel on 07/03/2017.
 */
public class TeDaGen {

    private boolean error;
    private int generationTime; // Total generation time
    private Date startStamp;    // Start time of the script
    private TeDaGenLog log ;    // Array containing the logs (warnings, etc)
    private int iIteration;     // current iteration in iteration loop
    //matches // The regex matches array
    // matchi // foreach loop counter in Matches **/

    /**
     * Generate
     *
     * @param strPattern The test data generation pattern
     * @param iterations The Number of iterations to generate
     * @return returns the output in the form of an output generator
     */
    public IOutputGenerator generate(String strPattern, int iterations, IOutputGenerator output) {

        Instant start = Instant.now();
        int i;
        String tempStr = "";


        error          = false;
        generationTime = 0;
        startStamp     = new Date();
        log            = new TeDaGenLog();



        log.addMonitor("Start of Generation");

        if(checkPattern(strPattern) && checkIterations(iterations)){
            for( i=0 ; i < iterations ; i++ ){
                TeDaGenFunctionMapper functionMapper = new TeDaGenFunctionMapper();
                tempStr = TeDaGenFunctionMapper.mapAll(strPattern);


                output.add("This is line".concat(Integer.toString(i)).concat(tempStr));
            }
        }




        Instant end = Instant.now();
        log.addMonitor("End of Generation -- time taken: ".concat(toString().valueOf(Duration.between(start, end))));
        log.print();

        return output;
    }

    /**
     * check if the pattern is valid
     *
     * @param pattern The test data generation pattern
     * @return returns true or false whether the pattern is valid
     */
    public boolean checkPattern(String pattern) {

        if(pattern.length() < 1){
            log.addWarning("Whoops... The pattern is empty. Please try again.");
            error = true;
            return false;
        }
        return true;
    }

    /**
     * check if the iterations number is valid
     *
     * @param iterations The Number of iterations to generate
     * @return returns true or false whether the number of iterations is valid
     */
    public boolean checkIterations(int iterations) {
        if(iterations < 1){
            log.addWarning("Whoops... he number of iterations must be a positive number. Please try again.");
            error = true;
            return false;
        }
        return true;
    }


}
