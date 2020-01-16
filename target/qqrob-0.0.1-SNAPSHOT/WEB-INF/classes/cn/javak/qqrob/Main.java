package cn.javak.qqrob;

import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;
import cn.javak.qqrob.listener.RobListener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments var1) throws Exception{
        // 创建机器人对象 ( 传入配置 ) 传入上报端口
        PicqBotX bot = new PicqBotX(new PicqConfig(30000).setDebug(true));

        // 添加一个机器人账户 ( 名字, 发送URL, 发送端口 )
        bot.addAccount("easier", "127.0.0.1", 6000);

        // 注册事件监听器, 可以注册多个监听器
        bot.getEventManager().registerListeners(
                new RobListener()
        );
        // 启动机器人, 不会占用主线程
        bot.startBot();
    }
}
