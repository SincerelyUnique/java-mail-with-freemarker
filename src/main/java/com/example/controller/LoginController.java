/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.controller;

import com.example.domain.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * <code>LoginController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/26 14:14
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView login(UserVo userVo){
        try {
            ModelAndView modelAndView = new ModelAndView();
            String username = userVo.getUsername();
            String password = userVo.getPassword();
            if ( !StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) ){
                modelAndView.setViewName("home/home");
            }
            return modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("indexUI")
    public String index(){
        return "home/home";
    }
}
