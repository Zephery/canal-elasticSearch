package com.alibaba.otter.canal.client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * es连接的工具类
 * Created by SoleGlory on 2018/3/18.
 */
public class ElasticClient {

    private final static String clusterName = "elasticsearch";

    private final static String clusterIP = "127.0.0.1";

    private final static int clusterPort = 9300;

    // 设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，把集群中其它机器的ip地址加到客户端中，
    private static Settings settings = Settings.builder().put("cluster.name", clusterName) //设置ES实例的名称
            .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
            .build();

    public final static TransportClient client = init();

    // 取得实例
    @SuppressWarnings("resource")
    private static synchronized TransportClient init() {
        InetAddress addr;
        try {
            addr = InetAddress.getByName(clusterIP);
            InetSocketAddress ip = new InetSocketAddress(addr, clusterPort);
            TransportAddress transportAddress = new InetSocketTransportAddress(ip);
            TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(transportAddress);
            return client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;

    }
}
