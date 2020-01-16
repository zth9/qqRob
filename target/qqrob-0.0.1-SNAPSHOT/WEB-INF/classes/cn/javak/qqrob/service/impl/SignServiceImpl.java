package cn.javak.qqrob.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.javak.qqrob.mapper.SignMapper;
import cn.javak.qqrob.pojo.Sign;
import cn.javak.qqrob.service.SignService;
import cn.javak.qqrob.utils.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignServiceImpl implements SignService {

    private static SignMapper signMapper = (SignMapper) BeanUtils.getBean("signMapper");


    private static SimpleDateFormat simpleDateFormat;
    static {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
    @Override
    public int sign(Sign sign) throws ParseException {
        //签到状态码 1成功 0失败
        int result;
        //查询该用户签到信息
        System.out.println("正在查询该用户签到信息...");
        Sign signSel = signMapper.selSign(sign);
        if (signSel !=null){
            //非首次签到
            System.out.println("检测到非首次签到");
            String leastSignTime = signSel.getLeastSignTime();
            //获取最近签到时间
            Date date = simpleDateFormat.parse(leastSignTime);
            //如果不是同一天
            if (!DateUtil.isSameDay(date, new Date())){
                signMapper.updSign(sign);
                //返回加上本次签到的签到次数
                result = signSel.getSignCount()+1;
            }else {
                //如果是同一天
                result = 0;
            }
        }else {
            System.out.println("检测到首次签到...");
            //首次签到
            result = signMapper.insSignFirst(sign);
        }
        return result;
    }
}
