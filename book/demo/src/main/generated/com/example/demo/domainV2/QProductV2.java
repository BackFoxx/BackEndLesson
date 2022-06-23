package com.example.demo.domainV2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductV2 is a Querydsl query type for ProductV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductV2 extends EntityPathBase<ProductV2> {

    private static final long serialVersionUID = -249105769L;

    public static final QProductV2 productV2 = new QProductV2("productV2");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public QProductV2(String variable) {
        super(ProductV2.class, forVariable(variable));
    }

    public QProductV2(Path<? extends ProductV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductV2(PathMetadata metadata) {
        super(ProductV2.class, metadata);
    }

}

