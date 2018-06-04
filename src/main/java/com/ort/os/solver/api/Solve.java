package com.ort.os.solver.api;

import com.ort.os.solver.domain.Equation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Solve {

    @RequestMapping(value = "/solve",
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity sendEquations(@RequestHeader String tid, @RequestBody List<Equation> equations) throws InterruptedException;

    @RequestMapping(value = "/solutions/{tid}",
        produces = {"application/json"},
    method = RequestMethod.GET)
    ResponseEntity getSolutions(@PathVariable String tid) throws InterruptedException;
}
