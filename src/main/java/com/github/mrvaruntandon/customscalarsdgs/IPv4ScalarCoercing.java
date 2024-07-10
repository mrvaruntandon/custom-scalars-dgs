package com.github.mrvaruntandon.customscalarsdgs;


import com.netflix.graphql.dgs.DgsScalar;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

@DgsScalar(name = "IPv4")
public class IPv4ScalarCoercing implements Coercing<String, String> {

    private static final String IPV4_PATTERN =
            "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";

    @Override
    public String serialize(Object dataFetcherResult) {
        if (dataFetcherResult instanceof String) {
            String ipAddress = (String) dataFetcherResult;
            if (ipAddress.matches(IPV4_PATTERN)) {
                return ipAddress;
            }
        }
        throw new CoercingSerializeException("Invalid IPv4 address");
    }

    @Override
    public String parseValue(Object input) {
        if (input instanceof String) {
            String ipAddress = (String) input;
            if (ipAddress.matches(IPV4_PATTERN)) {
                return ipAddress;
            }
        }
        throw new CoercingParseValueException("Invalid IPv4 address");
    }

    @Override
    public String parseLiteral(Object input) {
        if (input instanceof StringValue) {
            String ipAddress = ((StringValue) input).getValue();
            if (ipAddress.matches(IPV4_PATTERN)) {
                return ipAddress;
            }
        }
        throw new CoercingParseLiteralException("Invalid IPv4 address");
    }
}
