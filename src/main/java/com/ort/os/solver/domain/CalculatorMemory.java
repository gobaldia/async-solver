package com.ort.os.solver.domain;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorMemory {

    private static HashMap<Long, List<Equation>> equations;
    private static HashMap<Long, List<Solution>> solutions;

    private static CalculatorMemory instance = new CalculatorMemory();

    public static CalculatorMemory getInstance() {
        return instance;
    }

    private CalculatorMemory() {
        this.equations = new HashMap<>();
        this.solutions = new HashMap<>();
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
//        Thread.sleep(5000);
        this.equations.put(tid, equations);
    }

    public void insertSolution(Long tid, Solution solution) throws InterruptedException {
//        Thread.sleep(1000);
        if (this.solutions.get(tid) == null) {
            this.solutions.put(tid, new ArrayList<>());
        }
//        solutions.add(solution);
        this.solutions.get(tid).add(solution);
    }
}
