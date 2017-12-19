package priv.thinkam.rent.service.impl;

import priv.thinkam.rent.common.annotation.BaseService;
import priv.thinkam.rent.common.base.BaseServiceImpl;
import priv.thinkam.rent.dao.mapper.StuffMapper;
import priv.thinkam.rent.dao.model.Stuff;
import priv.thinkam.rent.dao.model.StuffExample;
import priv.thinkam.rent.service.StuffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* StuffService实现
* Created by thinkam on 17-12-19.
*/
@Service
@Transactional
@BaseService
public class StuffServiceImpl extends BaseServiceImpl<StuffMapper, Stuff, StuffExample> implements StuffService {

    private static Logger _log = LoggerFactory.getLogger(StuffServiceImpl.class);

    @Autowired
    StuffMapper stuffMapper;

}