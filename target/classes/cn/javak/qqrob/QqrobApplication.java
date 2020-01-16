package cn.javak.qqrob;

import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;
import cn.javak.qqrob.listener.RobListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class QqrobApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(QqrobApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
