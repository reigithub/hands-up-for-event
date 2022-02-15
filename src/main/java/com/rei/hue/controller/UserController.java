package com.rei.hue.controller;

import java.util.ArrayList;
import java.util.List;

import com.rei.hue.model.User;
import com.rei.hue.dto.UserRequest;
import com.rei.hue.dto.UserUpdateRequest;
import com.rei.hue.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/user/add")
    public String displayAdd(Model model) {
      model.addAttribute("userRequest", new UserRequest());
      return "user/add";
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
        // 入力チェックエラーの場合
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "user/add";
      }
      // ユーザー情報の登録
      userService.create(userRequest);
      return "redirect:/user/list";
    }

    @GetMapping("/user/{id}")
    public String displayView(@PathVariable Long id, Model model) {
      User user = userService.findById(id);
      model.addAttribute("userData", user);
      return "user/view";
    }
    @GetMapping("/user/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {
      User user = userService.findById(id);
      UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
      userUpdateRequest.setId(user.getId());
      userUpdateRequest.setName(user.getName());
      userUpdateRequest.setPhone(user.getPhone());
      userUpdateRequest.setAddress(user.getAddress());
      model.addAttribute("userUpdateRequest", userUpdateRequest);
      return "user/edit";
    }

    /**
     * ユーザー更新
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "user/edit";
      }
      // ユーザー情報の更新
      userService.update(userUpdateRequest);
      return String.format("redirect:/user/%d", userUpdateRequest.getId());
    }

    /**
     * ユーザー情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/user/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
      // ユーザー情報の削除
      userService.delete(id);
      return "redirect:/user/list";
    }    
}
