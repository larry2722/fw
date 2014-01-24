/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午4:56:14
 */
package org.larry.fw.showcase.sys.user.service;

import org.larry.fw.common.service.impl.BaseServiceImpl;
import org.larry.fw.showcase.entity.User;
import org.larry.fw.showcase.sys.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getByUserName(String username) {
		return userDao.findByUsername(username);
	}

}
