package kr.co.rland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
    WebMvcConfigurer config = new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
//            WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.0.73:5500","http://192.168.0.73:5501",
                        "http://127.0.0.1:5500","http://127.0.0.1:5501")
                .allowedMethods("GET","POST","DELETE");
            //이거 안쓰면 HTTP가 지원하는 기본 메소드(get, post)만 사용 가능함.

        }
    };
        return config;
    }
}
