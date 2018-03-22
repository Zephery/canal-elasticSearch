package com.alibaba.otter.canal.client;

import com.alibaba.otter.canal.util.PropertiesUtil;

/**
 * 集群模式的接收端
 * Created by SoleGlory on 2018/3/18.
 */
public class ClusterCanalClient extends AbstractCanalClient {

    public ClusterCanalClient(String destination){
        super(destination);
    }

    public static void main(String args[]) {
        String destination = PropertiesUtil.getDestination();

        // 基于固定canal server的地址，建立链接，其中一台server发生crash，可以支持failover
        // CanalConnector connector = CanalConnectors.newClusterConnector(
        // Arrays.asList(new InetSocketAddress(
        // AddressUtils.getHostIp(),
        // 11111)),
        // "stability_test", "", "");

        // 基于zookeeper动态获取canal server的地址，建立链接，其中一台server发生crash，可以支持failover
        CanalConnector connector = CanalConnectors.newClusterConnector(PropertiesUtil.getClusterAddr(), destination, "", "");

        final ClusterCanalClient clusterCanalClient = new ClusterCanalClient(destination);
        clusterCanalClient.setConnector(connector);
        clusterCanalClient.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                try {
                    logger.info("## stop the canal client");
                    clusterCanalClient.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping canal:", e);
                } finally {
                    logger.info("## canal client is down.");
                }
            }

        });
    }
}
