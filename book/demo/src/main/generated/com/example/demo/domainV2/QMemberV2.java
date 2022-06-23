package com.example.demo.domainV2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberV2 is a Querydsl query type for MemberV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberV2 extends EntityPathBase<MemberV2> {

    private static final long serialVersionUID = -1177734550L;

    public static final QMemberV2 memberV2 = new QMemberV2("memberV2");

    public final StringPath id = createString("id");

    public final ListPath<OrderV2, QOrderV2> orders = this.<OrderV2, QOrderV2>createList("orders", OrderV2.class, QOrderV2.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QMemberV2(String variable) {
        super(MemberV2.class, forVariable(variable));
    }

    public QMemberV2(Path<? extends MemberV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberV2(PathMetadata metadata) {
        super(MemberV2.class, metadata);
    }

}

