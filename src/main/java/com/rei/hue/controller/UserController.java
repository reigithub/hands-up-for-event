package com.rei.hue.controller;

import java.util.List;

import com.rei.hue.model.User;
import com.rei.hue.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/user/list")
    public String displayList(Model model) {
        List<User> userlist = userService.findAll();
        model.addAttribute("userlist", userlist);
        return "user/list";
      }
}
