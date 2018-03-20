package com.alibaba.otter.canal.service;

import com.alibaba.otter.canal.client.ElasticClient;
import com.alibaba.otter.canal.util.ParaseUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.util.List;
import java.util.Map;

/**
 * QuesAuth索引具体操作
 * Created by SoleGlory on 2018/3/19.
 */
public class QuesAuthTemplate {

    //索引库名
    static String index = "my_index";
    //类型名称
    static String type = "quesAuthResource";

    public static void builkIndex(Map<String, Object> map) {
        // 批量创建索引
        BulkRequestBuilder bulkRequest = ElasticClient.client.prepareBulk();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        StringBuilder id = new StringBuilder();
        //如果是试题表变动
        if (map.get("quesId") != null && StringUtils.isNotBlank(map.get("quesId").toString())) {
            boolQueryBuilder.should(QueryBuilders.termQuery("quesId", map.get("quesId").toString()));
            boolQueryBuilder.should(QueryBuilders.termQuery("arResourceId", map.get("quesId").toString()));
            id = id.append(map.get("quesId").toString()).append(ParaseUtil.SEP).append("null");
        }
        //如果是资源表变动
        if (map.get("arId") != null && StringUtils.isNotBlank(map.get("arId").toString())) {
            boolQueryBuilder.should(QueryBuilders.termQuery("arId", map.get("arId").toString()));
            //如果资源类型是试题（resourceType--> 1）
            if (map.get("arResourceType") != null && ParaseUtil.AR_RESOURCE_TYPE_QUES.equals(map.get("arResourceType"))) {
                if (map.get("arResourceId") != null && StringUtils.isNotBlank(map.get("arResourceId").toString())) {
                    boolQueryBuilder.should(QueryBuilders.termQuery("quesId", map.get("arResourceId").toString()));
                }
                id = id.append("null").append(ParaseUtil.SEP).append(map.get("arId").toString());
            }
        }
        //获取es里对应资源
        SearchResponse response = ElasticClient.client.prepareSearch(index).setTypes(type).setQuery(boolQueryBuilder)
                .execute().actionGet();
        SearchHits resultHits = response.getHits();
        List<String> indexIds = Lists.newArrayList();
        //如果es里有
        if (resultHits.getTotalHits() > 0) {
            for (SearchHit hit : resultHits) {
                Map<String, Object> hitMap = hit.getSourceAsMap();
                hitMap.putAll(map);
                id.delete(0, id.length());
                id = id.append(hitMap.get("quesId")).append(ParaseUtil.SEP).append(hitMap.get("arId"));
                hitMap.put("id", id);
                //将现有资源更新
                bulkRequest.add(ElasticClient.client.prepareIndex(index, type, id.toString()).setSource(hitMap));
                if (hit.getId().contains("null")) {
                    //如果存在不完全关联数据，加入集合，待删除
                    indexIds.add(hit.getId());
                }
            }
        } else {
            //如果es里没有，则新建
            bulkRequest.add(ElasticClient.client.prepareIndex(index, type, id.toString()).setSource(map));
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            System.out.println("批量创建索引错误！");
        } else {
            //如果更新成功，就将对应的不完全数据删除
            for (String indexId : indexIds) {
                try {
                    ElasticClient.client.prepareDelete(index, type, indexId).execute().actionGet();
                } catch (Exception e) {
                    System.out.printf("删除临时索引%d失败", indexId);
                }
            }
        }
        System.out.println("批量创建索引成功");
    }

}
