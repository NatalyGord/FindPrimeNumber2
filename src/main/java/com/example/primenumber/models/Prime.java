package com.example.primenumber.models;

import javax.persistence.*;

@Entity
@Table(name = "primes")
public class Prime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "prime_number", nullable = false)
    private int prime_number;

    public Prime(){
    }
    public Prime(int prime_number) {
        this.prime_number = prime_number;
    }
    public Long getId() {
        return Id;
    }
    public int getPrime_number() {
        return prime_number;
    }

}
