package com.jaehong.ottservice.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class MutableBaseEntity extends BaseEntity {
    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    private String updatedBy;
}
