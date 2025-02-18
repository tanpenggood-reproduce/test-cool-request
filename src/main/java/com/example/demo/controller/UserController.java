package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tanpenggood
 * @since 2025-02-18
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, IUserService> {


    @GetMapping("/hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("ok");
    }

}
