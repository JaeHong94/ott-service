package com.jaehong.ottservice.audit;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMutableBaseEntity is a Querydsl query type for MutableBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QMutableBaseEntity extends EntityPathBase<MutableBaseEntity> {

    private static final long serialVersionUID = 1459277196L;

    public static final QMutableBaseEntity mutableBaseEntity = new QMutableBaseEntity("mutableBaseEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QMutableBaseEntity(String variable) {
        super(MutableBaseEntity.class, forVariable(variable));
    }

    public QMutableBaseEntity(Path<? extends MutableBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMutableBaseEntity(PathMetadata metadata) {
        super(MutableBaseEntity.class, metadata);
    }

}

