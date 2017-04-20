package examples;

import app.TeDaGenFunctionMapper;


/**
 * Created by bjornvangompel on 07/04/2017.
 */
public class FunctionMapperSample {
    public static void main(String[] args) {
        TeDaGenFunctionMapper functionMapper = new TeDaGenFunctionMapper();
        System.out.println("mapped : " + TeDaGenFunctionMapper.mapAll("int()string()bjorn int()"));
    }
}
