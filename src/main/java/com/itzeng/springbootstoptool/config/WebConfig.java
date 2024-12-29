package com.itzeng.springbootstoptool.config;

import com.itzeng.springbootstoptool.Json.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

//最高级别同时解决Swagger和跨域问题不用configurt实现接口 注：这个里面的东西别乱动哈-陈振楠
@Slf4j
@Configuration //当前类是配置类
public class WebConfig extends WebMvcConfigurationSupport {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许所有路径进行跨域请求
        log.info("跨域请求已启动");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // 前端开发服务器地址
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的HTTP方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 是否允许携带凭证（如 cookie）
    }

    @Bean
    public Docket docket() {
        log.info("准备生成接口文档");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("停车管理接口文档")
                .version("2.0")
                .description("停车管理接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itzeng.springbootstoptool.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * 设置静态资源映射
     *
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始设置静态资源映射");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    //重写父类的一个方法
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        //创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //需要为消息转换器设置一个对象转换器，对象转换器可以将java对象序列化为Json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将自己的消息转换器加入容器中
        converters.add(0, converter);
    }



}

