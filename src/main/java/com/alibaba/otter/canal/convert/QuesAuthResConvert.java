package com.alibaba.otter.canal.convert;

import com.alibaba.otter.canal.protocol.CanalEntry;

import java.util.Map;

/**
 * Created by SoleGlory on 2018/3/20.
 */
public class QuesAuthResConvert {

    /**
     * 将questionAuth转化成map
     * @param map
     * @param column
     */
    public static void columnToMap(Map<String, Object> map, CanalEntry.Column column){
        if("id".equals(column.getName().toLowerCase())){
            map.put("quesId", column.getValue());
        }
        if("question_syllabus_ids".equals(column.getName().toLowerCase())){
            map.put("questionSyllabusIds", column.getValue());
        }
        if("is_group".equals(column.getName().toLowerCase())){
            map.put("isGroup", column.getValue());
        }
        if("type_id".equals(column.getName().toLowerCase())){
            map.put("typeId", column.getValue());
        }
        if("model_id".equals(column.getName().toLowerCase())){
            map.put("modelId", column.getValue());
        }
        if("inuse_difficulty".equals(column.getName().toLowerCase())){
            map.put("inuseDifficulty", column.getValue());
        }
        if("forecast_difficulty".equals(column.getName().toLowerCase())){
            map.put("forecastDifficulty", column.getValue());
        }
        if("is_use".equals(column.getName().toLowerCase())){
            map.put("isUse", column.getValue());
        }
        if("del_flag".equals(column.getName().toLowerCase())){
            map.put("delFlag", column.getValue());
        }
        if("subject_id".equals(column.getName().toLowerCase())){
            map.put("subjectId", column.getValue());
        }
        if("question_kinds".equals(column.getName().toLowerCase())){
            map.put("questionkinds", column.getValue());
        }
        else if("status".equals(column.getName().toLowerCase()) ||
                "requirement".equals(column.getName().toLowerCase()) ||
                "practice".equals(column.getName().toLowerCase()) ||
                "pid".equals(column.getName().toLowerCase()) ||
                "degree".equals(column.getName().toLowerCase()) ||
                "answer".equals(column.getName().toLowerCase()) ||
                "type".equals(column.getName().toLowerCase()) ||
                "typeids".equals(column.getName().toLowerCase()) ||
                "ptypeids".equals(column.getName().toLowerCase()) ||
                "choice1".equals(column.getName().toLowerCase()) ||
                "choice2".equals(column.getName().toLowerCase()) ||
                "choice3".equals(column.getName().toLowerCase()) ||
                "choice4".equals(column.getName().toLowerCase()) ||
                "choice5".equals(column.getName().toLowerCase()) ||
                "choice6".equals(column.getName().toLowerCase()) ||
                "choice7".equals(column.getName().toLowerCase()) ||
                "choice8".equals(column.getName().toLowerCase()) ||
                "name".equals(column.getName().toLowerCase())
                ){
            map.put(column.getName().toLowerCase(), column.getValue());
        }
    }
}
