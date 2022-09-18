package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.Role;
import com.ronalxie.server.mapper.RoleMapper;
import com.ronalxie.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiesiyu
 * @since 2022-09-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
