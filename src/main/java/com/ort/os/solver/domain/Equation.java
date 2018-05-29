package com.ort.os.solver.domain;

import java.util.List;

public class Equation {
    private List<Double> coefficients;

    public Equation(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public Equation() {
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "coefficients=" + coefficients +
                '}';
    }
}
