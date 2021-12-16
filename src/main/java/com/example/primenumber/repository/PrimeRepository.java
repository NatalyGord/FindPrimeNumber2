package com.example.primenumber.repository;

import com.example.primenumber.models.Prime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeRepository extends JpaRepository<Prime, Long> {

    @Query(value = "SELECT * FROM primes", nativeQuery = true)
    List<Prime> findAll();

    //найти большее число в БД
    @Query(value = "SELECT * FROM primes ORDER BY prime_number DESC LIMIT 1", nativeQuery = true)
    List<Prime> findMaxPrime();

    //найти простое число для запрошенного(requested_x)
    @Query(value = "SELECT * FROM primes WHERE prime_number < ? ORDER BY prime_number DESC LIMIT 1", nativeQuery = true)
    List<Prime> findPrimeForRequestedX(int requested_x);
}
