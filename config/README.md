# 配置中心

---

### 启动config-server

配置文件 application.properties

```
server.port=8002
spring.cloud.config.server.default-application-name=config-server

\# 配置git仓库地址
spring.cloud.config.server.git.uri=https://github.com/aalansehaiyang/SpringCloudConfig.git
\# 配置仓库路径
spring.cloud.config.server.git.search-paths=/config-repo
\# 配置仓库的分支
spring.cloud.config.label=master
```


验证是否启动成功：

http://localhost:8002/config-client-1/test/master

```
{
  "name": "config-client-1",
  "profiles": [
    "test"
  ],
  "label": "master",
  "version": "bd5dfa395cd23b3f0daaa5805564fd8327e28fc9",
  "propertySources": [
    {
      "name": "https://github.com/aalansehaiyang/spring-cloud-example/config/config-repo/config-client-1-test.properties",
      "source": {
        "diamond.v": "project:config-client-1,value=1"
      }
    }
  ]
}
```

URL与配置文件的映射关系如下：

```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```
上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。

我们可以尝试构造不同的url来访问不同的配置内容，比如：要访问master分支，config-client-1应用的test环境，可以通过这个url：http://localhost:8002/config-client-1/test/master

### 启动config-client-1


配置文件bootstrap.properties

```
# 和git里的文件名对应
spring.application.name=config-client-1
server.port=8010
# dev 开发环境配置文件 |  test 测试环境  |  #pro 正式环境
# 和git里的文件名对应
spring.cloud.config.profile=test
# 配置服务中心的地址
spring.cloud.config.uri=http://localhost:8002/
# 远程仓库的分支名
spring.cloud.config.label=master
```


访问：http://localhost:8010/v

返回：

```
project:config-client-1,value=1
```

### 启动config-client-2

配置文件bootstrap.properties

```
# 和git里的文件名对应
spring.application.name=config-client-2
server.port=8020
spring.cloud.config.profile=test
# 配置服务中心的地址
spring.cloud.config.uri=http://localhost:8002/
# 远程仓库的分支名
spring.cloud.config.label=master
```

访问：http://localhost:8020/v

返回：

```
project:config-client-2,value=3
```
