1.环境准备,先启动kafaka:./kafka.sh
```
# !/bin/bash
echo "zookeeper start !"
/usr/local/zookeeper-3.4.11/bin/zkServer.sh start
echo "kafka start !"
/usr/local/kafka_2.12-2.0.0/bin/kafka-server-start.sh  /usr/local/kafka_2.12-2.0.0/config/server.properties &
```
2.启动eureka-server,启动三个节点，配置分别是peer1、peer2、peer3,如下图所示:

![eureka-server启动配置](http://gnehcgnaw.oss-cn-hongkong.aliyuncs.com/Xnip2018-10-30_10-06-27.png)

3.启动config-server,

4.依次启动provider中的项目，目前只有provider-user-service,为实现高可用，配置两个端口实例：分别为6061、6062，如下图所示：

![provider启动配置](http://gnehcgnaw.oss-cn-hongkong.aliyuncs.com/Xnip2018-10-30_10-12-38.png)
5.依次启动consumer中的项目，目前只有consumer-feign-with-hystrix

6.启动getway-zuul-proxy
* 测试端口1：http://localhost:2222/consumer-services/user/1
* 测试端口2：http://localhost:2222/consumer-services/user/testRoundRobinRule（观察会发现userId是轮询的）
* 测试端口3：http://localhost:2222/user-services/user/testRoundRobinRule
* 测试端口4：http://localhost:2222/user-services/user/1

7.启动zipkin-server

* 访问地址：http://localhost:3333

8.启动hystrix-turbine

* 访问地址：http://localhost:8888/hystrix.stream ，然后在输入框中填写：http://localhost:8888/trubine.stream

9.在项目运行的时候会产生一个build文件夹和configs文件夹，build文件是项目运行的日志信息，生产到统一个文件夹并且以json的形式存储是为了方便日后使用ELK，也就是说只要你使用了ELK只需要将这个文件夹导入就能实现日志的统一管理；而configs是拉取的配置文件。


