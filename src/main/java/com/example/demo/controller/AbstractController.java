package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractController<T, S extends IService<T>> {

    @Autowired
    protected S service;

    @GetMapping("/get/{id}")
    @Operation(summary = "详情")
    public ResponseEntity<T> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/dict")
    @Operation(summary = "词典数据")
    public ResponseEntity<Map<String, List<String>>> dict() {
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @DeleteMapping("/deleteByLogic/{id}")
    @Operation(summary = "逻辑删除")
    public ResponseEntity<Boolean> deleteByLogic(@PathVariable("id") Long id) {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("del_flag", true);
        return ResponseEntity.ok(service.update(updateWrapper));
    }
}
