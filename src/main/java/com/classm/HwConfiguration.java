package com.classm;


import com.classm.filter.CorsFilter;
import com.classm.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HwConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }


    @Bean
    public FilterRegistrationBean<CorsFilter> loggingFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
