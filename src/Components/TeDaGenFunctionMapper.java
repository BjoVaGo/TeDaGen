package Components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bjornvangompel on 06/04/2017.
 */
public class TeDaGenFunctionMapper {

    public static String mapAll(String strPattern){
        String mappedStr = strPattern;

        /**
         * All functions should be mapped in here using regex
         * later we can change this with a config file
         */
        mappedStr = mapFunction(mappedStr,"int\\(\\)", "Components.TeDaGenNumber","getRandomInt");
        mappedStr = mapFunction(mappedStr,"string\\(\\)", "Components.TeDaGenString","getString");

        return mappedStr;
    }


    public static String mapFunction(String fullPattern,String functionRegex, String ClassName  , String MethodName ){
        String tempStr = "";

        // Create a copy of the original pattern to manipulate
        tempStr = fullPattern;

        // integer, default 0 to 9
        Pattern pattern = Pattern.compile(functionRegex); // ("/int\(\)/gi")
        Matcher matcher = pattern.matcher(tempStr);

        try
        {
            while (matcher.find()) {
                tempStr = matcher.replaceAll(
                        Class.forName(ClassName)
                        .getDeclaredMethod(MethodName)
                        .invoke(null, null)
                        .toString()

                );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;
    }

}
