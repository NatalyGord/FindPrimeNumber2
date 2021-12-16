package com.example.primenumber.controllers;

public class ObjResult {
    int requested_x;
    int prime_number;

    public ObjResult(int requested_x, int prime_number) {
        this.requested_x = requested_x;
        this.prime_number = prime_number;
    }

    public int getRequested_x() {
        return requested_x;
    }

    public void setRequested_x(int requested_x) {
        this.requested_x = requested_x;
    }

    public int getPrime_number() {
        return prime_number;
    }

    public void setPrime_number(int prime_number) {
        this.prime_number = prime_number;
    }
}