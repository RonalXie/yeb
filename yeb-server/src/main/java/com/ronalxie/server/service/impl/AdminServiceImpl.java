package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.Admin;
import com.ronalxie.server.mapper.AdminMapper;
import com.ronalxie.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiesiyu
 * @since 2022-09-18
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
