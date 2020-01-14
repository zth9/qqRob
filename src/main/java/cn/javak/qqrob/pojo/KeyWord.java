package cn.javak.qqrob.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

public class KeyWord {
    private static String[] commands;
    public static Map<String, String[]> mapProblem;
    private static String[] iAm;
    private static String[] good;
    private static String[] signIn;

    public static String[] getCommands() {
        return commands;
    }

    public static void setCommands(String[] commands) {
        KeyWord.commands = commands;
    }

    public static Map<String, String[]> getMapProblem() {
        return mapProblem;
    }

    public static void setMapProblem(Map<String, String[]> mapProblem) {
        KeyWord.mapProblem = mapProblem;
    }

    public static String[] getiAm() {
        return iAm;
    }

    public static void setiAm(String[] iAm) {
        KeyWord.iAm = iAm;
    }

    public static String[] getGood() {
        return good;
    }

    public static void setGood(String[] good) {
        KeyWord.good = good;
    }

    static {
        commands = new String[]{
                "签到",
                "夸夸我",
                "自我介绍"
        };
        iAm = new String[]{
                "我是本群的人工智障",
                "我是一段无情的代码....",
                "我就是我",
        };
        good = new String[]{
                "想得美"
        };
        signIn = new String[]{
                "签到失败,该功能仍在开发中"
        };
        mapProblem = new LinkedHashMap<>();
        mapProblem.put("功能", commands);
        mapProblem.put("自我介绍", iAm);
        mapProblem.put("夸夸我", good);
        mapProblem.put("签到", signIn);
    }
}
