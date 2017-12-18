package it.colasuonno.mathstuff.components;

public class Grade {

    private Type type;
    private int index;
    private Object contenuto;

    public Grade(Type type, int index, Object contenuto) {
        this.type = type;
        this.index = index;
        this.contenuto = contenuto;
    }

    public Object getContenuto() {
        return contenuto;
    }

    public void setContenuto(Object contenuto) {
        this.contenuto = contenuto;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
