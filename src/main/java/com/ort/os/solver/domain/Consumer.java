package com.ort.os.solver.domain;

import java.util.HashMap;
import java.util.List;

public class Consumer extends Thread {

    private Buffer buffer;
    private String tid;

    public Consumer(Buffer buffer, String tid) {
        this.buffer=buffer;
        this.tid = tid;
    }
    public void run(){
        Equation equation;
        CalculatorMemory calculatorMemory = CalculatorMemory.getInstance();
        while (true) {
            equation=buffer.get();
            List<Double> coefficients = equation.getCoefficients();
            List<Double> roots = PolynomialRoots.getRoots(coefficients);
            Solution s = new Solution(roots);
            try {
                calculatorMemory.insertSolution(Long.parseLong(this.tid), s);
                HashMap<Long, List<Solution>> solutions = calculatorMemory.getSolutions();
                System.out.println("Inserta: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(i+ " Consumidor: "+equation);
            try{
                sleep(1000);
            }catch (InterruptedException e) { }
        }
    }
}