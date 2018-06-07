package com.ort.os.solver.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorMemory {

    private static HashMap<Long, List<Equation>> equations;
    private static HashMap<Long, List<Solution>> solutions;

    private static CalculatorMemory instance = new CalculatorMemory();

    private CalculatorMemory() {
        this.equations = new HashMap<>();
        this.solutions = new HashMap<>();
    }

    public static CalculatorMemory getInstance() {
        return instance;
    }

    public HashMap<Long, List<Equation>> getEquations() {
        return this.equations;
    }

    public HashMap<Long, List<Solution>> getSolutions() {
        return this.solutions;
    }

    public List<Solution> getSolutionsByTid(Long tid) {
        HashMap<Long, List<Solution>> solutions = this.getSolutions();

        return solutions.get(tid);
    }

    public List<Equation> getEquationsByTid(Long tid) {
        return (List) this.getEquations().get(tid);
    }

    public void insertEquations(Long tid, List<Equation> equations) throws InterruptedException {
        this.equations.put(tid, equations);
    }

    public void insertSolution(Long tid, Solution solution) throws InterruptedException {
        if (this.solutions.get(tid) == null) {
            this.solutions.put(tid, new ArrayList<>());
        }
        this.solutions.get(tid).add(solution);
    }
}
