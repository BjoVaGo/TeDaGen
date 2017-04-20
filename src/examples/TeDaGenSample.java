package examples;

import app.OutputGenerators.consoleOutputGenerator;
import app.TeDaGen;

/**
 * Created by bjornvangompel on 22/03/2017.
 */
public class TeDaGenSample {

    public static void main(String[] args) {
        TeDaGen testdata;
        consoleOutputGenerator output;

        output = new consoleOutputGenerator();
        testdata = new TeDaGen();

        testdata.generate("abcint()string()",10 , output).writeToOutput();

    }
}
