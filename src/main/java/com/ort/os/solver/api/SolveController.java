package com.ort.os.solver.api;

import com.ort.os.solver.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolveController implements Solve {

    @Override
    public ResponseEntity sendEquations(@RequestHeader String tid, @RequestBody List<Equation> equations) throws InterruptedException {
        CalculatorMemory instance = CalculatorMemory.getInstance();
        instance.insertEquations(Long.parseLong(tid), equations);

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer, tid);
        Consumer consumer = new Consumer(buffer, tid);
        producer.start();
        consumer.start();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getSolutions(@PathVariable String tid) throws InterruptedException {
        CalculatorMemory instance = CalculatorMemory.getInstance();
        List<Solution> solutions = instance.getSolutionsByTid(Long.parseLong(tid));
        return ResponseEntity.ok(solutions);
    }
}
