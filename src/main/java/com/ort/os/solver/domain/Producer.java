package com.ort.os.solver.domain;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {

    private Buffer buffer;
    private String tid;

    public Producer(Buffer buffer, String tid) {
        this.buffer = buffer;
        this.tid = tid;
    }

    public void run() {
        CalculatorMemory calculatorMemory = CalculatorMemory.getInstance();
        List<Equation> equations = calculatorMemory.getEquationsByTid(Long.parseLong(this.tid));
        for (Equation e : equations) {
            buffer.put(e);
            System.out.println("Producte: " + e);
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
