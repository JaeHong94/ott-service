package com.jaehong.ottservice.repository;

import com.jaehong.ottservice.entity.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAllAbc();
}
