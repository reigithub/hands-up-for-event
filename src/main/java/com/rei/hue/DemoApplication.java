package com.rei.hue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EntityScan("com.rei.hue.model")
@EnableJpaRepositories("com.rei.hue.repository") 
@SpringBootApplication // (scanBasePackages = {"com.rei.hue.controller"})
@Controller
// public class DemoApplication extends SpringBootServletInitializer {
public class DemoApplication {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String redirect() {
      return "index";
    }

    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }

    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //   return application.sources(DemoApplication.class);
    // }    

}