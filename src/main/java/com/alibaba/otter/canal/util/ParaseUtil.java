package com.alibaba.otter.canal.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 * Created by SoleGlory on 2018/3/19.
 */
public class ParaseUtil {

    //分隔符
    public final static String SEP = "||";

    //资源类型  试题
    public final static String AR_RESOURCE_TYPE_QUES = "1";

    //资源类型  学科目录
    public final static String AR_RESOURCE_TYPE_TYPE = "3";

    /**
     * 将string转化成Integer
     * @param str
     * @return
     */
    public static Integer numberRule(String str){
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        Integer result = 0;
        try {
            result = Integer.valueOf(str);
        }catch (Exception e){
        }
        return result;
    }

    /**
     * 将string转化成Double
     * @param str
     * @return
     */
    public static Double doubleRule(String str){
        if(StringUtils.isEmpty(str)){
            return Double.valueOf(0);
        }
        Double result = Double.valueOf(0);
        try {
            result = Double.valueOf(str);
        }catch (Exception e){
        }
        return result;
    }

    /**
     * 将timestamp类型的string转化成date
     * @param str
     * @return
     */
    public static Date timestampRule(String str){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = sf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
