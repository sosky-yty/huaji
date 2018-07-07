package com.skypointer.huaji.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationEnvironmentPreparedEvent){
            logger.debug("正在初始化环境变量");
        }else if (event instanceof  ApplicationPreparedEvent){
            logger.debug("环境变量初始话完成");
        }else if (event instanceof ContextRefreshedEvent){
            logger.debug("应用刷新完成");
        }else if (event instanceof ApplicationReadyEvent){
            logger.debug("应用启动完成");
        }else if (event instanceof ContextStartedEvent){
            logger.debug("应用实例启动完成");
        }else if (event instanceof ContextStoppedEvent){
            logger.debug("应用实例停止");
        }else if (event instanceof ContextClosedEvent){
            logger.debug("应用实例关闭");
        }
    }
}
