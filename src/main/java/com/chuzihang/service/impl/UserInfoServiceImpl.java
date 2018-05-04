package com.chuzihang.service.impl;

import com.chuzihang.core.ret.ServiceException;
import com.chuzihang.core.universal.AbstractService;
import com.chuzihang.dao.UserInfoMapper;
import com.chuzihang.model.UserInfo;
import com.chuzihang.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/4/27 15:22
 **/
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }
}
