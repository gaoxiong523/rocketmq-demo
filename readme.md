docker 部署启动本地RocketMQ 环境
```html
https://github.com/gaoxiong523/docker-rocketmq
```
```text
重要的事情说三遍
重要的事情说三遍
重要的事情说三遍
本地开发中的时候需要注意,要把broker的配置中的IP改为宿主机的IP
docker exec -it containerID /bin/bash
进入宿主机,
/etc/rocketmq/broker.conf 
#brokerIP1=192.168.0.253 
去掉# 改为宿主机IP
如果线上项目部署在docker容器中 ,则可以使用同一个network 进行通信,不用宿主机IP就行了

```
```text
解决docker启动过程中的 问题 
java.io.FileNotFoundException: /etc/rocketmq/broker.conf (Permission denied)
rmqbroker     | 	at java.io.FileInputStream.open0(Native Method)
rmqbroker     | 	at java.io.FileInputStream.open(FileInputStream.java:195)
rmqbroker     | 	at java.io.FileInputStream.<init>(FileInputStream.java:138)
rmqbroker     | 	at java.io.FileInputStream.<init>(FileInputStream.java:93)
rmqbroker     | 	at org.apache.rocketmq.broker.BrokerStartup.createBrokerController(BrokerStartup.java:128)
rmqbroker     | 	at org.apache.rocketmq.broker.BrokerStartup.main(BrokerStartup.java:58)

修改 docker-compose.yml中的 配置
添加
 privileged: true  
 给予特权 

```