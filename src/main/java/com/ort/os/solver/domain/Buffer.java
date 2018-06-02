package com.ort.os.solver.domain;

public class Buffer {
    private Equation content;
    private boolean available = false;

    public Buffer() {
    }

    public synchronized Equation get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        available = false;
        notify();
        return content;
    }

    public synchronized void put(Equation valor) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        content = valor;
        available = true;
        notify();
    }
}