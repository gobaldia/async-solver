package com.ort.os.solver.controller;

import com.ort.os.solver.domain.Equation;
import com.ort.os.solver.domain.PolynomialRoots;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SolveController implements Solve {
    @Override
    public ResponseEntity createRule(@RequestBody List<Equation> equations) {
        List<List<Double>> results = new ArrayList<>();
        for (int i = 0; i < equations.size(); i++) {
            Equation equation = equations.get(i);
            List<Double> coefficients = equation.getCoefficients();
            List<Double> roots = PolynomialRoots.getRoots(coefficients);
            results.add(roots);
        }
        return ResponseEntity.ok(results);
    }
}
