package com.github.mrvaruntandon.customscalarsdgs;


import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

@DgsComponent
public class IPv4DataFetcher {

    @DgsQuery
    public String ip() {
        String ans = "127.0.0.1";
        return ans;
    }
}
