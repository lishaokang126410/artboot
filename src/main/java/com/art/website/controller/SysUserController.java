package com.art.website.controller;

import com.art.website.model.SysUser;
import com.art.website.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: Li shaoKang
 * @CreateDate: 2022/07/20 21:18
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/userinfo/{id}")
    public String userinfo(@PathVariable("id") int id, HttpSession session,HttpServletRequest request){
        redisTemplate.boundValueOps("test").set("test");
        SysUser user=sysUserService.findSysUserById(id);
        request.setAttribute("SysUser", user);
        return "userlist";
    }

}
