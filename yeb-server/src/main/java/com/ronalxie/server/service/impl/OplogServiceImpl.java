package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.Oplog;
import com.ronalxie.server.mapper.OplogMapper;
import com.ronalxie.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
