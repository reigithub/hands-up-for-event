package com.rei.hue.controller;

import java.util.List;

import com.rei.hue.entity.User;
import com.rei.hue.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String displayList(Model model) {
        List<User> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "user/list";
      }    
    // public String index(@RequestParam(name="name", required=false, defaultValue="Worlded") String name, Model model) {
	// 	model.addAttribute("name", name);
    //     return "index";
    // }
}
