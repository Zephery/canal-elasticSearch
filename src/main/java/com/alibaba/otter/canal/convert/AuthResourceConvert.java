package com.alibaba.otter.canal.convert;

import com.alibaba.otter.canal.util.ParaseUtil;
import com.alibaba.otter.canal.protocol.CanalEntry;

import java.util.Map;

/**
 * Created by SoleGlory on 2018/3/20.
 */
public class AuthResourceConvert {

    /**
     * 将authResource转化为map
     * @param map
     * @param column
     */
    public static void columnToMap(Map<String, Object> map, CanalEntry.Column column){
        if("id".equals(column.getName().toLowerCase())){
            map.put("arId", column.getValue());
        }
        if("del_flag".equals(column.getName().toLowerCase())){
            map.put("delFlag", column.getValue());
        }
        if("auth_begin_time".equals(column.getName().toLowerCase())){
            map.put("arAuthBeginTime", ParaseUtil.timestampRule(column.getValue()));
        }
        if("auth_end_time".equals(column.getName().toLowerCase())){
            map.put("arAuthEndTime", ParaseUtil.timestampRule(column.getValue()));
        }
        if("resource_type".equals(column.getName().toLowerCase())){
            map.put("arResourceType", column.getValue());
        }
        if("resource_id".equals(column.getName().toLowerCase())){
            map.put("arResourceId", column.getValue());
        }
        if("product_id".equals(column.getName().toLowerCase())){
            map.put("arProductId", column.getValue());
        }
        if("office_id".equals(column.getName().toLowerCase())){
            map.put("arOfficeId", column.getValue());
        }
        if("status".equals(column.getName().toLowerCase())){
            map.put("arStatus", column.getValue());
        }
    }
}
