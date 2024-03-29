package com.calculette.controllers;

import com.calculette.models.Numbers;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin
public class CalculateRessource {

    @PostMapping("/add")
    public BigDecimal add(@RequestBody Numbers numbers) {
        return numbers.getNumber1().add(numbers.getNumber2()) ;
    }

    @PostMapping("/subtract")
    public BigDecimal subtract(@RequestBody Numbers numbers) {
        return numbers.getNumber1().subtract(numbers.getNumber2());
    }

    @PostMapping("/multiply")
    public BigDecimal multiply(@RequestBody Numbers numbers) {
        return numbers.getNumber1().multiply(numbers.getNumber2());
    }

    @PostMapping("/divide")
    public BigDecimal divide(@RequestBody Numbers numbers) {
        if (numbers.getNumber2().equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return numbers.getNumber1().divide(numbers.getNumber2());
    }
}
