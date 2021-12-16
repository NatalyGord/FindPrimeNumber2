package com.example.primenumber.controllers;

import com.example.primenumber.models.Prime;
import com.example.primenumber.services.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PrimeController {
    @Autowired
    private PrimeService primeService;

    @GetMapping("/primes")   //получить все
    public List<Prime> getAllPrimes(){
        return primeService.getAllPrimes();
    }

    @GetMapping("/{requested_x}")   //создать
    public ObjResult createPrime(@PathVariable(value = "requested_x") int requested_x){
        if(primeService.getAllPrimes().isEmpty()){
            //расчет всех простых чисел от 2 до requested_x и запись их в БД
            primeService.findingPrime(requested_x, 2);
        }
        else {
            int bigP = primeService.findMaxPrime().get(0).getPrime_number();
            System.out.println("bigP: " + bigP);
            if(requested_x > bigP+1){
                //расчет всех простых чисел от bigP до requested_x и запись их в БД
                primeService.findingPrime(requested_x, bigP+1);
            }
        }
        //затем возврат нужного нам простого числа
        return new ObjResult(requested_x, primeService.findPrimeForRequestedX(requested_x).get(0).getPrime_number());
    }

    @GetMapping("/max")   //получить max
    public Prime getMaxPrimes(){
        return primeService.findMaxPrime().get(0);
    }
}

