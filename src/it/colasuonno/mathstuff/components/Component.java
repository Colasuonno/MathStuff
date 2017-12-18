package it.colasuonno.mathstuff.components;

public class Component {

    private char sign;
    private int num;
    private String letters;
    private int index;

    public Component(char sign, int num, String letters, int index) {
        this.sign = sign;
        this.num = num;
        this.letters = letters;
        this.index = index;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
