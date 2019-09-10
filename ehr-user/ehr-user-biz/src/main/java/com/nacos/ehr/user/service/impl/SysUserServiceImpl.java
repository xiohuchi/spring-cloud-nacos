package com.nacos.ehr.user.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nacos.ehr.user.api.dto.UserDTO;
import com.nacos.ehr.user.api.entity.SysUser;
import com.nacos.ehr.user.api.vo.UserVO;
import com.nacos.ehr.user.mapper.SysUserMapper;
import com.nacos.ehr.user.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * ehr
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public UserInfo findUserInfo(SysUser sysUser) {
        return null;
    }

    @Override
    public IPage getUsersWithRolePage(Page page, UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean deleteUserById(SysUser sysUser) {
        return null;
    }

    @Override
    public R<Boolean> updateUserInfo(UserDTO userDto) {
        return null;
    }

    @Override
    public Boolean updateUser(UserDTO userDto) {
        return null;
    }

    @Override
    public UserVO selectUserVoById(Integer id) {
        return null;
    }

    @Override
    public List<SysUser> listAncestorUsers(String username) {
        return null;
    }

    @Override
    public Boolean saveUser(UserDTO userDto) {
        return null;
    }
}
