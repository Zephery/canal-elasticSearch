package com.alibaba.otter.canal.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by SoleGlory on 2018/3/21.
 */
public class PropertiesUtil {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("conf/client/client.properties");

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null){
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }

    /**
     * 获取数据库类型
     */
    public static String getDestination() {
        return getConfig("canal.client.destination");
    }

    /**
     * 获取canal
     */
    public static int getClientPort() {
        int port = 31256;
        try{
            port = Integer.valueOf(getConfig("canal.client.port"));
        }catch (Exception e){
            port = 31256;
        }
        return port;
    }

    /**
     * 获取es实例名
     */
    public static String getESName() {
        return getConfig("elasticSearch.cluster.name");
    }

    /**
     * 获取es ip
     */
    public static String getESIp() {
        return getConfig("elasticSearch.cluster.ip");
    }

    /**
     * 获取es端口号
     */
    public static int getESPort() {
        int port = 31256;
        try{
            port = Integer.valueOf(getConfig("elasticSearch.cluster.port"));
        }catch (Exception e){
            port = 31256;
        }
        return port;
    }

    /**
     * 获取集群地址
     */
    public static String getClusterAddr() {
        return getConfig("canal.cluster.client.addr");
    }

}
