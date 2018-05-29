package com.ort.os.solver.controller;

import com.ort.os.solver.domain.Equation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface Solve {

    @RequestMapping(value = "/solve",
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity createRule(@RequestBody List<Equation> equations);
}
