package com.jaehong.ottservice.sample;

import lombok.Getter;

@Getter
public class Sample {
    private final String name;

    public Sample(String name) {
        this.name = name;
    }
}
