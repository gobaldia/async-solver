package com.ort.os.solver.domain;

import org.springframework.beans.factory.annotation.Value;

public class BufferX {

    private int next_to_put = 0;
    private int next_to_get = 0;
    private int count = 0;

    //@Value("${buffer.size}")
    private int bufferSize = 10;

    private Equation[] buffer;

    public BufferX(int bufferSize) {
        buffer = new Equation[bufferSize];
    }

    public synchronized void put(int i) throws InterruptedException {
        if (count < bufferSize) {
//            buffer
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
    }

    /*private int contents;
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
    }*/
}
