package com.ort.os.solver.domain;

import java.util.List;

public class Solution {

    private List<Double> roots;

    public Solution(List<Double> roots) {
        this.roots = roots;
    }

    public Solution() {
    }

    public List<Double> getRoots() {
        return roots;
    }

    public void setRoots(List<Double> roots) {
        this.roots = roots;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "roots=" + roots +
                '}';
    }
}
