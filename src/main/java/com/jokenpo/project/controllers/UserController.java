package com.jokenpo.project.controllers;

import com.jokenpo.project.crud.UserCrud;
import com.jokenpo.project.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserCrud userCrud;

    @Autowired
    public UserController(UserCrud userCrud) {
        this.userCrud = userCrud;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postUser(String userName, Model model) {
        UserModel user = new UserModel();
        user.setId(2l);
        user.setUserName(userName);
        userCrud.saveAndFlush(user);
        model.addAttribute("userName", userName);
        return "index2";
    }
}
