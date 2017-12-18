package it.colasuonno.mathstuff.util;


import it.colasuonno.mathstuff.components.Component;
import it.colasuonno.mathstuff.components.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {


    /**
     *
     * @param expression
     * @return
     */
    public static String build(Expression expression){

        String result = "";
        List<String> letters = new ArrayList<String>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        Map<String, Integer> total = new HashMap<String, Integer>();

        // translating components..

        for (Component components : expression.getComponents()){

            // controlla se esistono lettere nella lista ? aggiungi : non fai niente

            if (!letters.contains(components.getLetters())){
                letters.add(components.getLetters());
            }

            // controlla se nella mappa esiste la key lettera ? Aggiungi il numero : aggiungi key e numero

            if (!map.containsKey(components.getLetters())){
                List<Integer> list = new ArrayList<Integer>();
                list.add(Replace.numeric(components.getSign(), components.getNum()));
                map.put(components.getLetters(), list);
            } else{
                List<Integer> list = map.get(components.getLetters());
                list.add(Replace.numeric(components.getSign(), components.getNum()));
                map.put(components.getLetters(), list);
            }

        }

        // operazioni dei segni

        for (String lettere : letters){
            List<Integer> list = map.get(lettere);
            int tot = 0;
            for (Integer k : list){
                tot = tot + k;
            }
            total.put(lettere,tot);
        }

        // stampa...

        for (String lettere : letters){
            result = result + " " + getSign(total.get(lettere)) + total.get(lettere) + lettere;
        }

        return result;

    }

    private static String getSign(int num){
        if (!String.valueOf(num).contains("-")){
            return "+";
        }
        else{
            return "";
        }
    }

}
