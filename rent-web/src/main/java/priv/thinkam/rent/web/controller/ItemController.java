package priv.thinkam.rent.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

	@ApiOperation("删除租用项")
	@DeleteMapping("items/{id}")
	public Result delete(@PathVariable int id) {
		//log
		logger.debug("method add get param id:" + id);
		//delete item
		Item item = itemService.selectByPrimaryKey(id);
		itemService.deleteByPrimaryKey(id);
		//TODO:优化更新操作
		//change stuff status
		Stuff stuff = stuffService.selectByPrimaryKey(item.getStuffId());
		stuff.setStatus((byte) 0);
		stuffService.updateByPrimaryKey(stuff);
		return new Result(true);
	}

	@ApiOperation("我的租用清单")
	@GetMapping("items/mine")
	public Result myList(HttpSession session) {
		User user = (User) session.getAttribute(UserController.USER);
		ItemExample itemExample = new ItemExample();
		itemExample.createCriteria().andUserIdEqualTo(user.getUserId());
		List<Item> items = itemService.selectByExample(itemExample);
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
		item.setApplyTime(new Date());
		item.setStatus((byte) 0);
		logger.debug("persist into DB:" + item);
		//persist into DB
		itemService.insert(item);
		//更改stuff状态
		Stuff stuff = stuffService.selectByPrimaryKey(item.getStuffId());
		stuff.setStatus((byte) 1);
		stuffService.updateByPrimaryKey(stuff);
		return new Result(true);
	}

	@ApiOperation("修改状态")
	@PutMapping("/items/{id}/status")
	public Result modifyStatus(@RequestBody Item item, @PathVariable int id) {
		//log记录信息
		int status = item.getStatus();
		logger.debug("method add get param status:" + status + ",id=" + id);
		//select
		Item it = itemService.selectByPrimaryKey(id);
		Stuff stuff = stuffService.selectByPrimaryKey(it.getStuffId());
		//modify item: createTime status endTime & modify stuff: status
		switch (status) {
			//否定
			case 1:
				it.setStatus((byte) 1);
				itemService.updateByPrimaryKey(it);
				stuff.setStatus((byte) 0);
				stuffService.updateByPrimaryKey(stuff);
				break;
			//批准
			case 2:
				it.setStatus((byte) 2);
				it.setCreateTime(new Date());
				itemService.updateByPrimaryKey(it);
				stuff.setStatus((byte) 2);
				stuffService.updateByPrimaryKey(stuff);
				break;
			//归还
			case 3:
				it.setStatus((byte) 3);
				it.setEndTime(new Date());
				itemService.updateByPrimaryKey(it);
				stuff.setStatus((byte) 0);
				stuffService.updateByPrimaryKey(stuff);
				break;
			default:
		}
		return new Result(true);
	}
}
