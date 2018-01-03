package priv.thinkam.rent.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import priv.thinkam.rent.common.base.Result;
import priv.thinkam.rent.dao.model.Stuff;
import priv.thinkam.rent.dao.model.StuffExample;
import priv.thinkam.rent.service.CategoryService;
import priv.thinkam.rent.service.StuffService;

import java.util.List;

/**
 * Created by thinkam on 12/17/17.
 */
@RestController
@Api(value = "物品管理", description = "物品管理")
public class StuffController {
	private static Logger logger = LoggerFactory.getLogger(StuffController.class);
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StuffService stuffService;

	@ApiOperation("物品列表")
	@GetMapping("/stuff")
	public Result list() {
		List<Stuff> stuff = stuffService.selectByExample(new StuffExample());
		return new Result(true, stuff);
	}

	@ApiOperation("添加物品")
	@PostMapping("/stuff")
	public Result add(@RequestBody Stuff stuff) {
		//log
		logger.debug("method add get param:" + stuff);
		//判断空 trim 判断已有 判断类别、状态
		//插入DB
		stuffService.insert(stuff);
		//返回添加的对象
		StuffExample stuffExample = new StuffExample();
		stuffExample.createCriteria().andNameEqualTo(stuff.getName());
		int id = stuffService.selectByExample(stuffExample).get(0).getStuffId();
		stuff.setStuffId(id);
		return new Result(true, stuff);
	}
}
