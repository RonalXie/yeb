package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.Department;
import com.ronalxie.server.mapper.DepartmentMapper;
import com.ronalxie.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
