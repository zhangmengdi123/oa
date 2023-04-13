package com.zmd.auth.service.impl;

import com.zmd.auth.entity.SysUser;
import com.zmd.auth.mapper.SysUserMapper;
import com.zmd.auth.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zmd
 * @since 2023-04-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
