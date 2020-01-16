package cn.javak.qqrob.mapper;

import cn.javak.qqrob.pojo.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SignMapper {
    //查询签到信息
    @Select("select * from user_group_sign where userAcc=#{userAcc} and groupAcc=#{groupAcc}")
    Sign selSign(Sign sign);
    //首次签到
    @Insert("insert into user_group_sign values(default, #{userAcc}, #{groupAcc}, 1, now())")
    int insSignFirst(Sign sign);
    //非首次签到
    @Update("update user_group_sign set signCount = signCount+1,leastSignTime = now() where userAcc=#{userAcc} and groupAcc=#{groupAcc}")
    int updSign(Sign sign);
}
