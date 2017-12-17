package priv.thinkam.rent.service.impl;

import priv.thinkam.rent.common.annotation.BaseService;
import priv.thinkam.rent.common.base.BaseServiceImpl;
import priv.thinkam.rent.dao.mapper.ItemMapper;
import priv.thinkam.rent.dao.model.Item;
import priv.thinkam.rent.dao.model.ItemExample;
import priv.thinkam.rent.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ItemService实现
* Created by thinkam on 17-12-18.
*/
@Service
@Transactional
@BaseService
public class ItemServiceImpl extends BaseServiceImpl<ItemMapper, Item, ItemExample> implements ItemService {

    private static Logger _log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    ItemMapper itemMapper;

}