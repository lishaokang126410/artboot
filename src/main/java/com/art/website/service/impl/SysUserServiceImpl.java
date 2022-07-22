package com.art.website.service.impl;

import com.art.website.mapper.SysUserMapper;
import com.art.website.model.SysUser;
import com.art.website.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Li shaoKang
 * @CreateDate: 2022/07/20 21:18
 * @Version: 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findSysUserById(int id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
