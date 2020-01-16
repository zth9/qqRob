package cn.javak.qqrob.listener;

import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.event.events.message.EventPrivateMessage;
import cc.moecraft.icq.event.events.request.EventGroupAddRequest;
import cc.moecraft.icq.event.events.request.EventGroupInviteRequest;
import cc.moecraft.icq.sender.IcqHttpApi;
import cn.javak.qqrob.utils.ArtificialFool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class RobListener extends IcqListener {
    private static ArtificialFool artificialFool = new ArtificialFool();
    //监听私聊信息
    @EventHandler
    public void privateMessage(EventPrivateMessage event){
        System.out.println("监听到私聊信息");
        event.respond(event.getMessage());
    }
    //监听群聊信息
    @EventHandler
    public void groupMsg(EventGroupMessage event){
        System.out.println("监听到群聊消息...");
        String answer = artificialFool.answer(event);
        if (answer!=null){
            System.out.println("-->"+answer);
            event.respond(answer);
        }
    }
    //监听拉入群请求事件
    @EventHandler
    public void joinGroup(EventGroupInviteRequest event){
        System.out.println("监听到拉入群请求信息...");
//        event.accept();
//        event.getBot().getAccountManager().refreshCache();
        event.reject("测试用机器人,联系QQ:942546014获取[正版]小易群管理机器人");
    }
}
