/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午4:56:14
 */
package com.aicent.fw.showcase.sys.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicent.fw.common.service.impl.BaseServiceImpl;
import com.aicent.fw.showcase.entity.User;
import com.aicent.fw.showcase.sys.user.dao.UserDao;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getByUserName(String username) {
		return userDao.findByUsername(username);
	}

}
