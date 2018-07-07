package com.skypointer.huaji.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.skypointer.huaji.config.intercepter.CommonIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private CommonIntercepter intercepter;

    /**
     *  fastjson 对象转换json规则配置
     * @return
     */
    private FastJsonConfig getFastJsonConfig(){
        FastJsonConfig config = new FastJsonConfig();
        List<SerializerFeature> serializerFeatures =  new ArrayList<SerializerFeature>();
        serializerFeatures.add(SerializerFeature.PrettyFormat);
        //XXX为空打印null
        serializerFeatures.add(SerializerFeature.WriteMapNullValue);
        serializerFeatures.add(SerializerFeature.WriteNullListAsEmpty);
        serializerFeatures.add(SerializerFeature.WriteNullStringAsEmpty);
        serializerFeatures.add(SerializerFeature.DisableCircularReferenceDetect);
        SerializerFeature [] serializerFeatures_a = serializerFeatures.toArray(new SerializerFeature[serializerFeatures.size()]);
        config.setSerializerFeatures(serializerFeatures_a);

        return config;
    }


    /**
     * 配置转换对象
     * @return
     */
    private FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4(){
        FastJsonHttpMessageConverter4 converter4 = new FastJsonHttpMessageConverter4();
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.parseMediaType("text/html;charset=utf-8"));
        mediaTypes.add(MediaType.parseMediaType("application/json"));

        converter4.setFastJsonConfig(getFastJsonConfig());

        return converter4;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter4());
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有路径 /**
        registry.addInterceptor(intercepter).addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new OpenEntityManagerInViewFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
