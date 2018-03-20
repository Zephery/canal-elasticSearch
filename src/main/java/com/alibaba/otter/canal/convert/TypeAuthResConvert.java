package com.alibaba.otter.canal.convert;

import com.alibaba.otter.canal.protocol.CanalEntry;

import java.util.Map;

/**
 * Created by SoleGlory on 2018/3/20.
 */
public class TypeAuthResConvert {

    /**
     * 将typeAuth转化成map
     * @param map
     * @param column
     */
    public static void columnToMap(Map<String, Object> map, CanalEntry.Column column){
        if("id".equals(column.getName().toLowerCase())){
            map.put("typeId", column.getValue());
        }
        if("del_flag".equals(column.getName().toLowerCase())){
            map.put("delFlag", column.getValue());
        }
        if("type_level".equals(column.getName().toLowerCase())){
            map.put("typeLevel", column.getValue());
        }
        else if("name".equals(column.getName().toLowerCase()) ||
                "pid".equals(column.getName().toLowerCase())
                ){
            map.put(column.getName().toLowerCase(), column.getValue());
        }
    }
}
