package cn.javak.qqrob.service;

import cn.javak.qqrob.pojo.Sign;

import java.text.ParseException;

public interface SignService {
    //签到
    int sign(Sign sign) throws ParseException;
}
