package com.chuzihang.lesson.designpatterns.singletonpattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class Test {

    public static void main(String[] args) {
        // 创建四个对象
        LoadBalancer balancer1,balancer2,balancer3,balancer4;
        balancer1 = LoadBalancer.getLoadBalancer();
        balancer2 = LoadBalancer.getLoadBalancer();
        balancer3 = LoadBalancer.getLoadBalancer();
        balancer4 = LoadBalancer.getLoadBalancer();

        // 判断服务器负载均衡器是否相同
        if(balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4){
            System.out.println("服务器负载均衡器具有唯一性");
        }

        // 增加服务器
        balancer1.addServer("Server1");
        balancer2.addServer("Server2");
        balancer3.addServer("Server3");
        balancer4.addServer("Server4");

        // 模拟客户端请求的分发
        for (int i = 0;i<10;i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器："+server);
        }

    }
}
