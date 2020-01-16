package cn.javak.qqrob.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * Spring容器会在创建该Bean之后，自动调用该Bean的setApplicationContext方法
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if(BeanUtils.applicationContext == null) {
            BeanUtils.applicationContext = applicationContext;
        }
    }

    //获取applicationContext
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
