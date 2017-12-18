package it.colasuonno.mathstuff;

import it.colasuonno.mathstuff.components.Expression;
import it.colasuonno.mathstuff.util.Parsing;
import it.colasuonno.mathstuff.util.Result;

public class MathStuff {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        String test = "43x+6y-3z+6y+567x";

        Expression expression = Parsing.parse(test);

        String result = Result.build(expression);

        System.out.print("\nRISULTATO: " + result);

    }


}
