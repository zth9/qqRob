package cn.javak.qqrob.utils;

import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cn.javak.qqrob.pojo.KeyWord;
import cn.javak.qqrob.pojo.Sign;
import cn.javak.qqrob.service.SignService;
import cn.javak.qqrob.service.impl.SignServiceImpl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;

public class ArtificialFool {
    private static Random random = new Random();

    private static SignService signServiceImpl = new SignServiceImpl();

    //回复消息
    public String answer(EventGroupMessage event){
        String message = event.message;
        //检测到@消息
        if (isAt(message)){
            String trueMessage = message.substring(message.indexOf("]")+1).trim();
            System.out.println("<--"+trueMessage);
            String[] results = checkCommand(trueMessage);
            if (results!=null){
                if (results[0].equals("签到")){
                    try {
                        Sign curSign = new Sign(
                                String.valueOf(event.getSender().getId()),
                                String.valueOf(event.getGroup().getId()));
                        int signCount = signServiceImpl.sign(curSign);
                        System.out.println("签到状态码-->"+signCount);
                        if (signCount>0){
                            return "恭喜["+event.getSender().getInfo().getNickname()+"],签到成功,金币+10" +
                                    "\r\n已累计签到["+signCount+"]次,持有金币["+signCount*10+"]个";
                        }else {
                            return "["+event.getSender().getInfo().getNickname()+"] 今日已完成签到,明天再来吧";
                        }
                    } catch (ParseException e) {
                        return "服务器繁忙,暂时无法签到";
                    }
                }
                return results[random.nextInt(results.length)];
            }else {
                return "小易听不懂,你可以这样对我说:\r\n"+ Arrays.toString(KeyWord.getCommands());
            }
        }
        return null;
    }
    //检验是否为@自己
    public static boolean isAt(String message){
        if (message.startsWith("[CQ:at,qq=1342246315]")){
            System.out.println("群私聊");
            return true;
        }
        System.out.println("什么都没有发生");
        return false;
    }
    //检验是否为命令
    /**
     * 如果是命令,返回命令内容数组
     * 否则返回null
     */
    public static String[] checkCommand(String message){
        for (String command: KeyWord.getMapProblem().keySet()){
            if (message.equals(command)){
                return KeyWord.getMapProblem().get(command);
            }
        }
        return null;
    }
}
