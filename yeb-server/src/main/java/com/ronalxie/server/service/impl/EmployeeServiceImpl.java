package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.Employee;
import com.ronalxie.server.mapper.EmployeeMapper;
import com.ronalxie.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
