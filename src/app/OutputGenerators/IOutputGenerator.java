package app.OutputGenerators;

/**
 * Created by bjorn vangompel on 07/03/2017.
 */
public interface IOutputGenerator{
     /**
      * @param str the output string
      */
     void add(String str);
     void writeToOutput();
}
