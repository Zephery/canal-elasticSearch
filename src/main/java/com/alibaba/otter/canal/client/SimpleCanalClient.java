package com.alibaba.otter.canal.client;

import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.util.PropertiesUtil;

import java.net.InetSocketAddress;

/**
 * 单机模式的接收端
 * Created by SoleGlory on 2018/3/18.
 */
public class SimpleCanalClient extends AbstractCanalClient {

    public SimpleCanalClient(String destination){
        super(destination);
    }

    public static void main(String args[]) {
        // 根据ip，直接创建链接，无HA的功能
        String destination = PropertiesUtil.getDestination();
        String ip = AddressUtils.getHostIp();
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(ip, PropertiesUtil.getClientPort()),
            destination, "", "");

        final SimpleCanalClient simpleCanalClient = new SimpleCanalClient(destination);
        simpleCanalClient.setConnector(connector);
        simpleCanalClient.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                try {
                    logger.info("## stop the canal client");
                    simpleCanalClient.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping canal:", e);
                } finally {
                    logger.info("## canal client is down.");
                }
            }

        });
    }

}
