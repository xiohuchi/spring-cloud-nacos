package com.nacos.ehr.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.nacos.ehr.user.api.entity.SysUser;
import com.nacos.ehr.user.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * ehr
 */
@RestController
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块")
public class SysUserController {

    @Resource
    private SysUserService userService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @GetMapping("/tokenHead/test")
    public R test() {
        return R.ok("tokenHead");
    }

    /**
     * 通过ID查询用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public R user(@PathVariable Integer id) {
        return R.ok(userService.selectUserVoById(id));
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/details/{username}")
    public R user(@PathVariable String username) {
        SysUser condition = new SysUser();
        condition.setUsername(username);
        return R.ok(userService.getOne(new QueryWrapper<>(condition)));
    }

}
