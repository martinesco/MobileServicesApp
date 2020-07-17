package project.repository;

import project.entity.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorStorage {

    private List<Operator> operators;

    public OperatorStorage() {
        this.setOperators();
    }

    private void setOperators() {
        this.operators = new ArrayList<>();

        operators.add(new Operator("Pastrashko","zlato0","pastrashko000@gmail.com"));
        operators.add(new Operator("Dragan","nodiggity","dtsankov@abv.bg"));
        operators.add(new Operator("Mustakan","qwerty1","mustakancho@gmail.com"));
    }

    public List<Operator> getOperators() {
        return operators;
    }
}
