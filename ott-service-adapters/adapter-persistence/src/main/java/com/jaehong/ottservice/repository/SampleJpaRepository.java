package com.jaehong.ottservice.repository;

import com.jaehong.ottservice.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<SampleEntity, String> {
}
