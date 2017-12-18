package it.colasuonno.mathstuff.util;

public class Checker {

    public static boolean isLetter(Object object){
        return Character.isLetter((char)object);
    }

    public static boolean isNumber(Object object){
        try{
            Integer.parseInt(String.valueOf(object));
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isSign(char sign){
        return sign == '+' || sign == '-';
    }

    public static boolean menus(int num){
        return String.valueOf(num).contains("-");
    }

}
