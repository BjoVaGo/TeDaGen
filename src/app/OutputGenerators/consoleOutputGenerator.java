package app.OutputGenerators;

/**
 *
 * Created by bjornvangompel on 22/03/2017.
 *
 */
public class consoleOutputGenerator implements IOutputGenerator {
    String outputString = "";

    public void add(String str){
        outputString = outputString.concat(str).concat("\n");
    }

    public void writeToOutput() {
        System.out.println(outputString);
    }
}
