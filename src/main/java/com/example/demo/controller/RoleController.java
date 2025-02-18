package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.IRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author tanpenggood
 * @since 2025-02-18
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController<Role, IRoleService> {

}
