package com.zmz.shop.es.service;

import com.alibaba.fastjson.JSONObject;
import com.zmz.common.model.SkuEsModel;
import com.zmz.shop.es.config.ZshopEsConfiguration;
import com.zmz.shop.es.constant.EsConstant;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ElasticSearchService {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 上架商品
     */
    public void productUp(List<SkuEsModel> skuEsModelList) throws IOException {

        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel skuEsModel : skuEsModelList) {
            // 指定批量操作的 目标 索引
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(skuEsModel.getSkuId().toString());
            String modelString = JSONObject.toJSONString(skuEsModel);
            indexRequest.source(modelString, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = client.bulk(bulkRequest, ZshopEsConfiguration.COMMON_OPTIONS);
        log.info("上架商品共耗时 : {}", bulk.getTook());
        log.info("是否有商品上架失败 : {}", bulk.hasFailures());

    }


}
