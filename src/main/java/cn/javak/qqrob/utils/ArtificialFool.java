package cn.javak.qqrob.utils;

import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cn.javak.qqrob.pojo.KeyWord;

import java.util.Arrays;
import java.util.Random;

public class ArtificialFool {
    private static Random random = new Random();
    public String answer(EventGroupMessage event){
        String message = event.message;
        if (isAt(message)){
            String trueMessage = message.substring(message.indexOf("]")+1).trim();
            System.out.println("<--"+trueMessage);
            String[] results = checkCommand(trueMessage);
            if (results!=null){
                return results[random.nextInt(results.length)];
            }else {
                return "小易听不懂,你可以这样对我说:\r\n"+ Arrays.toString(KeyWord.getCommands());
            }
        }
        return null;
    }
    //检验是否为@自己
    public boolean isAt(String message){
        if (message.startsWith("[CQ:at,qq=1342246315]")){
            System.out.println("群私聊");
            return true;
        }
        System.out.println("什么都没有发生");
        return false;
    }
    //检验是否为命令

    /**
     * 如果是命令,返回命令内容
     * 否则返回null
     */
    public String[] checkCommand(String message){
        for (String command: KeyWord.getMapProblem().keySet()){
            if (message.equals(command)){
                return KeyWord.getMapProblem().get(command);
            }
        }
        return null;
    }
}
