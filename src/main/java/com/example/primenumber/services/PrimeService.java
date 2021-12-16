package com.example.primenumber.services;

import com.example.primenumber.models.Prime;
import com.example.primenumber.repository.PrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimeService {
    @Autowired
    private final PrimeRepository primeRepository;

    public PrimeService(PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public List<Prime> getAllPrimes() {  //получить все
        return primeRepository.findAll();
    }

    public Prime createPrime(int x) {      //Создать
        Prime prime = new Prime(x);
        return primeRepository.save(prime);
    }

    public List<Prime> findMaxPrime() {  //найти Max в БД
        return primeRepository.findMaxPrime();
    }

    public List<Prime> findPrimeForRequestedX(int requested_x) {   //найти простое число для запрошенного(requested_x)
        return primeRepository.findPrimeForRequestedX(requested_x);
    }

    public void findingPrime(int requested_x, int minPrimeNum){
        if(requested_x <= 2) {
            System.out.println("Число не может быть меньше 3");;
        }
        else {
            int num = minPrimeNum;
            boolean result = false;
            for (int i = minPrimeNum; i < requested_x; i++) {
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }
                if(num == 2){
                    primeRepository.save(new Prime(num));
                }
                if(result){
                    primeRepository.save(new Prime(num));
                }
                num++;
            }
        }
    }
}
