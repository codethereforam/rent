package priv.thinkam.rent.service.impl;

import priv.thinkam.rent.common.annotation.BaseService;
import priv.thinkam.rent.common.base.BaseServiceImpl;
import priv.thinkam.rent.dao.mapper.CategoryMapper;
import priv.thinkam.rent.dao.model.Category;
import priv.thinkam.rent.dao.model.CategoryExample;
import priv.thinkam.rent.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CategoryService实现
* Created by thinkam on 17-12-19.
*/
@Service
@Transactional
@BaseService
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category, CategoryExample> implements CategoryService {

    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    CategoryMapper categoryMapper;

}