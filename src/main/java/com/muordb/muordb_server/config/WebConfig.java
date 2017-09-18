package com.muordb.muordb_server.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.muordb.muordb_server.gson.LocalDateAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.time.LocalDate;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.muordb.muordb_server")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter< ? >> converters) {
        GsonHttpMessageConverter msgConverter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                //        .excludeFieldsWithoutExposeAnnotation()
                //        .registerTypeAdapter(User.class, new UserAdapter())
                //        .registerTypeAdapter(Project.class, new ProjectAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        msgConverter.setGson(gson);
        converters.add(msgConverter);
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
