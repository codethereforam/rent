package priv.thinkam.rent.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.thinkam.rent.common.base.Result;
import priv.thinkam.rent.dao.model.Category;
import priv.thinkam.rent.dao.model.CategoryExample;
import priv.thinkam.rent.service.CategoryService;

import java.util.List;

/**
 * Created by thinkam on 12/17/17.
 */
@RestController
@Api(value = "类别管理", description = "类别管理")
public class CategoryController {
	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryService;

	@ApiOperation("添加类别")
	@PostMapping("/categories")
	public Result add(@RequestBody Category category) {
		//log记录信息
		logger.debug("method add get param:" + category);
		//判断空
		if(StringUtils.isBlank(category.getName())) {
			return new Result(false, "类别名称不能为空");
		}
		//trim参数
		String name = StringUtils.trim(category.getName());
		//判断已有
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andNameEqualTo(name);
		List<Category> categories = categoryService.selectByExample(categoryExample);
		if(!categories.isEmpty()) {
			return new Result(false, "该类别已存在");
		}
		//插入DB
		category.setName(name);
		categoryService.insert(category);
		CategoryExample categoryExample1 = new CategoryExample();
		categoryExample1.createCriteria().andNameEqualTo(name);
		Category c = categoryService.selectByExample(categoryExample1).get(0);
		return new Result(true, c);
	}

	@ApiOperation("展现类别")
	@GetMapping("/categories")
	public Result list() {
		List<Category> categories = categoryService.selectByExample(new CategoryExample());
		return new Result(true, categories);
	}

	@ApiOperation("删除类别")
	@DeleteMapping("/categories/{id}")
	public Result delete(@PathVariable int id) {
		//log记录信息
		logger.debug("method delete get param:id=" + id);
		categoryService.deleteByPrimaryKey(id);
		return new Result(true);
	}

	@ApiOperation("修改类别")
	@PatchMapping("/categories/{id}")
	public Result modify(@PathVariable int id, @RequestBody Category category) {
		//log记录信息
		logger.debug("method delete get param:id=" + id + "," + category);
		//判断是否存在
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andNameEqualTo(category.getName());
		List<Category> categories = categoryService.selectByExample(categoryExample);
		if(!categories.isEmpty()) {
			return new Result(false, "该类别已存在");
		}
		//update
		category.setCategoryId(id);
		categoryService.updateByPrimaryKey(category);
		return new Result(true, category);
	}
}
