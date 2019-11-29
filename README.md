## dubbo以及监控启动命令
mvn --projects dubbo-admin-backend spring-boot:run
## 前端react启动命令
tyarn start
##解决mysql5.7.5数据库分组问题
set @@global.sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
nginx.exe -s stop
nginx.exe
##docker搭建redis集群
docker create --name redis-node01 --net host -v /data/redis-data/node01:/data redis:5.0.2 --cluster-enabled yes --cluster-config-file nodes-node-01.conf --port 6379

docker create --name redis-node02 --net host -v /data/redis-data/node02:/data redis:5.0.2 --cluster-enabled yes --cluster-config-file nodes-node-02.conf --port 6380

docker create --name redis-node03 --net host -v /data/redis-data/node03:/data redis:5.0.2 --cluster-enabled yes --cluster-config-file nodes-node-03.conf --port 6381
##启动容器
docker start redis-node01 redis-node02 redis-node03
##进入redis-node01容器进行操作
docker exec -it redis-node01 /bin/bash
##192.168.43.131是主机的ip地址
redis-cli --cluster create 192.168.43.131:6379 192.168.43.131:6380 192.168.43.131:6381 --cluster-replicas 0



