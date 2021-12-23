package com.zmz.shop.es;

import com.alibaba.fastjson.JSONObject;
import com.zmz.shop.es.model.BankAccount;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ZshopEsApplicationTests {

    @Autowired
    private RestHighLevelClient client;


    @Test
    public void contextLoads() {
        System.err.println(client);
    }

    /**
     * 查询测试
     */
    @Test
    public void queryData() throws IOException {
        // 新建searchRequest
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.aggregation(AggregationBuilders.terms("age_group").field("age"));
        searchRequest.source(searchSourceBuilder);
        searchRequest.indices("bank");
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        System.err.println(searchResponse.getHits().totalHits);
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            BankAccount bankAccount = JSONObject.parseObject(sourceAsString, BankAccount.class);
            System.err.println("bankAccount :" + bankAccount);
        }
        Aggregations aggregations = searchResponse.getAggregations();
        Terms byCompanyAggregation = aggregations.get("age_group");
        Terms.Bucket bucketByKey = byCompanyAggregation.getBucketByKey("39");
        long docCount = bucketByKey.getDocCount();
        System.err.println(docCount);

    }

    /**
     * 存储index测试
     */
    @Test
    public void indexData() {


    }

}
