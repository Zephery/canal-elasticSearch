package com.alibaba.otter.canal.adapter;

import com.alibaba.otter.canal.convert.AuthResourceConvert;
import com.alibaba.otter.canal.convert.QuesAuthResConvert;
import com.alibaba.otter.canal.convert.TypeAuthResConvert;
import com.alibaba.otter.canal.service.QuesAuthTemplate;
import com.alibaba.otter.canal.service.TypeAuthTemplate;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 数据变化对应es的适配器
 * Created by SoleGlory on 2018/3/19.
 */
public class MyIndexAdapter {

    /**
     * 有效的表名
     */
    protected final static String tableQuestion = "tk_question";
    protected final static String tableAuthRes = "tk_product_auth_resource";
    protected final static String tableQuestionType = "tk_question_type";

    /**
     * 更新索引，根据操作类型分发
     * @param entry
     */
    public static void UpdateIndex(CanalEntry.Entry entry){
        CanalEntry.RowChange rowChange = null;
        try {
            rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (Exception e) {
            throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
        }
        CanalEntry.EventType eventType = rowChange.getEventType();
        for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
            if (eventType == CanalEntry.EventType.DELETE) {

            } else if (eventType == CanalEntry.EventType.INSERT) {
                distribute(rowData, entry.getHeader().getTableName());
            } else if (eventType == CanalEntry.EventType.UPDATE) {
                distribute(rowData, entry.getHeader().getTableName());
            } else {

            }
        }
    }

    /**
     * 根据表名分发
     * @param rowData
     * @param tableName
     */
    private static void distribute(CanalEntry.RowData rowData, String tableName){
        List<CanalEntry.Column> columns = rowData.getAfterColumnsList();
        Map<String, Object> map = Maps.newHashMap();
        if(tableQuestion.equals(tableName)){
            for(CanalEntry.Column column : columns){
                QuesAuthResConvert.columnToMap(map, column);
            }
            QuesAuthTemplate.builkIndex(map);
        }
        else if(tableQuestionType.equals(tableName)){
            for(CanalEntry.Column column : columns){
                TypeAuthResConvert.columnToMap(map, column);
            }
            TypeAuthTemplate.builkIndex(map);
        }
        else if(tableAuthRes.equals(tableName)){
            for(CanalEntry.Column column : columns){
                AuthResourceConvert.columnToMap(map, column);
            }
            QuesAuthTemplate.builkIndex(map);
            TypeAuthTemplate.builkIndex(map);
        }
    }
}
