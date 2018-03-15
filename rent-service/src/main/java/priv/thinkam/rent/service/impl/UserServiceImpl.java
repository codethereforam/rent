package priv.thinkam.rent.service.impl;

import priv.thinkam.rent.common.annotation.BaseService;
import priv.thinkam.rent.common.base.BaseServiceImpl;
import priv.thinkam.rent.dao.mapper.UserMapper;
import priv.thinkam.rent.dao.model.User;
import priv.thinkam.rent.dao.model.UserExample;
import priv.thinkam.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserService实现
* Created by thinkam on 17-12-19.
*/
@Service
@Transactional
@BaseService
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User, UserExample> implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

}