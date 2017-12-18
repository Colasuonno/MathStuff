package it.colasuonno.mathstuff.components;

import java.util.List;

public class Expression {

    List<Component> components;

    public Expression(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
