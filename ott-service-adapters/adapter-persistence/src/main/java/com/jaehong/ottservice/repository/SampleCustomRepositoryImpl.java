package com.jaehong.ottservice.repository;

import com.jaehong.ottservice.entity.QSampleEntity;
import com.jaehong.ottservice.entity.SampleEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SampleCustomRepositoryImpl implements SampleCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleEntity> findAll() {
        return jpaQueryFactory.selectFrom(QSampleEntity.sampleEntity)
                .fetch();
    }
}
