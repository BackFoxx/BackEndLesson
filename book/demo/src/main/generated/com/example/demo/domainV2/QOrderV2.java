package com.example.demo.domainV2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderV2 is a Querydsl query type for OrderV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderV2 extends EntityPathBase<OrderV2> {

    private static final long serialVersionUID = 715510838L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderV2 orderV2 = new QOrderV2("orderV2");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberV2 member;

    public final NumberPath<Integer> orderAmount = createNumber("orderAmount", Integer.class);

    public final QProductV2 product;

    public QOrderV2(String variable) {
        this(OrderV2.class, forVariable(variable), INITS);
    }

    public QOrderV2(Path<? extends OrderV2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderV2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderV2(PathMetadata metadata, PathInits inits) {
        this(OrderV2.class, metadata, inits);
    }

    public QOrderV2(Class<? extends OrderV2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMemberV2(forProperty("member")) : null;
        this.product = inits.isInitialized("product") ? new QProductV2(forProperty("product")) : null;
    }

}

