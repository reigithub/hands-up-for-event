package com.rei.hue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@EntityScan("com.rei.hue.model")
@EnableJpaRepositories("com.rei.hue.repository") 
@SpringBootApplication
@Controller
public class HueApplication {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String redirect() {
      return "index";
    }

    public static void main(String[] args) {
      SpringApplication.run(HueApplication.class, args);
    }
}