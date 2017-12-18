package it.colasuonno.mathstuff.util;


import it.colasuonno.mathstuff.MathStuff;
import it.colasuonno.mathstuff.components.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parsing {

    private static Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();

    /**
     * Parsing..
     *
     * @param expression
     * @return
     */
    public static Expression parse(String expression) {
        List<Grade> list = new ArrayList<Grade>();
        List<Component> components = new ArrayList<Component>();

        Expression e = new Expression(null);
        LazyExpression expr = new LazyExpression(null);

        char[] j = expression.toCharArray();

        for (int i = 0; i < j.length; i++) {
            if (Checker.isNumber(j[i])) {
                list.add(new Grade(Type.NUMERO, i, j[i]));
            } else if (Checker.isLetter(j[i])) {
                list.add(new Grade(Type.LETTERA, i, j[i]));
            } else if (Checker.isSign(j[i])) {
                list.add(new Grade(Type.SEGNO, i, j[i]));
            }
        }

        expr.setComponents(list);

        // loop per ogni grado
        for (int i = 0; i < list.size(); i++) {

            System.out.print("\nGRADE: index(" + i + ") = " + list.get(i).getContenuto() + " TYPE: " + list.get(i).getType());

            Grade grado = list.get(i);

            // setUP

            if (!checked.containsKey(i) && !grado.getType().equals(Type.SEGNO)) {

                char sign;
                int numbers = 0;
                String letters = "";
                int key = 0;

                if (i == 0) {
                    sign = '+';
                } else {
                    sign = (char) list.get(i - 1).getContenuto();
                }

                if (checkForNumbers(list, list.size() - i, i)) {
                    System.out.print("\nTROVATO... CERCO");
                    numbers = numbers(list, list.size() - i, i);
                } else if (grado.getType().equals(Type.NUMERO)) {
                    System.out.print("\nNON TROVATI STO USANDO IL " + grado.getContenuto());
                    numbers = Integer.parseInt(String.valueOf(grado.getContenuto()));
                }

                key = String.valueOf(numbers).length();

                if (checkForLetters(list, list.size() - i, (i+key)-1)){
                    System.out.print("\nTROVATO(L).. CERCO");
                    letters = letters(list, list.size() - i, (i+key)-1);
                } else {
                    System.out.print("\nNON TROVATI LASCIO LA LETTERA VUOTA PER NUMBERS("+numbers+")");
                    letters = "";
                }

                System.out.print("\n" + MathStuff.ANSI_BLUE + "CREATING COMPONENT = " + sign + numbers + letters + MathStuff.ANSI_RESET);

                components.add(new Component(sign, numbers, letters, i));

            }


        }

        e.setComponents(components);

        System.out.print("\nFINE PARSING CON " + components.size() + " ELEMENTI");

        return e;
    }

    private static boolean checkForLetters(List<Grade> gradi, int intensita, int current){

        Grade grado = gradi.get(current);

        System.out.print("\nCERCANDO (L): " + grado.getContenuto() + " TYPE: " + grado.getType() + " INTENSITA " + intensita + " CURRENT " + current);

            for (int i = current+1; i < gradi.size(); i++) {
                System.out.print("\nTEMP: " + gradi.get(i).getContenuto() + " TYPE: " + gradi.get(i).getType());
                if (gradi.get(i).getType().equals(Type.LETTERA)) {
                    return true;
                }
            }

        return false;
    }

    private static boolean checkForNumbers(List<Grade> gradi, int intensita, int current) {

        Grade grado = gradi.get(current);

        System.out.print("\nCERCANDO (N): " + grado.getContenuto() + " TYPE: " + grado.getType() + " INTENSITA " + intensita + " CURRENT " + current);

        if (grado.getType().equals(Type.NUMERO)) {
            for (int i = current; i < gradi.size(); i++) {
                System.out.print("\nTEMP: " + gradi.get(i).getContenuto() + " TYPE: " + gradi.get(i).getType());
                if (gradi.get(i).getType().equals(Type.NUMERO)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int numbers(List<Grade> gradi, int intensita, int current) {

        Grade grado = gradi.get(current);
        String avenire = "";
        boolean stop = false;

        if (grado.getType().equals(Type.NUMERO)) {
            for (int i = current; i < gradi.size(); i++) {

                if (gradi.get(i).getType().equals(Type.NUMERO)) {
                    if (!stop) {
                        System.out.print("\nAVENIRE (N): " + gradi.get(i).getContenuto());
                        avenire = avenire + String.valueOf(gradi.get(i).getContenuto());
                        checked.put(i, true);
                    }
                } else {
                    stop = true;
                }

            }
            return Integer.parseInt(avenire);
        } else {
            return 0;
        }


    }

    public static String letters(List<Grade> gradi, int intensita, int current) {

        Grade grado = gradi.get(current+1);
        String avenire = "";
        boolean stop = false;


            for (int i = current+1; i < gradi.size(); i++) {
                if (gradi.get(i).getType().equals(Type.LETTERA)) {
                    if (!stop) {
                        System.out.print("\nAVENIRE (L): " + gradi.get(i).getContenuto());
                        avenire = avenire + String.valueOf(gradi.get(i).getContenuto());
                        checked.put(i, true);
                    }
                } else {
                    stop = true;
                }

            }
            return avenire;



    }
}