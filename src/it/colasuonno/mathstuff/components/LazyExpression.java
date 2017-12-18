package it.colasuonno.mathstuff.components;

import java.util.List;

public class LazyExpression {

    List<Grade> components;

    public LazyExpression(List<Grade> components) {
        this.components = components;
    }

    public List<Grade> getComponents() {
        return components;
    }

    public void setComponents(List<Grade> components) {
        this.components = components;
    }
}
