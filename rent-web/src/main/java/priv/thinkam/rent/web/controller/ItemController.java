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
import priv.thinkam.rent.dao.model.Item;
import priv.thinkam.rent.dao.model.ItemExample;
import priv.thinkam.rent.dao.model.Stuff;
import priv.thinkam.rent.dao.model.User;
import priv.thinkam.rent.service.ItemService;
import priv.thinkam.rent.service.StuffService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by thinkam on 12/17/17.
 */
@RestController
@Api(value = "租用项管理", description = "租用项管理")
public class ItemController {
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private ItemService itemService;
	@Autowired
	private StuffService stuffService;

	@ApiOperation("租用清单")
	@GetMapping("items")
	public Result list() {
		List<Item> items = itemService.selectByExample(new ItemExample());
		return new Result(true, items);
	}

	@ApiOperation("租用申请")
	@PostMapping("/items")
	public Result add(@RequestBody Item item, HttpSession session) {
		//log记录信息
		logger.debug("method add get param:" + item);
		User user = (User) session.getAttribute(UserController.USER);
		//TODO:事务处理
		//设置数据
		item.setUserId(user.getUserId());
		item.setCreateTime(new Date());
		logger.debug("persist into DB:" + item);
		//persist into DB
		itemService.insert(item);
		//更改stuff状态
		Stuff stuff = stuffService.selectByPrimaryKey(item.getStuffId());
		stuff.setStatus((byte) 1);
		stuffService.updateByPrimaryKey(stuff);
		return new Result(true);
	}
}
