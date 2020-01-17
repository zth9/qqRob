# qqRob
基于picq，coolq-http-api，酷Q的一个简单的qq聊天机器人
## Main类为机器人启动类,会在SpringBoot启动时启动
在Main类中可以配置端口
## RobListener中添加监听方法,调用ArtificialFool类中的具体实现
## KeyWord类提前收录回复语句和功能语句
## 大致设计思路
在ArtificialFool类中 设计功能 业务层负责连接持久层 持久层来做各种增删改查 向业务层返回数据
