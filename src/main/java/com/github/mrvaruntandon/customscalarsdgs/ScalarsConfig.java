package com.github.mrvaruntandon.customscalarsdgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;

@DgsComponent
public class ScalarsConfig {

    @DgsRuntimeWiring
    public RuntimeWiring.Builder addScalar(RuntimeWiring.Builder builder) {
        return builder.scalar(GraphQLScalarType.newScalar()
                .name("IPv4")
                .description("A custom scalar that handles IPv4 addresses")
                .coercing(new IPv4ScalarCoercing())
                .build());
    }
}
