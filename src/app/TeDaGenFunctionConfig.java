package app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by bjorn vangompel on 20/04/2017.
 */
public class TeDaGenFunctionConfig {
    private boolean configAvailable ;

    /**
     * basic constructor for the tedagen function configuration
     *
     * @param configFile the config file in a json format
     */
    public TeDaGenFunctionConfig( String configFile) {
        configAvailable = false;
    }

    public boolean readJsonConfig ()
            throws FileNotFoundException,
            IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                "delete_01.json"));

        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;

            String strName = (String) person.get("name");
            System.out.println("Name::::" + strName);

            String strCity = (String) person.get("city");
            System.out.println("City::::" + strCity);

            JSONArray arrays = (JSONArray) person.get("cars");
            for (Object object : arrays) {
                System.out.println("cars::::" + object);
            }
            String strJob = (String) person.get("job");
            System.out.println("Job::::" + strJob);
            System.out.println();

        }
        return true;
    }
    public class FunctionConfig {
        public String functionType;
        public String className;
        public String methodName;

    }

}



