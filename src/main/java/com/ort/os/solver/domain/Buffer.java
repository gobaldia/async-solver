package com.ort.os.solver.domain;

public class Buffer {

    private int contents;
    private boolean empty = true;

    public synchronized void put(int i) throws InterruptedException {
        while (empty == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        contents = i;
        empty = false;
        notify();
    }

    public synchronized int get() throws InterruptedException {
        while (empty == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        empty = true;
        notify();
        int val = contents;
        return val;
    }
}
