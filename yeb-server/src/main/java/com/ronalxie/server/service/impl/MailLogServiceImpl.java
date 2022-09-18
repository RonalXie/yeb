package com.ronalxie.server.service.impl;

import com.ronalxie.server.entity.MailLog;
import com.ronalxie.server.mapper.MailLogMapper;
import com.ronalxie.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
