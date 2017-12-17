package priv.thinkam.rent.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import priv.thinkam.rent.dao.model.UserExample;

import javax.annotation.Resource;

/**
 * Created by thinkam on 12/17/17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({
		"classpath:applicationContext-jdbc.xml",
		"classpath:applicationContext.xml",
		"classpath:applicationContext-listener.xml"
})
@Transactional(transactionManager = "transactionManager")
public class UserServiceImplTest {
	@Resource
	private UserService userService;

	@Test
	public void testSelectByExample() {
		userService.selectByExample(new UserExample()).forEach(System.out::println);
	}
}