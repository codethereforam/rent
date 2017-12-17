package priv.thinkam.rent.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.thinkam.rent.common.base.Result;
import priv.thinkam.rent.dao.model.User;
import priv.thinkam.rent.dao.model.UserExample;
import priv.thinkam.rent.service.impl.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户登录控制器
 * Created by thinkam on 12/17/17.
 */
@RestController
@Api(value = "用户管理", description = "用户管理")
public class UserController {
	private static final String IS_LOGIN = "is_login";
	private static final String TRUE = "true";
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@ApiOperation("登录")
	@PostMapping("/sessions")
	public Result login(@RequestBody User user, HttpSession session) {
		//log记录信息
		logger.debug("method login get param:" + user);
		//通过session判断是否已登录
		if (TRUE.equals(session.getAttribute(IS_LOGIN))) {
			return new Result(false, "您已登录！");
		}
		//获取参数并trim必要的参数
		String username = StringUtils.trim(user.getUsername());
		String password = StringUtils.trim(user.getPassword());
		//认证并返回结果
		if(username == null || password == null) {
			return new Result(false, "密码和用户名不能为空");
		}
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		List<User> users = userService.selectByExample(userExample);
		User u = users.size() == 0 ? null : users.get(0);
		if (u == null) {
			return new Result(false, "用户名不存在");
		}
		if (!u.getPassword().equals(password)) {
			return new Result(false, "密码和用户名不匹配");
		}
		//session记录登录信息
		session.setAttribute(IS_LOGIN, TRUE);
		return new Result(true, u);
	}

	@ApiOperation("退出登录")
	@DeleteMapping("/sessions")
	public Result logout(HttpSession session) {
		//session移除登录信息
		session.removeAttribute(IS_LOGIN);
		logger.debug(IS_LOGIN + ":" + session.getAttribute(IS_LOGIN));
		return new Result(true);
	}

	//用于测试
	@ApiOperation("退出登录")
	@GetMapping("/logout")
	public void testLogout(HttpSession session) {
		//session移除登录信息
		session.removeAttribute(IS_LOGIN);
		logger.debug(IS_LOGIN + ":" + session.getAttribute(IS_LOGIN));
	}
}
